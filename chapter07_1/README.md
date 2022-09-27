### springmvc 在web.xml中声明DispatcherServlet（使用xml配置）
包扫描的写法：
servlet-context.xml（DispatcherServlet）
root-context.xml（ContextLoaderListner）

写法1（chapter07_1目前写的是这种，但不推荐使用）：

servlet-context.xml 扫描 spittr.web、spittr.data（所有的bean）
root-context.xml 不扫描

servlet-context.xml
```xml
<context:component-scan base-package="spittr.web, spittr.data"/>
```

root-context.xml 空着，不用扫描
```xml
```

写法2（推荐使用）：

servlet-context.xml 扫描 spittr.web（所有controller对应的类，DispatcherServlet相关）
root-context.xml 扫描除controller以外的的所有类（后端中间层 service、数据层 repository 需要的bean）

servlet-context.xml
```xml
<context:component-scan base-package="spittr.web"/>
```

root-context.xml 扫描除 spittr.web包以外的所有bean
```xml
<context:component-scan base-package="spittr">
    <context:exclude-filter type="regex" expression="spittr\.web\..*"/>
</context:component-scan>
```
