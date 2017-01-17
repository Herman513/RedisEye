package org.rediseye.config;

/**
 * Date: 2016/12/26 下午5:51
 * Usage:
 */

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisClusterConnection;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;

@Configuration
public class RedisClusterConfig {
    //    @Value("${spring.entity.cluster.nodes}")
//    private String clusterNodes;
//
//    @Bean("redisClusterConfiguration")
//    public RedisClusterConfiguration redisClusterConfiguration() {
//        RedisClusterConfiguration redisClusterConfiguration = new RedisClusterConfiguration();
//        return redisClusterConfiguration;
//    }
//
//    @Bean("jedisPoolConfig")
//    public JedisPoolConfig jedisPoolConfig() {
//        JedisPoolConfig jedisPoolConfig = new JedisPoolConfig();
//        return jedisPoolConfig;
//    }
//
//    @Bean("jedisConnectionFactory")
//    public JedisConnectionFactory jeidsConnectionFactory(JedisPoolConfig jedisPoolConfig, RedisClusterConfiguration redisClusterConfiguration) {
//        return new JedisConnectionFactory(redisClusterConfiguration, jedisPoolConfig);
//    }
//
//    @Bean("redisTemplate")
//    public RedisTemplate redisTemplate(JedisConnectionFactory jedisConnectionFactory) {
//        RedisTemplate redisTemplate = new RedisTemplate();
//        redisTemplate.setConnectionFactory(jedisConnectionFactory);
//        return redisTemplate;
//    }
    @Bean("redisClusterConnection")
    public RedisClusterConnection redisClusterConnection(JedisConnectionFactory jedisConnectionFactory) {
        return jedisConnectionFactory.getClusterConnection();
    }

}
