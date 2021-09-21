package com.example.demo.dateTime;

import ch.qos.logback.core.net.SyslogOutputStream;

import javax.swing.text.DateFormatter;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;

/**
 * @author hx
 * @version 1.0.0
 * @createTime 2021/8/4 9:42
 * @option
 * @description
 * @editUser hx
 * @editTime 2021/8/4 9:42
 * @editDescription
 */
public class localDateTIme {
    public static void main(String[] args) {
        LocalDateTime localDateTime = LocalDateTime.now();
        System.out.println(localDateTime);

        DateTimeFormatter formatter = DateTimeFormatter.ISO_LOCAL_DATE_TIME;
        System.out.println(localDateTime.format(formatter));;


        System.out.println("=============================================");
        DateTimeFormatter formatter1 = DateTimeFormatter.ofLocalizedDate(FormatStyle.SHORT);
        System.out.println(localDateTime.format(formatter1));
        System.out.println("=============================================");

        DateTimeFormatter formatter2 = DateTimeFormatter.ofPattern("yyyy-MM-dd hh:mm:ss");
        System.out.println(localDateTime.format(formatter2));
    }

}
