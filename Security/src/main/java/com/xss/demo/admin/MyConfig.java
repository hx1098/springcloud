package com.xss.demo.admin;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.csrf.HttpSessionCsrfTokenRepository;

/**
 * @author hx
 * @version 1.0.0
 * @createTime 2021/5/23 14:29
 * @option
 * @description
 */
@Configuration
@EnableWebSecurity
public class MyConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
//        super.configure(http);
        http.authorizeRequests().anyRequest().authenticated()
                .and()
                //指的是from表单
                .formLogin().loginPage("/login.html").permitAll();

                /*.antMatchers("").denyAll()

                .and()
                .csrf()
                .csrfTokenRepository(new HttpSessionCsrfTokenRepository());*/


    }

}
