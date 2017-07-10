package com.crawler.source.service;


import com.crawler.source.domain.Source;

public interface ISourceService {
	void add(Source source);

	Source findByChannelMaxNum(String channel);
}
