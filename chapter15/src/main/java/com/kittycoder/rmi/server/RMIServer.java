package com.kittycoder.rmi.server;

import com.kittycoder.rmi.IRemoteMath;
import com.kittycoder.rmi.RemoteMath;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

/**
 * Created by shucheng on 2020/7/22 9:28
 * 网上找的例子
 * https://blog.csdn.net/qq_28081453/article/details/83279066
 */
public class RMIServer {

    public static void main(String[] args) {
        try {
            // 注册远程对象，向客户端提供远程服务对象
            IRemoteMath remoteMath = new RemoteMath();
            LocateRegistry.createRegistry(1099);
            Registry registry = LocateRegistry.getRegistry();
            registry.bind("Compute", remoteMath);
            System.out.println("Math server ready.");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
