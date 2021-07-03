package com.xss.demo.admin.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.CredentialsExpiredException;
import org.springframework.security.authentication.LockedException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import javax.security.auth.login.CredentialException;
import javax.security.auth.login.CredentialExpiredException;
import java.util.Random;

/**
 * @author hx
 * @version 1.0.0
 * @createTime 2021/7/3 16:49
 * @option
 * @description  如果自定义了这个类, 需要自己手动查询数据库
 * @editUser hx
 * @editTime 2021/7/3 16:49
 * @editDescription
 */
public class MyDetailService implements UserDetailsService {



    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//        用户自定义查询用户角色, 可以从sql,redis中都可以

        if (new Random().nextBoolean()) {
//            登录成功
            throw new CredentialsExpiredException("密码已过期, 请修改密码之后在进行操作.");
        } else {
            throw new LockedException("用户被锁定,请联系管理员");
        }
    }
}
