package com.crawler.source.controller;

import com.crawler.source.job.BaiduAppJob;
import com.crawler.source.service.IAppService;
import com.crawler.source.service.ISourceService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@RestController
@RequestMapping("/app")
public class AppController {
	private ExecutorService pool ; // 100线程

	@Value("${baidu.app.server-index}")
	private Integer serviceIndex;
	@Value("${baidu.app.server-number}")
	private Integer serviceNumber;
	@Value("${baidu.app.all-number}")
	private Integer allNumber;

	@Resource
	private IAppService appService;

	@GetMapping("/shouji/baidu")
	public String baiDu() {
		if(pool!=null){
			return "正在监测中。。。。。。";
		}else{
			pool =  Executors.newFixedThreadPool(100);
		}
		Integer startPosition = (allNumber/serviceNumber)*(serviceIndex-1);
		Integer taskNumber = allNumber/serviceNumber/100;  //每个线程需请求地址数量

		Integer number_j;
		for (int j = 0; j < 100; j++) {
			number_j = j * taskNumber + startPosition;
			pool.execute(new BaiduAppJob(number_j, appService,taskNumber));
		}
		return "shouji.baidu有效地址监测中....";
	}

	@GetMapping()
	public String test() {
		return "1111111111";
	}

	public static void main(String[] args) {
		Integer serviceIndex = 1;
		Integer serviceNumber = 1;
		Integer allNumber = 100000000; //所有应用数量

		System.out.println(allNumber/serviceNumber/100);  // 10个进程1000个线程 每个线程 10万个地址请求
		System.out.println((allNumber/serviceNumber)*(serviceIndex-1));

	}
}
