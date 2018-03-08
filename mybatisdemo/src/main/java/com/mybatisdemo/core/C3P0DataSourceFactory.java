package com.mybatisdemo.core;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.apache.ibatis.datasource.unpooled.UnpooledDataSourceFactory;

/**
 * Created with IntelliJ IDEA.
 * User: lu
 * Date: 15-1-9
 * Time: 下午4:57
 * To change this template use File | Settings | File Templates.
 */
public class C3P0DataSourceFactory extends UnpooledDataSourceFactory {

    public C3P0DataSourceFactory() {
        this.dataSource = new ComboPooledDataSource();
    }
}