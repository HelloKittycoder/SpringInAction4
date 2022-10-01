### 20.2 远程MBean
项目结构 这里用的是rmi远程访问协议
rmi_mbean_server mbean服务端（将mbean通过rmi暴露成远程对象）  
rmi_mbean_client mbean客户端（访问rmi远程服务上的mbean）  

- 服务端部分

可能遇到的问题：项目无法启动（我这个是通过tomcat启动的）
```text
Caused by: java.io.IOException: Cannot bind to URL [rmi://localhost:1099/spitter]: javax.naming.CommunicationException [Root exception is java.rmi.ServerException: RemoteException occurred in server thread; nested exception is: 
	java.rmi.UnmarshalException: error unmarshalling arguments; nested exception is: 
	java.io.InvalidClassException: filter status: REJECTED]
```
rmi端口不要用1099，改用1199就可以了（原因未知）

```text
Cannot bind to URL [rmi://localhost:1199/spitter]: javax.naming.ServiceUnavailableException [Root exception is java.rmi.ConnectException: Connection refused to host: localhost; nested exception is: 
	java.net.ConnectException: Connection refused: connect]
```
改完端口后，还可能报上面的问题，解决思路是：保证RmiRegistryFactoryBean先于ConnectorServerFactoryBean创建
（方法1：先声明RmiRegistryFactoryBean，后声明ConnectorServerFactoryBean即可；方法2：通过@DependsOn强制控制先后顺序（推荐），这种不会受声明的先后顺序影响）

上面遇到的两个问题都是参考 https://blog.csdn.net/hefrankeleyn/article/details/89790135 解决的


- 客户端访问部分

20.2.2 访问远程MBean（MBeanClientTest）  
这种是直接访问的方式（通过MBeanServerConnection来访问）  

20.2.3 代理MBean（MBeanProxyClientTest）  
这种是通过代理方式访问  
可能遇到的问题：通过MBeanProxyClientConfig配置，无法正常启动MBeanProxyClientTest
```text
[2022-10-01 20:19:18]WARN  AbstractBeanFactory(L:1427) -Bean creation exception on FactoryBean type check: org.springframework.beans.factory.BeanCurrentlyInCreationException: Error creating bean with name 'remoteSpittleControllerMBean': Requested bean is currently in creation: Is there an unresolvable circular reference?

java.lang.NullPointerException
	at javax.management.MBeanServerInvocationHandler.isLocal(MBeanServerInvocationHandler.java:475)
	at javax.management.MBeanServerInvocationHandler.shouldDoLocally(MBeanServerInvocationHandler.java:420)
	at javax.management.MBeanServerInvocationHandler.invoke(MBeanServerInvocationHandler.java:252)
	at org.springframework.jmx.access.MBeanClientInterceptor.doInvoke(MBeanClientInterceptor.java:401)
	at org.springframework.jmx.access.MBeanClientInterceptor.invoke(MBeanClientInterceptor.java:349)
```

SpittleControllerManagedOperations这个代理bean，如果直接打印会报空指针异常，不打印出来即可

