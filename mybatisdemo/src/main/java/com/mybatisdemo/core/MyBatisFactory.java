package com.mybatisdemo.core;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.io.InputStream;

/**
 * Created with IntelliJ IDEA.
 * User: kinkoo
 * Date: 14-6-18
 * Time: 上午11:50
 * To change this template use File | Settings | File Templates.
 */
public class MyBatisFactory {

    private static SqlSessionFactory sqlSessionFactory = null;
    private static SqlSessionFactory sqlSessionFactoryForOracle = null;
    public static final Logger log  = LoggerFactory.getLogger(MyBatisFactory.class);

    public static SqlSessionFactory init(String etcFile){
        return sqlSessionFactory=_init("mysql",etcFile);
    }

    public static SqlSessionFactory InitForOracle(String etcFile) {
        return sqlSessionFactoryForOracle =_init("oracle",etcFile);
    }

    private static SqlSessionFactory _init(String environment,String etcFile) {
        String resource = "file:///"+etcFile;
        InputStream inputStream = null;
        try {
            inputStream = Resources.getUrlAsStream(resource);
        } catch (IOException e) {
            log.error(" Resources.getResourceAsStream(resource)", e);
        }
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream,environment);
        return sqlSessionFactory;
    }

    public static SqlSessionFactory getMysqlSessionFactory() {
        return sqlSessionFactory;
    }

    public static SqlSessionFactory getSqlSessionFactoryForOracle() {
        return sqlSessionFactoryForOracle;
    }

}
