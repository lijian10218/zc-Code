package com.lijian.home;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Description
 * @Date:2020-12-19
 * @Author:lijian
 **/
@RestController
public class HellloController {

    @RequestMapping("/hello")
    public String index(){
        return "hell lijianhhhffd-555---999--7777!";
    }
    //sssss
}
