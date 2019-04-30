# Spring-Cloud-Netflix_TechPra
###		Spring-Cloud-Netflix技术实践

#####	开发环境

| 操作系统  |  Java版本  |     maven版本     |  spring boot  | spring cloud  | IDE  |
| :-------: | :--------: | :---------------: | :-----------: | ------------- | ---- |
| windows10 | jdk-11.0.2 | apach maven 3.6.0 | 2.1.4.RELEASE | Greenwich.SR1 | idea |

#####	工程说明

|     工程名      |  工程内容说明  | 端口号 |
| :-------------: | :------------: | ------ |
|  eureka_server  |  服务注册中心  | 8080   |
| eureka_client_1 | 模拟业务模块1  | 8081   |
| eureka_client_2 | 模拟业务模块2  | 8082   |
|  config_server  |  配置文件中心  | 8090   |
|  feign_service  | 服务间相互访问 | 8091   |
| ribbon_service  |    负载均衡    | 8092   |
|  zuul_service   |      网关      | 8093   |



#####	Netflix服务架构示意图

![服务架构示意图](https://github.com/lautrix/Spring-Cloud-Netflix_TechPra/blob/master/ConfigFiles/spring-cloud%20netflix%E6%9C%8D%E5%8A%A1%E6%9E%B6%E6%9E%84%E7%A4%BA%E6%84%8F%E5%9B%BE.jpg)

#####	服务架构简要说明

- eureka_server（127.0.0.1:8080）：

  架构整体的服务注册中心。在架构中作为服务注册中心，提供服务注册功能。

- config_server（127.0.0.1:8090）：

  配置中心。线上保存项目配置文件，供子服务远程下载、同步服务配置。本例中在公共仓库中上传的配置文件为示例文件。实际项目中应在私有仓库或自行搭建如GitLab等仓库作为配置中心，以免信息泄露。

- 

- 

- 

  

