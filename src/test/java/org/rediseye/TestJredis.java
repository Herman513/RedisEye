package org.rediseye;

import org.rediseye.redis.Server;
import org.rediseye.util.StringUtils;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import redis.clients.jedis.Jedis;

import java.util.ArrayList;
import java.util.Map;

/**
 * Date: 2016/12/14 下午4:26
 * Usage:
 */
public class TestJredis {
    @Autowired
    RedisTemplate<String, String> redisTemplate;
    @Test
    public void getInfo() {
        //连接 Redis 服务
        ArrayList<Server> servers= new ArrayList<>();
        servers.add(new Server("10.8.1.132", 7000));
        servers.add(new Server("10.8.1.132", 7001));
        servers.add(new Server("10.8.1.132", 7002));
        servers.add(new Server("10.8.1.132", 7003));
        servers.add(new Server("10.8.1.132", 7004));
        servers.add(new Server("10.8.1.132", 7005));


        ArrayList<Jedis> clients=new ArrayList<>();
        servers.forEach(o->clients.add(new Jedis(o.getHost(),o.getPort())));
        ArrayList<Map> infos=new ArrayList<>();

        clients.forEach(o->{
            try {
                String info = o.info();
                infos.add(StringUtils.getInfoMap(info));
            }catch (Exception e){

            }
        });

    }
    @Test
    public void testRedisConfig(){
        ValueOperations<String, String> opsForValue = redisTemplate.opsForValue();
//数据插入测试：
        Server server=new Server();
        server.setHost("111.11.1.1");
        opsForValue.set("test","ss");
        String  valueFromRedis = opsForValue.get("test");
        System.out.print(valueFromRedis);
    }

}
