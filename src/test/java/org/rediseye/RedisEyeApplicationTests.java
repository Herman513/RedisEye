package org.rediseye;

import org.rediseye.Service.RedisInfoService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.connection.ClusterInfo;
import org.springframework.data.redis.connection.RedisClusterConnection;
import org.springframework.data.redis.connection.RedisClusterNode;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Properties;

@RunWith(SpringRunner.class)
@SpringBootTest
public class RedisEyeApplicationTests {
    @Autowired
    RedisTemplate<String, String> redisTemplate;
    @Autowired
    private RedisInfoService redisInfoService;
    @Autowired
    JedisConnectionFactory jedisConnectionFactory;
    @Autowired
    private JavaMailSender mailSender;

    @Test
    public void contextLoads() {
    }

    @Test
    public void testRedisConfig() {
//        ValueOperations<String, String> opsForValue = redisTemplate.opsForValue();
//        //数据插入测试：
//        opsForValue.set("test", "test");
//        String valueFromRedis = opsForValue.get("test");
//        System.out.print(valueFromRedis);
    }

    @Test
    public void testRedisInfo() {
        RedisClusterConnection conn = jedisConnectionFactory.getClusterConnection();
        Iterable<RedisClusterNode> nodes = conn.clusterGetNodes();
        HashMap<String,Object> infos=new HashMap<>();
        ClusterInfo clusterInfo = conn.clusterGetClusterInfo();
        ArrayList<Properties> nodesInfo = new ArrayList<>();
        nodes.forEach(node -> {
            if (node.isConnected()) {
                Properties info = conn.info(node);
                info.put("server", node.getHost() + ":" + node.getPort());
                info.put("state","CONNECTED");
                nodesInfo.add(info);
            }else{
                Properties info = new Properties();
                info.put("server", node.getHost() + ":" + node.getPort());
                info.put("state","DISCONNECTED");
                nodesInfo.add(info);
            }
        });
        infos.put("clusterInfo",clusterInfo);
        infos.put("nodesInfo",nodesInfo);

    }

    @Test
    public void sendMailTest() {
        System.setProperty("https.protocols", "TLSv1");
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom("201568@sh.lianjia.com");//发送者.
        message.setTo("201568@sh.lianjia.com");//接收者.
        message.setSubject("测试邮件（邮件主题）");//邮件主题.
        message.setText("这是邮件内容");//邮件内容.
        mailSender.send(message);//发送邮件
    }

    @Test
    public void mailTest() {
        JavaMailSenderImpl senderImpl = new JavaMailSenderImpl();
        // 设定mail server
        senderImpl.setHost("smtp.exmail.qq.com");
        // 建立邮件消息
        SimpleMailMessage mailMessage = new SimpleMailMessage();
        // 设置收件人，寄件人 用数组发送多个邮件
        // String[] array = new String[] {"sun111@163.com","sun222@sohu.com"};
        // mailMessage.setTo(array);
        mailMessage.setTo("201568@sh.lianjia.com");
        mailMessage.setFrom("201568@sh.lianjia.com");
        mailMessage.setSubject(" 测试简单文本邮件发送！ ");
        mailMessage.setText(" 测试我的简单邮件发送机制！！ ");

        senderImpl.setUsername("201568"); // 根据自己的情况,设置username
        senderImpl.setPassword("lg37260561"); // 根据自己的情况, 设置password

        Properties prop = new Properties();
        prop.put("mail.smtp.auth", "true"); // 将这个参数设为true，让服务器进行认证,认证用户名和密码是否正确
        prop.put("mail.smtp.timeout", "25000");

        prop.put("spring.mail.properties.mail.smtp.starttls.enable",true);
        prop.put("spring.mail.properties.mail.smtp.starttls.required",true);
        senderImpl.setJavaMailProperties(prop);
        // 发送邮件
        senderImpl.send(mailMessage);

        System.out.println("邮件发送成功..");
    }

}
