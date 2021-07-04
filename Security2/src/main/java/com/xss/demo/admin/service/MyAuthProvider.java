package com.xss.demo.admin.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.Collection;

/**
 * @author hx
 * @version 1.0.0
 * @createTime 2021/7/3 17:25
 * @option
 * @description
 * @editUser hx
 * @editTime 2021/7/3 17:25
 * @editDescription
 */
public class MyAuthProvider implements AuthenticationProvider {

    @Autowired
    MyDetailService service;

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        System.out.println("开始校验账号密码是否匹配,");

//        表单提交上来的数据
        String username = authentication.getPrincipal().toString();
        String rowPassword = authentication.getAuthorities().toString();
        System.out.println("1111111");
        System.out.println(authentication);
//        去数据库拿出来 User对象
        UserDetails userDetails = service.loadUserByUsername(username);


//        去做比对
        String encodePassword = new BCryptPasswordEncoder().encode(rowPassword);
        if (new BCryptPasswordEncoder().matches(rowPassword,userDetails.getPassword())) {

            UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(username, rowPassword, userDetails.getAuthorities());
            return authentication;
        } else {
            throw new BadCredentialsException("用户名或秘密错误!");
        }

    }

    @Override
    public boolean supports(Class<?> authentication) {
        return true;
    }
}
