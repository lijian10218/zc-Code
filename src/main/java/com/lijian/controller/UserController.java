package com.lijian.controller;

import com.lijian.domain.entity.Response;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * @Description
 * @Date:2020-12-19
 * @Author:lijian
 **/
@RestController
@RequestMapping(value = "/user")
public class UserController {

    @GetMapping
    public Response<Map<String,Object>> get(){
        Response<Map<String,Object>> response = new Response<>();
        Map<String,Object> user  = new HashMap<>();
        user.put("userName","李健");
        user.put("age",30);
        response.setCode(200);
        response.setMessage("成功！");
        response.setData(user);
        return response;
    }



}
