package org.syl.tryredis.cluster;

import java.util.HashSet;
import java.util.Properties;
import java.util.Set;
import java.util.regex.Pattern;

import org.apache.commons.pool2.impl.GenericObjectPoolConfig;
import org.springframework.beans.factory.FactoryBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.core.io.Resource;

import redis.clients.jedis.HostAndPort;
import redis.clients.jedis.JedisCluster;

/**
 * <pre>
 * jedisCluster 集群能力工厂类
 * 
 * FactoryBean<T>：实现了此接口的bean不能看做一个通常意义上的bean，
 * 一个FactoryBean虽然以bean的形式来定义，但它暴露的对象(getObject())通常是它创建的对象。
 * 
 * InitializingBean：实现此接口的bean在BeanFactory设置为它们的属性时只需要执行一次，
 * 例如：初始化定制或者仅仅检查必须存在的属性是否已经设置完成等等。
 * </pre>
 * @author megapro
 *
 */
public class JedisClusterFactory implements FactoryBean<JedisCluster>, InitializingBean {
	private Resource addressConfig;
	private String addressKeyPrefix;

	private JedisCluster jedisCluster;
	private Integer timeout;
	private Integer maxRedirections;
	private GenericObjectPoolConfig genericObjectPoolConfig;

	private Pattern p = Pattern.compile("^.+[:]\\d{1,5}\\s*$");

	//@Override
	public JedisCluster getObject() throws Exception {
		return jedisCluster;
	}

	//@Override
	public Class<? extends JedisCluster> getObjectType() {
		return (this.jedisCluster != null ? this.jedisCluster.getClass() : JedisCluster.class);
	}

	//@Override
	public boolean isSingleton() {
		return true;
	}

	private Set<HostAndPort> parseHostAndPort() throws Exception {
		try {
			Properties prop = new Properties();
			prop.load(this.addressConfig.getInputStream());

			Set<HostAndPort> haps = new HashSet<HostAndPort>();
			for (Object key : prop.keySet()) {

				if (!((String) key).startsWith(addressKeyPrefix)) {
					continue;
				}

				String val = (String) prop.get(key);

				boolean isIpPort = p.matcher(val).matches();

				if (!isIpPort) {
					throw new IllegalArgumentException("ip 或 port 不合法");
				}
				String[] ipAndPort = val.split(":");

				HostAndPort hap = new HostAndPort(ipAndPort[0], Integer.parseInt(ipAndPort[1]));
				haps.add(hap);
			}

			return haps;
		} catch (IllegalArgumentException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new Exception("解析 jedis 配置文件失败", ex);
		}
	}

	//@Override
	public void afterPropertiesSet() throws Exception {
		Set<HostAndPort> haps = this.parseHostAndPort();

		jedisCluster = new JedisCluster(haps, timeout, maxRedirections, genericObjectPoolConfig);
	}

	public void setAddressConfig(Resource addressConfig) {
		this.addressConfig = addressConfig;
	}

	public void setTimeout(int timeout) {
		this.timeout = timeout;
	}

	public void setMaxRedirections(int maxRedirections) {
		this.maxRedirections = maxRedirections;
	}

	public void setAddressKeyPrefix(String addressKeyPrefix) {
		this.addressKeyPrefix = addressKeyPrefix;
	}

	public void setGenericObjectPoolConfig(GenericObjectPoolConfig genericObjectPoolConfig) {
		this.genericObjectPoolConfig = genericObjectPoolConfig;
	}
}
