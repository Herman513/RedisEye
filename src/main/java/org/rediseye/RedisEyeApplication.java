package org.rediseye;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
@MapperScan(basePackages = "org.rediseye.dao")
@SpringBootApplication
public class RedisEyeApplication {

	public static void main(String[] args) {
		SpringApplication.run(RedisEyeApplication.class, args);
	}
}
