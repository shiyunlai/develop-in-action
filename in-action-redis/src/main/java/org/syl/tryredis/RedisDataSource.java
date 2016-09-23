/**
 * 
 */
package org.syl.tryredis;

import redis.clients.jedis.ShardedJedis;

/**
 * @author megapro
 *
 */
public interface RedisDataSource {
	
	/**
	 * 取得redis的客户端，执行命令了。
	 * @return
	 */
	public abstract ShardedJedis getRedisClient();
	
	/**
	 * 将资源返还给pool
	 * @param shardedJedis
	 */
    public void returnResource(ShardedJedis shardedJedis);
    
    /**
     * 出现异常后，将资源返还给pool
     * @param shardedJedis
     * @param broken
     */
    public void returnResource(ShardedJedis shardedJedis,boolean broken);
}
