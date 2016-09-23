/**
 * 
 */
package org.syl.tryredis.subpub;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import redis.clients.jedis.JedisPubSub;

/**
 * 
 * 消息订阅者
 * 
 * jedis中的JedisPubSub抽象类提供了订阅和取消的功能。想处理订阅和取消订阅某些channel的相关事件，我们得扩展JedisPubSub类并实现相关的方法：
 * @author megapro
 *
 */
public class Subscriber extends JedisPubSub {

	private static final Logger LOGGER = LoggerFactory.getLogger(Subscriber.class);

    @Override
    public void onMessage(String channel, String message) {
    	LOGGER.info(String.format("Message. Channel: %s, Msg: %s", channel, message));
    }

    @Override
    public void onPMessage(String pattern, String channel, String message) {
    	LOGGER.info(String.format("PMessage. Pattern: %s, Channel: %s, Msg: %s", 
    	    pattern, channel, message));
    }

    @Override
    public void onSubscribe(String channel, int subscribedChannels) {
    	LOGGER.info("onSubscribe");
    }

    @Override
    public void onUnsubscribe(String channel, int subscribedChannels) {
    	LOGGER.info("onUnsubscribe");
    }

    @Override
    public void onPUnsubscribe(String pattern, int subscribedChannels) {
    	LOGGER.info("onPUnsubscribe");
    }

    @Override
    public void onPSubscribe(String pattern, int subscribedChannels) {
    	LOGGER.info("onPSubscribe");
    }
}
