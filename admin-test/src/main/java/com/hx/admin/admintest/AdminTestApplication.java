package com.hx.admin.admintest;

import de.codecentric.boot.admin.server.config.EnableAdminServer;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableAdminServer
public class AdminTestApplication {

    public static void main(String[] args) {
        SpringApplication.run(AdminTestApplication.class, args);
    }

}
