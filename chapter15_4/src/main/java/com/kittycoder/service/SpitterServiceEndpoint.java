package com.kittycoder.service;

import javax.jws.WebMethod;
import javax.jws.WebService;

/**
 * Created by shucheng on 2020/7/23 21:42
 */
@WebService(serviceName = "SpitterService")
public class SpitterServiceEndpoint {

    @WebMethod
    public String sayHello(String name) {
        System.out.println("执行SpitterServiceEndpoint#sayHello方法");
        return "Hello, " + name;
    }
}
