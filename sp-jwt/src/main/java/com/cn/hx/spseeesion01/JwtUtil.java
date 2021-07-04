package com.cn.hx.spseeesion01;

/**
 * @author hx
 * @createTime 2021/7/4 21:24
 * @option
 * @description
 */
import java.util.Base64;
import java.util.Calendar;
import java.util.Date;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.Jwts;

/**
 * @author yueyi2019
 */
public class JwtUtil {
    /**
     * 密钥，仅服务端存储
     */
    private static String secret = "ko346134h_we]rg3in_yip1!";

    /**
     *
     * @param subject
     * @param issueDate 签发时间
     * @return
     */
    public static String createToken(String subject, Date issueDate) {


        Calendar c = Calendar.getInstance();
        c.setTime(issueDate);
        c.add(Calendar.DAY_OF_MONTH, 20);



        String compactJws = Jwts.builder()
                .setSubject(subject)
                .setIssuedAt(issueDate)
                .setExpiration(c.getTime())

                .signWith(io.jsonwebtoken.SignatureAlgorithm.HS512, secret)
                .compact();
        return compactJws;

    }

    /**
     * 解密 jwt
     * @param token
     * @return
     * @throws Exception
     */
    public static String parseToken(String token) {
        try {
            Claims claims = Jwts.parser().setSigningKey(secret).parseClaimsJws(token).getBody();
            if (claims != null){
                return claims.getSubject();
            }
        }catch (ExpiredJwtException e){
            e.printStackTrace();
            System.out.println("jwt过期了");
        }

        return "";
    }

   /* public static void main(String[] args) {
        *//*eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJ1c2VyaWQ9MSxyb2xlPWFkbWluLHByaWNlPTM5OCIsImlhdCI6MTYyNTQwNTI1OSwiZXhwIjoxNjI3MTMzMjU5fQ.ULfU6XeFNXvKJk8P0iZRHsmvQ7Cn1pJnCARbcFVWl0g7QkWpyJdsbRld09Lea5ayR1KKa5LE4gE8EHoSROQeKg*//*
        String token = createToken("userid=1,role=admin,price=398", new Date());
        System.out.println(token);
    }*/

    public static void main(String[] args) {
       /* byte[] bytes = Base64.getDecoder().decode("eyJzdWIiOiJ1c2VyaWQ9MSxyb2xlPWFkbWluLHByaWNlPTM5OCIsImlhdCI6MTYyNTQwNTI1OSwiZXhwIjoxNjI3MTMzMjU5fQ");
        System.out.println(new String(bytes));*/

        String token = parseToken("eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJ1c2VyaWQ9MSxyb2xlPWFkbWluLHByaWNlPTM5OCIsImlhdCI6MTYyNTQwNTI1OSwiZXhwIjoxNjI3MTMzMjU5fQ.ULfU6XeFNXvKJk8P0iZRHsmvQ7Cn1pJnCARbcFVWl0g7QkWpyJdsbRld09Lea5ayR1KKa5LE4gE8EHoSROQeKg");
        System.out.println(token);
    }




}