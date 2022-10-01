Spring学习  
#### 第1部分 Spring的核心
- **第1章** [Spring之旅]()  
- **第2章** [装配Bean]()  
chapter02 自动化装配Bean  
chapter02_1 通过Java代码装配bean  
chapter02_2 通过XML装配bean、导入和混合配置  
- **第3章** [高级装配]()  
environment 环境与profile  
condition 条件化的bean  
ambiguous 处理自动装配的歧义性  
external 运行时值注入（注入外部的值）  
- **第4章** [面向切面的Spring]()  
chapter04 使用注解创建切面  
ConcertConfigTest 使用注解创建切面  
TrackCounterTest 处理通知中的参数（使用注解）  
IntroducerConfigTest 通过切面引入新的功能（使用注解）  
performancemonitor 该包引入的是tutorials开源项目中的spring-aop示例  
chapter04_1 使用XML创建切面  
ConcertXmlConfigTest 使用XML创建切面  
TrackCounterTest 处理通知中的参数（使用XML）  
IntroducerConfigTest 通过切面引入新的功能（使用XML）  
chapter04_2 注入aspectJ切面（这块没弄好，后续再深入）  
chapter04_3 学习spring aop切点参数的各种用法（这块没弄好，后续再深入）  
说明：“处理通知中的参数、通过切面引入新的功能”这两个在xml中也能弄  
#### 第2部分 Web中的Spring
- **第5章** [构建SpringWeb应用]()  
test/java部分  
HomeControllerTest 编写基本控制器  
SpittleControllerTest 接收请求的输入（查询参数、路径参数）  
SpitterControllerTest 处理表单（接收表单参数、校验表单参数）  
- **第6章** [渲染Web视图]()  
chapter06 创建JSP视图  
chapter06_1 使用Apache Tiles视图定义布局  
chapter06_2 使用Thymeleaf  
chapter06_3 spel表达式（既可以在java代码中使用，也能在jsp使用）  
- **第7章** [SpringMVC的高级技术]()  
chapter07 7.1.2 添加其他的Servlet和Filter  
chapter07_1 7.3 在web.xml中声明DispatcherServlet（使用xml配置）  
chapter07_2 7.4 在web.xml中声明DispatcherServlet（使用java配置，在web.xml中引用java配置）  
chapter07_3 7.4 在web.xml中声明DispatcherServlet（使用java配置，完全基于java配置，不需要web.xml；利用SPI实现）  
chapter07_4 7.4 测试Multipart，ExceptionHandler，flash属性  
- **第9章** [保护Web应用]()  
#### 第3部分 后端中的Spring
- **第10章** [通过Spring和JDBC征服数据库]()  
chapter10 H2数据库简单使用（带web控制台）  
chapter10_1 数据源（连接池数据源、JDBC驱动的数据源、嵌入式数据源）的创建  
使用java配置创建 DataSourceConfig.java  
使用xml配置创建 datasource-config.xml  
chapter10_2 复习jdbc使用 JdbcSpitterTest.java  
chapter10_3 JdbcTemplate使用  
JdbcSpitterRepositoryTest.java 使用JdbcTemplate改写jdbc中的写法（基于chapter10_2修改）  
其中addSpitter2是基于命名参数来写的  
- **第11章** [使用对象-关系映射持久化数据]()  
chapter11 在Spring中集成Hibernate4
chapter11_1 在Spring中集成Hibernate4和jpa
chapter11_2 chapter11_3 Spring与Java持久化API 借助Spring Data实现自动化的JPA Repository（没搞定，后续有空再弄）  
- **第12章** [使用NoSQL数据库]()  
- **第13章** [缓存数据]()  
- **第14章** [保护方法应用]()  
#### 第4部分 Spring集成
- **第15章** [使用Spring远程服务]()  
chapter15 java中的rmi使用（com.kittycoder.jdk 官方的例子；com.kittycoder.rmi 网上找的例子）  
chapter15_1 spring整合rmi（分模块）  
不分模块的 src目录  
分模块的 spring-rmi-api、spring-rmi-server、spring-rmi-client（这个有点问题后续再看下）  
chapter15_2 使用Hessian和Burlap发布远程服务  
使用：（1）通过tomcat来发布Hessian（SpitterServiceImpl）和Burlap（SpittleServiceImpl）服务，启动spring-rmi2-server项目  
（2）测试发布的服务是否可用（SpringRmiClientTest），运行spring-rmi2-client项目  
chapter15_3 使用Spring的HttpInvoker发布远程服务  
chapter15_4 简单使用下JAX-WS（这部分后续有时间再深入）  
chapter15_5 结合spring使用JAX-WS  
- **第16章** [使用Spring MVC创建REST API]()  
chapter16 内容协商、RestTemplate的使用  
- **第17章** [Spring消息]()  
说明：整合jms部分使用的是activemq，amqp使用的是rabbitmq  
chapter17 spring整合jms  
jms 不借助spring，使用传统的jms发送和接收消息  
springjms spring整合jms发送和接收消息（异步发送，同步接收，异步接收）  
chapter17_1 spring整合jms-应用于RPC  
chapter17_2 spring整合amqp（这部分还没弄明白，后续有时间再弄）  
- **第18章** [使用WebSocket和STOMP实现消息功能]()  
chapter18 使用Spring的低层级的WebSocket API  
chapter18_1 应对不支持WebSocket的场景（使用SockJS）  
chapter18_2 使用Stomp消息  
chapter18_3 使用Stomp消息发给指定用户（后续有时间再弄）  
- **第19章** [使用Spring发送Email]()  
chapter19 使用Spring发送Email（简单邮件、带附件、富文本）  
chapter19_1 使用模板生成Email（后续有时间再弄）  
- **第20章** [使用JMX管理Spring Bean]()  
chapter20 将Spring bean导出为MBean（MBeanExporter），通过名称暴露方法（MBeanInfoAssembler）  
chapter20_1 使用接口定义MBean的操作和属性（InterfaceBasedMBeanInfoAssembler）  
chapter20_2 使用注解驱动的MBean  
chapter20_3 处理MBean冲突  
chapter20_4 远程MBean  
chapter20_5 处理通知（这个没弄好，后续有时间再弄，能正常启动，但是收不到通知）  
- **第21章** [借助Spring Boot简化Spring开发]()  
chapter21 使用Spring Boot构建应用  
chapter21_1 组合使用Groovy与Spring Boot CLI（还不会用，后续有时间再弄）  
chapter21_2 补充：spring boot外部文件属性注入
