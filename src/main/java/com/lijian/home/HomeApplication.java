package com.lijian.home;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.Banner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.lijian.dao")
public class HomeApplication {


	public static void main(String[] args) {
		//SpringApplication.run(HomeApplication.class, args);
        SpringApplication springApplication = new SpringApplication(HomeApplication.class);
        springApplication.setBannerMode(Banner.Mode.OFF);
        springApplication.run(args);
	}

}
