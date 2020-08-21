package com.kittycoder.endpoint;

import com.kittycoder.service.SpitterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.context.support.SpringBeanAutowiringSupport;

import javax.jws.WebMethod;
import javax.jws.WebService;

/**
 * Created by shucheng on 2020/7/23 22:44
 * 访问地址：http://localhost:8080/SpitterService?wsdl
 *
 * 这里如果用继承SpringBeanAutowiringSupport、但不写@Component的方式，
 * 发现无法发布服务，也不会报错，后续有空找下原因
 */
@Component
@WebService(serviceName = "SpitterService")
public class SpitterServiceEndpoint {
    /*public SpitterServiceEndpoint() {
        System.out.println("=========初始化SpitterServiceEndpoint========");
    }*/

    @Autowired
    private SpitterService spitterService;

    @WebMethod
    public String sayHello(String name) {
        System.out.println("执行SpitterServiceEndpoint#sayHello方法");
        return spitterService.sayHello(name);
    }
}
