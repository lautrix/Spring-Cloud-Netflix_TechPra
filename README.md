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

- config_server：

  ​	配置文件管理中心。使用Spring-Cloud Config作为框架的线上配置中心。将子工程中可修改的配置文件，以文件形式保存在线上服务器。本例中使用GitHub作为远程仓库，且开源。在实际项目开发中，从安全保密角度考虑，应该自行选自私有仓库存储配置文件，例如搭建GitLab。

- turbine_server：

  ​	监控聚合中心。Netflix中使用Hystrix作为服务熔断与故障监控组件，但Hystrix的监控范围仅限于当前工程内，无法做到对多个工程的服务进行同时监控。进而引入Turbine组件，实现监控聚合功能。

- eureka_server：

  ​	服务注册中心。在Netflix框架中，除开作为Eureka注册中心的服务节点之外，其他的服务都将在注册中心中注册。Eureka注册中心通过ServiceID对服务进行分组，开发人员可高度自由的管理服务分组，自由增删同组中服务器节点，操作过程对其他应用透明。注册中心是实现框架中组件高可用的基础组件。

- zuul_server：

  ​	网关。Zuul组件在启动之后会首先从Eureka注册中心获取已经注册的服务，作为微服务的入口，Zuul会对前端发起的请求进行分发到负载中心或者具体的业务工程中。Zuul通过ServiceID匹配在Eureka注册中心中注册的服务，对请求进行分发。通过配置访问路径，可以对请求URL进行过滤。

- ribbon_server && feign_server：

  ​	负载均衡。Ribbon与Feign同为负载均衡，实现方式不同。很多技术博客中认为Feign是对Ribbon的进一步封装，目前为止我上不能明辨这两者之间的优劣。

  ​	Ribbon在作为负载均衡时，需要显式注册一个类型为RestTemplate的Bean，在进行请求转发时，通过RestTemplate的实例来实现HTTP请求，由此看来，RestTemplate类似于HttpClient。

  ```java
    /**
     * 在向服务中心注册一个名为restTemplate的bean，用来指示需要做负载均衡
     */
    @Bean
    @LoadBalanced
    public RestTemplate restTemplate() {
      return new RestTemplate();
    }
  ```

  ```java
  @Autowired
      private RestTemplate restTemplate;
  
      @HystrixCommand(fallbackMethod = "callFailure")
      public String getRibbonContent(){
          // url中的值不能包含下划线。如：SERVICE-DEMO_1 这种配置非法.但是可以包含连接线-
          String url = URLConstructor.url(DomainConfig.ServiceClient, ApiConfig.GetContent);
          Object object = null;
          return restTemplate.getForObject(url,String.class);
      }
  ```

  ​	Feign则不需要显式注册Bean，Feign通过@FeignClient(value = "", fallback = "")注解来分别指向Eureka注册中心中的ServiceID。

  ```java
  @FeignClient(value = "SERVICE-DEMO", fallback = FeignFailureServiceImpl.class)
  public interface FeignService {
      @RequestMapping("/")
      public String getConfigContent();
  
      @RequestMapping("/config")
      public String getConfigValue();
  ```

- service_demo：

  ​	HelloWorld！模拟的业务实例。