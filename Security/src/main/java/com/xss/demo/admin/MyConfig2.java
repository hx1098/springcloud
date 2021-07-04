package com.xss.demo.admin;

import com.xss.demo.admin.service.MyAuthProvider;
import com.xss.demo.admin.service.MyDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.security.web.csrf.HttpSessionCsrfTokenRepository;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;
import java.io.IOException;

/**
 * @author hx
 * @version 1.0.0
 * @createTime 2021/5/23 14:29
 * @option
 * @description
 */
@Configuration
@EnableWebSecurity
public class MyConfig2 extends WebSecurityConfigurerAdapter {



    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.
                // 哪些 地址需要登录
                        authorizeRequests()
                //所有请求都需要验证
                .anyRequest().authenticated()
                .and()
                .formLogin()
                .and()
                .rememberMe()
                .and()
                .csrf().disable();


    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.
		inMemoryAuthentication()
			.withUser("123").password(new BCryptPasswordEncoder().encode("123")).roles("admin")
		.and()
			.withUser("321").password("321").roles("user")
		;



    }

    @Autowired
    DataSource dataSource;




    @Bean
    PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }


}
