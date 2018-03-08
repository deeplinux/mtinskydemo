package com.mybatisdemo;

import com.mybatisdemo.core.MyBatisFactory;
import com.mybatisdemo.dao.BaseFileMapper;
import com.mybatisdemo.pojo.BaseFile;
import com.mybatisdemo.pojo.ReqParams;
import org.apache.ibatis.session.SqlSession;
import org.apache.log4j.PropertyConfigurator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * User: lu
 * Date: 17-2-6
 * Time: 上午9:27
 * 该Demo项目主要演示Mybatis的如下功能：
 * 如何使用Mybatis
 * 如何使用Mybatis的动态sql
 * 如何引入第三方的数据库连接池，如c3p0
 * 如何在同一个项目内，连接多个数据库
 * 如何在日志中打印SQL语句
 * 采用POJO或者Map传参
 * 使用POJO或者Map接收结果
 */
public class Main {
    public static final Logger log  = LoggerFactory.getLogger(Main.class);

    public static void main(String[] args) {

        //配置文件路径参数解析
        String tConfigPath = System.getProperty("user.dir");
        if(1 <= args.length && args[0].equals("debug")) {
            tConfigPath += "/src/main/resources";
        } else if (1 <= args.length) {
            tConfigPath = args[0];
        }

        //mybatis配置文件
        String filePath = tConfigPath + "/mybatis-config.xml";
        //初始化日志
        PropertyConfigurator.configure(tConfigPath+"/log4j.properties");

        //Mysql
        //初始化Mybatis的SqlSessionFactory
        if(null == MyBatisFactory.init(filePath))  {
            log.error("MyBatisFactory.init null");
            return;
        }

        //第一步获取SqlSession
        SqlSession sqlSession = MyBatisFactory.getMysqlSessionFactory().openSession(true);
        //第二步通过SqlSession获取Mapper
        BaseFileMapper baseFileMapper = sqlSession.getMapper(BaseFileMapper.class);
        //第三步通过Mapper执行方法，方法即为具体的sql
        //1 参数为Map 且返回结果为Map
        Map<String,Object> reqMap = new HashMap<String,Object>();
        reqMap.put("start",0);
        reqMap.put("limit",1);
        List<Map> returnMap = baseFileMapper.getBaseFileReturnMapByMap(reqMap);
        if(returnMap !=null) {
            for(Map fileMap : returnMap) {
                log.info(fileMap.get("name").toString());
            }
        }
        //2 参数为简单对象（即POJO），返回为POJO
        ReqParams reqParams = new ReqParams();
        reqParams.setStart(0);
        reqParams.setLimit(1);
        List<BaseFile> baseFiles = baseFileMapper.getBaseFileByPOJO(reqParams);
        if(baseFiles !=null) {
            for(BaseFile baseFile : baseFiles) {
                log.info(baseFile.getName());
                //数据库内字段名为ImportTime，实体内变量名为importTime，但因为在配置文件中启用了mapUnderscoreToCamelCase，所以可以映射成功
                log.info(baseFile.getImportTime());
            }
        }

        //oracle类似
//        //第一步获取SqlSession
//        SqlSession oracleSqlSession = MyBatisFactory.getSqlSessionFactoryForOracle().openSession(true);
//        //第二步通过SqlSession获取Mapper
//        BaseFileMapper baseFileMapper = sqlSession.getMapper(BaseFileMapper.class);

    }

}
