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
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.security.web.authentication.logout.LogoutHandler;
import org.springframework.security.web.csrf.HttpSessionCsrfTokenRepository;
import org.springframework.security.web.session.HttpSessionEventPublisher;

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
                //本机访问可以不登录
                .antMatchers("url").hasIpAddress("127.0.0.1")
//                ip地址访问的黑白名单

                .and()
                .formLogin().loginPage("/login.html")

                .loginProcessingUrl("/login")
                // 登录失败 页面
                .failureUrl("/login.html?error")
                // 登录成功跳转的页面
                .defaultSuccessUrl("/ok", true).permitAll()
                // 配置 登录页 的表单name和passwrord   admin -> 分权限 展示页面
                .passwordParameter("oo")
                .usernameParameter("xx")

                .and()
                .logout()
                .addLogoutHandler(new LogoutHandler() {
                    @Override
                    public void logout(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Authentication authentication) {
                        System.out.println("我退出了!");
                    }
                })
                .addLogoutHandler(new LogoutHandler() {
                    @Override
                    public void logout(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Authentication authentication) {
                        System.out.println("我又要退出了");
                    }
                })









                .and()
                .sessionManagement()
                  .maximumSessions(1)  //只允许一个用户登录
                .maxSessionsPreventsLogin(true) //不允许其他用户登录
//                .rememberMe()
                .and().and()
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


    /**
     * 即时清理过期session
     * @return
     */
    @Bean
    HttpSessionEventPublisher httpSessionEventPublisher() {
        return new HttpSessionEventPublisher();
    }
}
