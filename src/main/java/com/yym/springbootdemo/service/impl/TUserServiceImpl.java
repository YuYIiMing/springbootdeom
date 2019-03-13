package com.yym.springbootdemo.service.impl;

import com.yym.springbootdemo.repo.entity.TUser;
import com.yym.springbootdemo.repo.mapper.TUserMapper;
import com.yym.springbootdemo.service.TUserService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 后台管理用户表 服务实现类
 * </p>
 *
 * @author andy.yu
 * @since 2019-03-13
 */
@Service
public class TUserServiceImpl extends ServiceImpl<TUserMapper, TUser> implements TUserService {

}
