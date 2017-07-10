package com.crawler.source.service.impl;

import com.crawler.source.dao.AppMapper;
import com.crawler.source.domain.App;
import com.crawler.source.service.IAppService;

import javax.annotation.Resource;

/**
 * Created by Lai on 2017/7/10.
 */
public class AppServiceImpl implements IAppService {
    @Resource
    private AppMapper appDao;

    @Override
    public void add(App app) {
        appDao.insert(app);
    }
}
