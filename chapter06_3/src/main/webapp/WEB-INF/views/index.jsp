<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Spel表达式使用示例</title>
    <style type="text/css">
        .container {
            word-break: break-word;
        }
        .container span {
            font-size: 20px;
            font-weight: bold;
        }
    </style>
</head>
<body>
<div>
    <h2>测试spel表达式</h2>
    <div class="container">
        <span>pageContext.request.contextPath=</span><s:eval expression="pageContext.request.contextPath"/>
    </div>
    <div class="container">
        <span>System.getProperty=</span><s:eval expression="T(System).getProperty('file.encoding')"/>
    </div>
    <%--<div class="container">
        <span>System.getProperties=</span><s:eval expression="T(System).getProperties()"/>
    </div>--%>
    <!-- 可以通过 @beanId 获取一个bean的引用 -->
    <div class="container">
        <span>mycontext=</span><s:eval expression="@systemProperties.size()"/>
    </div>
    <div class="container">
        <span>studentMap['1']=</span><s:eval expression="studentMap['1']"/>
        <span>mycontext=</span><s:eval expression="mycontext.getBeanDefinitionNames()"/>
    </div>
    <div class="container">
        <span>student=</span><s:eval expression="studentPojo+''"/>
        <!-- 和上面效果是一样的 -->
        <%--<span>student=</span><s:eval expression="studentPojo.toString()"/> --%>
    </div>
</div>


<div>
    <h2>测试el表达式</h2>
    <!-- 使用forEach进行简单的数字循环 -->
    <div class="container">
        <c:forEach begin="1" end="5" var="num">
            ${num}
        </c:forEach>
    </div>
    <!-- varStatus可以得知每个循环的item是处于studentList的哪个位置 -->
    <div class="container">
        <c:forEach items="${studentList}" var="student" varStatus="sta">
            ${student.id}==${student.name}==${student.age}==varStatus【${sta.index}】<br/>
        </c:forEach>
    </div>
</div>
</body>
</html>
