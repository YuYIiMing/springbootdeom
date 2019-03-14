package com.yym.springbootdemo.api;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.yym.springbootdemo.repo.entity.TUser;
import com.yym.springbootdemo.service.TUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class TUserApi {
    @Autowired
    TUserService tUserService;

    public List<TUser> getUserList(int pageSize, int pageNumber) {
        EntityWrapper<Object> ew = new EntityWrapper<>();
        Page<TUser> page = new Page<>(pageNumber, pageSize);
        Page<TUser> tUserPage = null;
        try {
            tUserPage = tUserService.selectPage(page);
        } catch (Exception e) {
            e.printStackTrace();
        }
        List<TUser> list = tUserPage.getRecords();
        return list;
    }

}
