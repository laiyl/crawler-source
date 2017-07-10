package com.crawler.source.job;

import com.crawler.source.domain.Source;
import com.crawler.source.http.HttpRequestUtils;
import com.crawler.source.service.ISourceService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class BaiduSourceJob implements Runnable {
	private static final Logger LOGGER = LoggerFactory.getLogger(BaiduSourceJob.class);
	private ISourceService sourceService;
	private Integer init_i;
	private Integer i = 1;

	public BaiduSourceJob(Integer i, ISourceService sourceService) {
		this.init_i = i <= 0 ? 1 : i;
		this.i = i <= 0 ? 1 : i;
		this.sourceService = sourceService;
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
					// 保存有效的app信息
					Source source = new Source();
					source.setChannel("http://shouji.baidu.com");
					source.setUrl("http://shouji.baidu.com/software/" + urlnum + ".html");
					source.setUrlNumber(i);
					try {
						System.out.println(source.toString());
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
			if (i >= init_i + 1000000) {
				LOGGER.info("{}~{}-------------检查完成:", init_i, (i - 1));
				break;
			}
		}
	}

}
