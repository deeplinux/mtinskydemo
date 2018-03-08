package com.mybatisdemo.dao;

import com.mybatisdemo.pojo.BaseFile;
import com.mybatisdemo.pojo.ReqParams;

import java.util.List;
import java.util.Map;

/**
 * author: xiangrandy
 * date:15-7-21
 * time:下午3:17
 * description:base_file表相关查询mapper
 */
public interface BaseFileMapper {

    //参数和返回值类型都为Map
    List<Map> getBaseFileReturnMapByMap(Map<String, Object> reqMap);

    //参数和返回值类型都为POJO
    List<BaseFile> getBaseFileByPOJO(ReqParams reqParams);

}
