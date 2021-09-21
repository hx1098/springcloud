package com.hx.servletlearning;

import com.hx.servletlearning.servlet.TestServlet;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.boot.web.servlet.ServletRegistrationBean;

/**
 * @author hx
 */
@SpringBootApplication
@ServletComponentScan //开启setvlet开关
public class ServletLearningApplication {

    public static void main(String[] args) {
        SpringApplication.run(ServletLearningApplication.class, args);
    }

    /**
     * 将自定的servlet 注入到bean容器管理中
     * @return
     */
    public ServletRegistrationBean<TestServlet> getServletRegistrationBean() {
        ServletRegistrationBean<TestServlet> bean = new ServletRegistrationBean<>(new TestServlet());
        bean.setLoadOnStartup(1);
        return bean;
    }

}
