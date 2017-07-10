package com.crawler.source.service.impl;

import javax.annotation.Resource;

import com.crawler.source.dao.SourceMapper;
import com.crawler.source.service.ISourceService;
import com.crawler.source.domain.Source;
import org.springframework.stereotype.Service;

@Service
public class SourceServiceImpl implements ISourceService {
	@Resource
	private SourceMapper sourceDao;

	@Override
	public void add(Source source) {
		sourceDao.insert(source);
	}

	/**
	 * 查询渠道最后记录的最大有效地址
	 */
	@Override
	public Source findByChannelMaxNum(String channel) {
		return sourceDao.selectByChannelMaxNum(channel);
	}

}
