package com.lijian.home;

import com.lijian.dao.HouseMapper;
import com.lijian.domain.entity.Request;
import com.lijian.domain.entity.Response;
import com.lijian.domain.entity.User;
import org.apache.commons.beanutils.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.lang.reflect.InvocationTargetException;
import java.util.List;
import java.util.Map;

/**
 * @Description
 * @Date:2020-12-20
 * @Author:lijian
 **/
@CrossOrigin
@RestController
@RequestMapping(value = "/query",method = RequestMethod.POST)
public class QueryController {

    @Autowired
    private HouseMapper houseMapper;

//    @GetMapping
//    public Response<List<User>> get(HttpServletRequest request){
//        Response<List<User>> response = new Response<>();
//        response.setCode(200);
//        response.setMessage("成功！");
//        List<User> userList = houseMapper.queryUserList("0");
//        response.setData(userList);
//        return response;
//    }

    /**
     * 接收ajax请求
     * @return
     */
    @ResponseBody
    @GetMapping
    public Response<List<Map<String,Object>>> getAjax(@RequestBody Map<String,Object> params){
        //日志打印
        Util.printRequestParams(params);

        Response<List<Map<String,Object>>> response = new Response<>();
        //接收请求参数,测试
        Request request = new Request();
        try {
            BeanUtils.populate(request,params);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        response.setCode(200);
        response.setMessage("查询成功！");
        //根据查询条件查询用户登记信息
        List<Map<String,Object>> registerList = houseMapper.queryRegisterMsgList(request);
        response.setData(registerList);
        return response;
    }

}
