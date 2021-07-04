package com.cn.hx.spseeesion01;


import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.logging.LogRecord;

/**
 * @author hx
 * @version 1.0.0
 * @createTime 2021/7/4 22:01
 * @option
 * @description
 * @editUser hx
 * @editTime 2021/7/4 22:01
 * @editDescription
 */
@WebFilter(urlPatterns = "/**")
@Component
public class AuthFilter implements Filter {


    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("auth 启动成功");
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {

        HttpServletRequest request = (HttpServletRequest) servletRequest;
        String token = request.getHeader("token");
        System.out.println("token: " + token);
        if (StringUtils.isEmpty(token)) {
            System.out.println("你没有登录!");
        } else {
            System.out.println("来了,老弟!");
//            可以自动续期, 也可以手动续期.
            String parseToken = JwtUtil.parseToken(token);
            if (StringUtils.isEmpty(parseToken)) {
                System.out.println(" 里面请.....");
                filterChain.doFilter(request,servletResponse);
            }

        }


    }
}
