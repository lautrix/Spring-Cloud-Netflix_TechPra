package com.lautrix.ribbon_service.utils;

/**
 * 启动类注解：@RibbonClient(configuration = IBalanceRule.class) //自定义负载策略
 * configuration参数指定了ribbon的配置类为当前类
 * 在当前类中实现自定义负载均衡策略iRule
 * 自定义负载均衡策略除了Ribbon内置策略之外，还可以自定义实现
 */
//@Configuration
//public class IBalanceRule {
//
//  @Bean
//  @LoadBalanced
//  public RestTemplate restTemplate() {
//    return new RestTemplate();
//  }
//
//  @Bean
//  public IRule iBalanceRule(){
//    System.out.println("IBalanceRule.class");
//    return new RoundRobinRule();
//  }
//}
