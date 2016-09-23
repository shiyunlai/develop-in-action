/**
 * 
 */
package org.syl.redis;

import java.util.Arrays;
import java.util.List;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPoolConfig;
import redis.clients.jedis.JedisShardInfo;
import redis.clients.jedis.Pipeline;
import redis.clients.jedis.ShardedJedis;
import redis.clients.jedis.ShardedJedisPipeline;
import redis.clients.jedis.ShardedJedisPool;
import redis.clients.jedis.Transaction;

/**
 * <pre>
 * Redis的Java客户端Jedis八种调用方式
 * 
 * http://blog.csdn.net/truong/article/details/46711045
 * 
 * 测试环境： Macpro 
 * CPU：    Intel(R) Core(TM) i5-5257U CPU @ 2.70GHz
 * 内存：    8G
 * Redis：  127.0.0.1:6379  非集群/shard
 * 测试结果：
 * Simple@Sharing SET: 4.639 seconds
 * Pipelined transaction: 0.419 seconds
 * Simple@Pool SET: 3.396 seconds
 * Pipelined SET: 0.193 seconds
 * Pipelined@Pool SET: 0.224 seconds
 * Transaction SET: 0.27 seconds
 * Simple SET: 3.576 seconds
 * Pipelined@Sharing SET: 0.252 seconds
 * </pre>
 * @author megapro
 *
 */
public class TestRedisUse {
	
	private static Jedis jedis; 
    private static ShardedJedis sharding; 
    private static ShardedJedisPool pool; 

    @BeforeClass 
    public static void setUpBeforeClass() throws Exception { 
        List<JedisShardInfo> shards = Arrays.asList( 
                new JedisShardInfo("localhost",6379), 
                new JedisShardInfo("localhost",6379)); //使用相同的ip:port,仅作测试 


        jedis = new Jedis("localhost"); 
        sharding = new ShardedJedis(shards); 

        pool = new ShardedJedisPool(new JedisPoolConfig(), shards); 
    } 

    @AfterClass 
    public static void tearDownAfterClass() throws Exception { 
        jedis.disconnect(); 
        sharding.disconnect(); 
        pool.destroy(); 
    } 
    
    /**
     * 获取redis运行信息
     */
    //@Test
    public void testGetRedisInfo(){
    	System.out.println(jedis.info());
    }
    
    /**
     * 最简单和基础的调用方式,每次set之后都可以返回结果，标记是否成功。
     */
    @Test 
    public void test1Normal() { 
        long start = System.currentTimeMillis(); 
        for (int i = 0; i < 100000; i++) { 
            String result = jedis.set("n" + i, "n" + i); 
        } 
        long end = System.currentTimeMillis(); 
        System.out.println("Simple SET 100000 times : " + ((end - start)/1000.0) + " seconds"); 
    } 

    /**
     * redis的事务很简单，他主要目的是保障，一个client发起的事务中的命令可以连续的执行，而中间不会插入其他client的命令。 
     * 我们调用jedis.watch(…)方法来监控key，如果调用后key值发生变化，则整个事务会执行失败。
     * 另外，事务中某个操作失败，并不会回滚其他操作。这一点需要注意。还有，我们可以使用discard()方法来取消事务。 
     */
    @Test 
    public void test2Trans() { 
        long start = System.currentTimeMillis(); 
        Transaction tx = jedis.multi(); 
        for (int i = 0; i < 100000; i++) { 
            tx.set("t" + i, "t" + i); 
        } 
        //System.out.println(tx.get("t1000").get()); 

        List<Object> results = tx.exec(); 
        long end = System.currentTimeMillis(); 
        System.out.println("Transaction SET: " + ((end - start)/1000.0) + " seconds"); 
    } 

    /**
     * 异步方式，一次发送多个指令，不同步等待其返回结果。这样可以取得非常好的执行效率。这就是管道，调用方法如下： 
     * 
     * 通过pipeline方式当有大批量的操作时候。
     * 我们可以节省很多原来浪费在网络延迟的时间。
     * 需要注意到是用 pipeline方式打包命令发送，redis必须在处理完所有命令前先缓存起所有命令的处理结果。
     * 打包的命令越多，缓存消耗内存也越多。所以并是不是打包的命令越多越好。
     */
    @Test 
    public void test3Pipelined() { 
        Pipeline pipeline = jedis.pipelined(); 
        long start = System.currentTimeMillis(); 
        for (int i = 0; i < 100000; i++) { 
            pipeline.set("p" + i, "p" + i); 
        } 
        //System.out.println(pipeline.get("p1000").get()); 
        List<Object> results = pipeline.syncAndReturnAll(); 
        long end = System.currentTimeMillis(); 
        System.out.println("Pipelined SET: " + ((end - start)/1000.0) + " seconds"); 
    } 

