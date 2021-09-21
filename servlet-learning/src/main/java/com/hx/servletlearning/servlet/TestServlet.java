package com.hx.servletlearning.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**

/**
 * @author hx
 * @createTime 2021/8/26 14:54
 * @version 1.0.0
 * @description
 * @editUser hx
 * @editTime 2021/8/26 14:54
 * @editDescription
 */
@WebServlet(name = "myServlet",urlPatterns = "srv")
public class TestServlet extends HttpServlet {


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("111");
        super.doGet(req,resp);
    }





}
