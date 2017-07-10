package com.crawler.source.job;

import com.crawler.source.domain.App;
import com.crawler.source.http.HttpRequestUtils;
import com.crawler.source.service.IAppService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class BaiduAppJob implements Runnable {
	private static final Logger LOGGER = LoggerFactory.getLogger(BaiduAppJob.class);
	private IAppService appService;
	private Integer init_i;
	private Integer i = 1;
	private Integer taskNumber;

	public BaiduAppJob(Integer i, IAppService appService,Integer taskNumber) {
		this.init_i = i <= 0 ? 1 : i;
		this.i = i <= 0 ? 1 : i;
		this.appService = appService;
		this.taskNumber = taskNumber;
	}

	@Override
	public void run() {
		String urlnum = "0000000";
		boolean w = true;
		while (w) {
			urlnum = urlnum + i;
			urlnum = urlnum.substring(urlnum.length() - 8);
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			String s = HttpRequestUtils.sendGet("http://shouji.baidu.com/software/" + urlnum + ".html");
			if (!s.contains("请检查您所输入的URL地址是否有误。")) {
				if (s.contains("head-name")) { // 存在应用介绍
					// 保存有效的app地址  TODO
					App app = new App();


					try {
//						sourceService.add(source);
						appService.add(app);
					} catch (Exception e) {
						System.out.println("存在地址。。。。。。。。");
					}
				}
			} else {
				LOGGER.info("{}", urlnum);
				System.out.println("------------------->" + urlnum);
			}
			i++;
			urlnum = "0000000";
			if (i >= init_i + taskNumber) {
				LOGGER.info("{}~{}-------------检查完成:", init_i, (i - 1));
				break;
			}
		}
	}

}