    /**
     * 管道中调用事务 
     * 但是经测试（见本文后续部分），发现其效率和单独使用事务差不多，甚至还略微差点。 
     */
    @Test 
    public void test4combPipelineTrans() { 
        long start = System.currentTimeMillis(); 
        Pipeline pipeline = jedis.pipelined(); 
        pipeline.multi(); 
        for (int i = 0; i < 100000; i++) { 
            pipeline.set("" + i, "" + i); 
        } 
        pipeline.exec(); 
        List<Object> results = pipeline.syncAndReturnAll(); 
        long end = System.currentTimeMillis(); 
        System.out.println("Pipelined transaction: " + ((end - start)/1000.0) + " seconds"); 
    } 

    /**
     * 分布式直连同步调用
     * 这个是分布式直接连接，并且是同步调用，每步执行都返回执行结果。类似地，还有异步管道调用。
     */
    @Test 
    public void test5shardNormal() { 
        long start = System.currentTimeMillis(); 
        for (int i = 0; i < 100000; i++) { 
            String result = sharding.set("sn" + i, "n" + i); 
        } 
        long end = System.currentTimeMillis(); 
        System.out.println("Simple@Sharing SET: " + ((end - start)/1000.0) + " seconds"); 
    } 

    /**
     * 分布式直连异步调用
     */
    @Test 
    public void test6shardpipelined() { 
        ShardedJedisPipeline pipeline = sharding.pipelined(); 
        long start = System.currentTimeMillis(); 
        for (int i = 0; i < 100000; i++) { 
            pipeline.set("sp" + i, "p" + i); 
        } 
        List<Object> results = pipeline.syncAndReturnAll(); 
        long end = System.currentTimeMillis(); 
        System.out.println("Pipelined@Sharing SET: " + ((end - start)/1000.0) + " seconds"); 
    } 

    /**
     * 分布式连接池同步调用 （适用于2.2及以下版本）
     * 如果，你的分布式调用代码是运行在线程中，那么上面两个直连调用方式就不合适了，因为直连方式是非线程安全的，这个时候，你就必须选择连接池调用。 
     */
    @Test 
    public void test7shardSimplePool() { 
        ShardedJedis one = pool.getResource(); 

        long start = System.currentTimeMillis(); 
        for (int i = 0; i < 100000; i++) { 
            String result = one.set("spn" + i, "n" + i); 
        } 
        long end = System.currentTimeMillis(); 
        pool.returnResource(one); 
        System.out.println("Simple@Pool SET: " + ((end - start)/1000.0) + " seconds"); 
    } 

    /**
     * 分布式连接池异步调用 （适用于2.2及以下版本）
     * 
     */
    @Test 
    public void test8shardPipelinedPool() { 
        ShardedJedis one = pool.getResource(); 

        ShardedJedisPipeline pipeline = one.pipelined(); 

        long start = System.currentTimeMillis(); 
        for (int i = 0; i < 100000; i++) { 
            pipeline.set("sppn" + i, "n" + i); 
        } 
        List<Object> results = pipeline.syncAndReturnAll(); 
        long end = System.currentTimeMillis(); 
        pool.returnResource(one); 
        System.out.println("Pipelined@Pool SET: " + ((end - start)/1000.0) + " seconds"); 
    } 
    
    @Test
    public void testReport(){
    	StringBuffer sb = new StringBuffer() ; 
    	sb.append("事务和管道都是异步模式。在事务和管道中不能同步查询结果。比如下面两个调用，都是不允许的：").append("\n")
    	.append("事务和管道都是异步的，个人感觉，在管道中再进行事务调用，没有必要，不如直接进行事务模式。 ").append("\n")
    	.append("分布式中，连接池的性能比直连的性能略好(见后续测试部分)。 ") .append("\n")
    	.append("分布式调用中不支持事务。 ").append("\n")
    	.append("因为事务是在服务器端实现，而在分布式中，每批次的调用对象都可能访问不同的机器，所以，没法进行事务。").append("\n");
    	
    	System.out.println(sb.toString());
    	
    }

}
