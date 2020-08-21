package com.kittycoder.service;

import my.SpitterService;
import my.SpitterServiceEndpoint;

/**
 * Created by shucheng on 2020/7/23 21:57
 * wsimport -s D:\Code\shucheng\IntelliJIdeaProjects\readBookProjects\springinaction\chapter15_4\src\main\java -p my http://localhost:8080/server?wsdl
 * 说明：com.kittycoder.service.my下面的类是通过上面的命令生成的
 */
public class Client {
    public static void main(String[] args) throws Exception {
        /*URL url = new URL("http://localhost:8080/server");
        QName qName = new QName("http://service.kittycoder.com/", "SpitterService");
        Service service = Service.create(url, qName);
        SpitterServiceEndpoint endpoint = service.getPort(SpitterServiceEndpoint.class);
        endpoint.sayHello("张三");*/

        SpitterService server = new SpitterService();
        SpitterServiceEndpoint endPointPort = server.getSpitterServiceEndpointPort();
        System.out.println(endPointPort.sayHello("张三"));
    }
}
