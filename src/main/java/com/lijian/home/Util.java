package com.lijian.home;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Map;

/**
 * @Description
 * @Date:2021-01-10
 * @Author:lijian
 **/
public class Util {

    private static final Logger log = LoggerFactory.getLogger(UserController.class);


    public static void printRequestParams(Map<String,Object> params) {
        log.info("接收请求参数："+params);
    }
}
