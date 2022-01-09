package com.lijian.home;

import com.lijian.dao.HouseMapper;
import com.lijian.domain.entity.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

/**
 * @Description
 * @Date:2020-12-20
 * @Author:lijian
 **/
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = HomeApplication.class)
public class HouseSqlTest {

    @Autowired
    private HouseMapper houseMapper;

    @Test
    public void  testQuery(){
       List<User> userList = houseMapper.queryUserList("0");
        System.out.println("条数："+userList.size());
        System.out.println("结果列表：");
        userList.stream().forEach(t -> {
            System.out.println("id:"+t.getUserId());
            System.out.println("name:"+t.getUserName());
            System.out.println("phone:"+t.getTelPhone());

                }

        );


    }


}
