package com.crawler.source;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.crawler.source.dao")
public class CrawlerSourceApplication {

	public static void main(String[] args) {
		SpringApplication.run(CrawlerSourceApplication.class, args);
	}
}
