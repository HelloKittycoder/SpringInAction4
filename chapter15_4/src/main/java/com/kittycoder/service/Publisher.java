package com.kittycoder.service;

import javax.xml.ws.Endpoint;

/**
 * Created by shucheng on 2020/7/23 21:44
 */
public class Publisher {

    public static void main(String[] args) {
        String url = "http://localhost:8080/server";
        Endpoint.publish(url, new SpitterServiceEndpoint());
        System.out.println("发布成功");
    }
}
