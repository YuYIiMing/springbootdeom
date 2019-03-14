package com.yym.springbootdemo.repo.mapper;

import com.yym.springbootdemo.repo.entity.TUser;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

/**
 * <p>
 * 后台管理用户表 Mapper 接口
 * </p>
 *
 * @author andy.yu
 * @since 2019-03-13
 */
public interface TUserMapper extends BaseMapper<TUser> {

}
