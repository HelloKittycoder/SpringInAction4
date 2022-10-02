### 20.3 处理通知
解决listener无法收到通知的问题
```java
@Configuration
@EnableMBeanExport
public class MBeanConfig {

    @Autowired
    private PagingNotificationListener pagingNotificationListener;

    @Bean
    public MBeanExporter mBeanExporter() {
        MBeanExporter exporter = new MBeanExporter();
        Map<String, PagingNotificationListener> mappings = new HashMap<>();
        mappings.put("spitter:name=PagingNotificationListener",
                pagingNotificationListener);
        exporter.setNotificationListenerMappings(mappings);
        return exporter;
    }
}
```

#### 先说说上面的配置问题出在哪：

问题1：@EnableMBeanExport创建了一个MBeanExporter，mBeanExporter方法也创建了一个MBeanExporter。

其实，原本应该只有一个MBeanExport。用@EnableMBeanExport注解是想让spring自动扫描带@ManagedResource注解的bean，然后暴露成MBean，

这里的本意是在已创建的MBeanExporter中添加一个监听器配置

问题2：这里受spring in action（4th edition）书上的代码误导，原样复制了过来，其实正常这里是要添加被监听对象（spitter:name=SpitterNotifier）和监听器（pagingNotificationListener）的关联关系，

但上面的代码却写成了监听器对象和监听器的关联关系

#### 明白了问题出在哪，问题就好解决了。以下为解决过程：

问题1：@EnableMBeanExport和mBeanExporter方法，只能留其中一个。首先@EnableMBeanExport要保留，mBeanExporter方法要去掉，但是里面添加监听关系的代码要写到别的地方

但是别的地方是哪呢？这里涉及bean的初始化过程，这里不能等MBean完全创建好之后再添加监听关系，必须在调用afterPropertiesSet、afterSingletonsInstantiated（这一步是实际注册监听器的步骤）之前调用，

用BeanPostProcessor#postProcessBeforeInitialization就能解决这个问题

问题2：改成下面的即可
```java
mappings.put("spitter:name=SpitterNotifier",
                pagingNotificationListener);
```

所有修改之后的配置变成了
```java
@Configuration
@EnableMBeanExport
public class MBeanConfig implements BeanPostProcessor {

    @Autowired
    private PagingNotificationListener pagingNotificationListener;

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        if ("mbeanExporter".equals(beanName)) {
            MBeanExporter exporter = (MBeanExporter) bean;
            Map<String, PagingNotificationListener> mappings = new HashMap<>();
            mappings.put("spitter:name=SpitterNotifier",
                    pagingNotificationListener);
            exporter.setNotificationListenerMappings(mappings);
        }
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        return bean;
    }
}
```

#### 为什么会想到“MBean的创建过程中调用了afterSingletonsInstantiated才会注册监听器，之后手动setMappings会没效果”？
在网上找了很多解决方案，都是复制粘贴，基本都没验证过；最后想到spring源码（5.1.x）中肯定有相关类的单元测试，我在看了NotificationListenerTests#testRegisterNotificationListenerWithBeanNameBeforeObjectNameMappedToSameBeanInstance
之后（该测试类中调了一个start方法），明白了大致的流程，想到了解决方案
