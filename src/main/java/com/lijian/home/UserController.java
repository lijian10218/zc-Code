package com.lijian.home;

import com.lijian.dao.HouseMapper;
import com.lijian.domain.entity.Register;
import com.lijian.domain.entity.Request;
import com.lijian.domain.entity.Response;
import com.lijian.domain.entity.User;
import org.apache.commons.beanutils.BeanUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.lang.reflect.InvocationTargetException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @Description
 * @Date:2020-12-19
 * @Author:lijian
 **/
@CrossOrigin
@RestController
@RequestMapping(value = "/user",method = RequestMethod.POST)
public class UserController {

    @Autowired
    private HouseMapper houseMapper;

    private static final Logger log = LoggerFactory.getLogger(UserController.class);


    /**
     *接收form表单请求
     */
//    @ResponseBody
//    @GetMapping
//    public Response<List<User>> get(HttpServletRequest request){
//        String userName = request.getParameter("userName");
//        String telPhone = request.getParameter("telPhone");
//        Response<List<User>> response = new Response<>();
//        response.setCode(200);
//          //1)参数校验
//         if (checkParams(userName,telPhone,response)){
//             //2）查询user表中是否存在，如果不存在，则插入
//              addUser(userName,telPhone);
//             //3)查询登记表中是否已经登记，如果已经登记，则报错提示
//
//             //4)插入登记表，返回成功
//             User user = new User();
//             user.setUserName(request.getParameter("userName"));
//
//             response.setMessage("成功！");
//             List<User> userList = houseMapper.queryUserList("0");
//             response.setData(userList);
//         }else {
//             response.setCode(300);
//             return response;
//         }
//        return response;
//    }


    /**
     * 接收ajax请求
     * @return
     */
    @ResponseBody
    @GetMapping
    @Transactional(propagation = Propagation.REQUIRED,readOnly = false)
    public Response<String> getAjax(@RequestBody Map<String,Object> params){
        //日志打印
        Util.printRequestParams(params);

        Response<String> response = new Response<>();
        //接收请求参数
         Request request = new Request();
        try {
            BeanUtils.populate(request,params);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        response.setCode(200);
        response.setMessage("登记成功！");
        //1)参数校验
        if (checkParams(request,response)){
            //2)查询登记表中是否已经登记，如果已经登记，则报错提示
            if (checkIsRegister(request,response)) {
                //3)执行注册：插入用户表和登记表
                doRegister(request,response);
            }else {
                response.setCode(300);
                return response;
            }
        }else {
            response.setCode(300);
            return response;
        }
        return response;
    }

    private boolean checkParams(Request request,Response<String> response){
        boolean flag = true;
        if (request.getUserName() == null || "".equals(request.getUserName())) {
            flag = false;
            response.setMessage("姓名不能为空！");
            return flag;
        }

        if (request.getTelPhone() == null || "".equals(request.getTelPhone())) {
            flag = false;
            response.setMessage("手机号不能为空！");
            return flag;
        }

        if (request.getBuildId() == null || "".equals(request.getBuildId())) {
            flag = false;
            response.setMessage("选择楼盘不能为空！");
            return flag;
        }
        return flag;
    }

    /**
     * 查询用户是否已经登记过该楼盘
     * @param request
     * @param response
     * @return
     */
    private boolean checkIsRegister(Request request,Response<String> response){
        boolean flag = true;
        //1）查询用户是否存在
        User user = houseMapper.queryUser(request.getTelPhone());
        if (user != null) {
            //2)如果用户存在，查询该用户有无在该楼盘登记
            String userId = user.getUserId();
            Map params = new HashMap();
            params.put("userId",userId);
            params.put("buildId",request.getBuildId());
            Register register = houseMapper.queryRegister(params);
            if (register != null) {
                flag = false;
                response.setMessage("该手机号已登记过该楼盘，请重新填写！");
                return flag;

            }
        }
        return flag;
    }


    @Transactional(propagation = Propagation.REQUIRED,readOnly = false)
    public void doRegister(Request request,Response<String> response) {
        //1)插入用户表
        //查询是否有该用户信息，没有则插入
        User isUser = houseMapper.queryUser(request.getTelPhone());
        String userId;
        if (isUser != null) {
            userId = isUser.getUserId();
        }else {
            //插入用户表
            User user = new User();
            user.setUserName(request.getUserName());
            user.setTelPhone(request.getTelPhone());
            user.setStatus("0");
            user.setCreateTime(new Date());
            houseMapper.insertUser(user);
            userId = user.getUserId();
        }
        //2)插入注册表
        Register register = new Register();
        register.setBuildId(request.getBuildId());
        register.setUserId(userId);
        register.setStatus("0");
        register.setRecommender(request.getRecommender());
        register.setCreateTime(new Date());
        houseMapper.insertRegister(register);
    }

    private void printRequestParams(Map<String,Object> params) {
        log.info("接收请求参数："+params);
    }

    private void addUser(String userName,String telPhone){
        //查询user表中是否存在

    }



}
