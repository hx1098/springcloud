[TOC]


### springcloud整合以及应用

### 1.端口以及配置 : 

  ```shell
     euk1端口 : 7001
     euk2端口 : 7002
     erurkaProvider: 80
     errekaConsumer: 90
     user-comsumer:  91
     user-provider:  81
     
  ```

###  2.地址类
######1.hystrixdashboard 的浏览地址: 
  http://localhost:91/actuator/hystrix.stream
  http://localhost:91/hystrix
  
 
######3.网关
   ####### 1.基础访问cousumer的地址
  ```java
   #通过zuul访问user-consumer地址
   http://localhost/user-consumer/alive
   #通过网关访问user-providerd的地址
   http://localhost/user-provider/User/getById?id=123
   #通过网关访问user-consumer地址
   http://localhost/user-consumer//blive
   #consumer地址
   http://localhost:91/alive
   #注册中心地址
   http://localhost:7001/
  ```

   ####### 2.网关相关配置类地址
   ```java
    #zuul自定义映射, 如果访问路径中有"dalao" 即可跳转到制定网站.  http://localhost/dalao/pc.html
    http://localhost/dalao/pc.html
    
```
   
  
