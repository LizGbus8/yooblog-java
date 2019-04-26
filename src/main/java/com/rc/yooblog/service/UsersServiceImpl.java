package com.rc.yooblog.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.rc.yooblog.entity.Users;
import com.rc.yooblog.mapper.UsersMapper;
import org.springframework.stereotype.Service;

/**
 * 作者：flandre on 2019/4/14 14:30
 * 描述：
 */
@Service
public class UsersServiceImpl extends ServiceImpl<UsersMapper, Users> implements IService<Users> {
}
