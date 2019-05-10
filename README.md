# Spring-Cloud-Netflix_TechPra
###		Spring-Cloud-Netflix技术实践

#####	开发环境

| 操作系统  |  Java版本  |     maven版本     |  spring boot  | spring cloud  |    IDE    |
| :-------: | :--------: | :---------------: | :-----------: | :-----------: | :-------: |
| windows10 | jdk-11.0.2 | apach maven 3.6.0 | 2.1.4.RELEASE | Greenwich.SR1 | idea-2019 |

#####	工程说明

|     工程名      | 工程内容说明 | 端口号 |
| :-------------: | :----------: | :----: |
|  config_server  |   文件中心   |  8041  |
| turbine_server  |   监控中心   |  8051  |
| eureka_server_1 |   注册中心   |  8061  |
| eureka_server_2 |   注册中心   |  8062  |
|   zuul_server   |     网关     |  8071  |
| service_demo_1  |   Demo业务   |  8081  |
| service_demo_2  |   Demo业务   |  8082  |
|  feign_server   |   负载均衡   |  8091  |
|  ribbon_server  |   负载均衡   |  8092  |



#####	Netflix服务架构示意图

![服务架构示意图](https://github.com/lautrix/Spring-Cloud-Netflix_TechPra/blob/master/ConfigFiles/spring-cloud%20netflix%E6%9C%8D%E5%8A%A1%E6%9E%B6%E6%9E%84%E7%A4%BA%E6%84%8F%E5%9B%BE.jpg)

#####	Module重点内容说明

- config_server（8041）：

  ​	使用spring cloud config作为框架的线上配置中心。将子工程中可修改的配置文件，以文件形式保存在线上服务器。本例中使用GitHub作为远程仓库，且开源。在实际项目开发中，从安全保密角度考虑，应该自行选自私有仓库存储配置文件，例如搭建GitLab。

  ​	POM中添加对spring cloud config的依赖：

  ```java
  <dependency>
     <groupId>org.springframework.cloud</groupId>
     <artifactId>spring-cloud-config-server</artifactId>
  </dependency>
  ```

  ```properties
  eureka:
    client:
      serviceUrl:
        defaultZone: http://eureka-server-1:8061/eureka, http://eureka-server-2:8062/eureka # 注册Eureka server
  server:
    port: 8041 #当前服务注册端口号
  
  spring:
    cloud:
      config:
        server:
          git:
            uri: https://github.com/lautrix/Spring-Cloud-Netflix_TechPra.git # 配置文件远程服务器地址
            searchPaths: ConfigFiles  # 配置文件相对路径
            label: master # 分支
  #          username: repo_username   # 当远程服务器为私有库时才需要填写
  #          password: repo_password
            force-pull: true
    application:
      name: config-server
  ```

  

- 

- 

- 

- 

  

