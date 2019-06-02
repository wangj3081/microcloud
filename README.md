# microcloud
Spring Cloud集成组件

 从一个 Echo 程序学习 Spring Cloud 的组件集成,当前集成的组件有:
- Consul
  用作服务发现
- Gateway
  用作网关代理
- hystrix
  用作熔断处理
- hystrix dashbord
  用作可视化服务监控，需要与 hystrix 配合使用
- turbine
  将多个 hystrix 的接口应用集成在一起监控，通过 dashbord 来做可视化
展示
- zipkin 服务链路跟踪(使用官方服务版本已完成)