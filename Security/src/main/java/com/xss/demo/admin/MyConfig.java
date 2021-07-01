package com.xss.demo.admin;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.security.web.csrf.HttpSessionCsrfTokenRepository;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
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
public class MyConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
//        super.configure(http);

        /*HttpSessionCsrfTokenRepository httpSessionCsrfTokenRepository = new HttpSessionCsrfTokenRepository();
        http
                .authorizeRequests().anyRequest().authenticated()
                .and()
                //指的是from表单
                .formLogin().loginPage("/login.html")
                .loginProcessingUrl("/login")

                .defaultSuccessUrl("/ok")
//                登录失败页面
                .failureForwardUrl("/login.html?error")
                .permitAll()
                .failureHandler(new AuthenticationFailureHandler() {
                    @Override
                    public void onAuthenticationFailure(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, AuthenticationException e) throws IOException, ServletException {
                        e.printStackTrace();
                    }
                })



                .permitAll()


                .and()
                .csrf()
                .csrfTokenRepository(new HttpSessionCsrfTokenRepository());

*/
        http.
        // 哪些 地址需要登录
        authorizeRequests()
                //所有请求都需要验证
                //	.antMatchers("/img/**").permitAll()
                .anyRequest().authenticated()
                .and()


                //permitAll 给没登录的 用户可以访问这个地址的权限
                //自定义登录页
                .formLogin().loginPage("/login.html")

                .loginProcessingUrl("/login").permitAll()
                // 登录失败 页面
                .failureUrl("/login.html?error")
                // 登录成功跳转的页面
                .defaultSuccessUrl("/ok",true).permitAll()
                // 配置 登录页 的表单name   admin -> 分权限 展示页面
                .passwordParameter("oo")
                .usernameParameter("xx")


                .failureHandler(new AuthenticationFailureHandler() {

                    @Override
                    public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response,
                                                        AuthenticationException exception) throws IOException, ServletException {

                        exception.printStackTrace();

                        // 判断异常信息 跳转不同页面 比如 密码过期重置
                        request.getRequestDispatcher(request.getRequestURL().toString()).forward(request, response);

                        // 记录登录失败次数 禁止登录

                    }
                })


                //默认 所有的post请求 都会拦截
                .and()
                .csrf()
                .csrfTokenRepository(new HttpSessionCsrfTokenRepository());

        ;


    }

    /*这里如果重新这个类的话, application.properties文件中的配置就失效, 并且要要加密*/
   /* @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication()
                .withUser("123").password("123").roles("admin")
                .and()
                .withUser("321").password("321").password("user")
                ;
    }*/


}
