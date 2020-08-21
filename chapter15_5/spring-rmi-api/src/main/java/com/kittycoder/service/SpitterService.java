package com.kittycoder.service;

import javax.jws.WebService;

/**
 * Created by shucheng on 2020/7/22 12:28
 */
@WebService(targetNamespace = "http://endpoint.kittycoder.com/")
public interface SpitterService {

    String sayHello(String name);
}
