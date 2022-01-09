package com.lijian.dao;

import com.lijian.domain.entity.Register;
import com.lijian.domain.entity.Request;
import com.lijian.domain.entity.User;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public interface HouseMapper {
    public void insertUser(User user);
    public int insertRegister(Register register);
    public User queryUser(String telPhone);
    public List<User> queryUserList(String status);
    public Register queryRegister(Map params);
    public List<Register> queryRegisterList(String status);
    public List<Map<String,Object>> queryRegisterMsgList(Request request);

}
