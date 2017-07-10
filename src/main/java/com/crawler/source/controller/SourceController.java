package com.crawler.source.controller;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.crawler.source.service.ISourceService;
import com.crawler.source.job.BaiduSourceJob;
@RestController
@RequestMapping("/source")
public class SourceController {
	private ExecutorService pool ; // 100线程

	@Resource
	private ISourceService sourceService;

	@GetMapping("/shouji/baidu")
	public String baiDu() {
		if(pool!=null){
			return "正在监测中。。。。。。";
		}else{
			pool =  Executors.newFixedThreadPool(100);
		}
		Integer number_j;
		for (int j = 0; j < 100; j++) {
			number_j = j * 1000000;
			pool.execute(new BaiduSourceJob(number_j, sourceService));
		}
		return "shouji.baidu有效地址监测中....";
	}

	@GetMapping("/shouji/baidu2")
	public String baiDuTwo() {
		if(pool!=null){
			return "正在监测中。。。。。。";
		}else{
			pool =  Executors.newFixedThreadPool(1);
		}
		pool.execute(new BaiduSourceJob(1, sourceService));
		return "shouji.baidu有效地址监测中2....";
	}
	@GetMapping()
	public String test() {
		return "1111111111";
	}
}
