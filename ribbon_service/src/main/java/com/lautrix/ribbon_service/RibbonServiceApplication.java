package com.lautrix.ribbon_service;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@EnableEurekaClient
@EnableCircuitBreaker
@EnableHystrixDashboard
// @RibbonClient(name = "service-ribbon-modify", configuration = IBalanceRule.class) //自定义负载策略
public class RibbonServiceApplication {

  public static void main(String[] args) {
    SpringApplication.run(RibbonServiceApplication.class, args);
  }

  /**
   * 在向服务中心注册一个名为restTemplate的bean，用来指示需要做负载均衡
   */
  @Bean
  @LoadBalanced
  public RestTemplate restTemplate() {
    return new RestTemplate();
  }

  /**
   * IRule: Ribbon核心组件，负载均衡策略。内置策略如下： RoundRobinRule:轮询 AvailabilityFilteringRule:
   * 会先过滤掉由于多次访问故障而处于断路器跳闸状态的服务,以及并发的连接数量，超过阈值的服务,然后对剩余的服务列表按照轮询策略进行访问; WeightedResponseTimeRule:
   * 根据平均响应时间计算所有服务的权重,响应时间越快,服务权重越大,被选中的机率越高（刚启动时,如果统计信息不足,则使用RoundRobinRule策略,等统计信息足够时,会切换到WeightedResponseTimeRule）;
   * RetryRule: 先按照RoundRobinRule的策略获取服务,如果获取服务失败,则在指定时间内会进行重试,获取可用的服务; BestAvailableRule:
   * 会先过滤掉由于多次访问故障而处于断路器跳闸状态的服务,然后选择一个并发量最小的服务; ZoneAvoidanceRule: 默认规则,复合判断server所在区域的性能和server的可用性选择服务器;
   */
  @Bean
  public IRule iRule() {
    System.out.println("RibbonServiceApplication.class");
    return new RandomRule();
  }

}
