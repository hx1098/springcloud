package com.xss.demo.Controller;

import com.google.code.kaptcha.Constants;
import com.google.code.kaptcha.Producer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.imageio.ImageIO;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.awt.image.BufferedImage;

/**
 * @author hx
 * @version 1.0.0
 * @createTime 2021/5/23 14:12
 * @option
 * @description
 */

@RestController
public class HiController {




    @GetMapping("/hiM")
    public String get(){
        System.out.println("来了,老弟!");
        return "hello";
    }





}
