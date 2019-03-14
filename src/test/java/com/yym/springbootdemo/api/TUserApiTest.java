package com.yym.springbootdemo.api;

import com.yym.springbootdemo.repo.entity.TUser;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.Assert.*;

@SpringBootTest
@RunWith(SpringRunner.class)
public class TUserApiTest {
    @Autowired
    public TUserApi tUserApi;

    @Test
    public void getUserList() {
        List<TUser> userList = tUserApi.getUserList(10, 0);
        for (TUser user : userList) {
            System.out.println("id:" + user.getId() + ",name:" + user.getName());
        }
    }
}