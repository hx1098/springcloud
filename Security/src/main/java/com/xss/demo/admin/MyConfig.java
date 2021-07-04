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
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.security.web.csrf.HttpSessionCsrfTokenRepository;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;
import java.io.IOException;
import java.util.Collection;
import java.util.Collections;

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

    /*忽略静态请求 , 这种方式不走权限认证*/
    @Override
    public void configure(WebSecurity web) throws Exception {
//        不登录就可以访问资源
        web.ignoring().antMatchers("/img/**");
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {

        http.
                // 哪些 地址需要登录
                        authorizeRequests()
                //所有请求都需要验证
                	.antMatchers("/img/**").permitAll()//忽略静态请求   http://localhost/img/1.jpg
                .anyRequest().authenticated()
                .and()


                //permitAll 给没登录的 用户可以访问这个地址的权限
                //自定义登录页
                .formLogin().loginPage("/login.html")

                .loginProcessingUrl("/login")
                // 登录失败 页面
                .failureUrl("/login.html?error")
                // 登录成功跳转的页面
                .defaultSuccessUrl("/ok", true).permitAll()
                // 配置 登录页 的表单name和passwrord   admin -> 分权限 展示页面
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

    }

//     这里如果重新这个类的话, application.properties文件中的配置就失效, 并且要要加密
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        /*auth.
		inMemoryAuthentication()
			.withUser("123").password(new BCryptPasswordEncoder().encode("123")).roles("admin")
		.and()
			.withUser("321").password("321").roles("user")
		;*/
       /* InMemoryUserDetailsManager   manager = new InMemoryUserDetailsManager();
        auth.jdbcAuthentication().dataSource(dataSource).getUserDetailsService();
        boolean  flag =manager.userExists("lisi");
        System.out.println("是否存在: " + flag);
        if(!flag){
            manager.createUser(User.withUsername("lisi").password(new BCryptPasswordEncoder().encode("xx")).roles("xxz").build());
        }
*/

        auth.userDetailsService(new MyDetailService()).
//                开关标签
                and().
                authenticationProvider(new MyAuthProvider());




    }

    @Autowired
    DataSource dataSource;

    /**
     * 这种方法也可以进行登录, 但是不遵循jdbc的规范, InMemoryUserDetailsManager 中有jdbc的登录规范
     *
     * @return
     */
/*    @Bean
    public UserDetailsService userDetailsService() {
//        基于内存的登录
//        userDetails
       InMemoryUserDetailsManager   manager = new InMemoryUserDetailsManager();
//       使用 用户名 找user对象
//       manager.loadUserByUsername(userName);
       Collection authorities;
       User user = new User("a",new BCryptPasswordEncoder().encode("1") , true, true, true, true, Collections.singletonList(new SimpleGrantedAuthority("xx")));
       manager.createUser(user);
       manager.createUser(User.withUsername("yiming").password(new BCryptPasswordEncoder().encode("xx")).roles("xxz").build());
       return manager;


////        基于jdbc的登录
//        JdbcUserDetailsManager manager = new JdbcUserDetailsManager(dataSource);
////        如果这个用户不存在就添加
//        boolean b = manager.userExists("lisi");
//        System.out.println(" 用户是否存在: "+  b);
//        if(!manager.userExists("lisi")){
//            manager.createUser(User.withUsername("lisi").password(new BCryptPasswordEncoder().encode("111")).roles("admin","xxoo").build());
//        }
//        return manager;

    }*/


    @Bean
    PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }


}
