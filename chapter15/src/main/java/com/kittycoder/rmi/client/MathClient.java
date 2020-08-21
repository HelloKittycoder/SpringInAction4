package com.kittycoder.rmi.client;

import com.kittycoder.rmi.IRemoteMath;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

/**
 * Created by shucheng on 2020/7/22 9:31
 */
public class MathClient {

    public static void main(String[] args) {
        try {
            Registry registry = LocateRegistry.getRegistry("localhost");
            // 从Registry中检索远程对象的名称
            IRemoteMath remoteMath = (IRemoteMath) registry.lookup("Compute");
            // 调用远程对象的方法
            double addResult = remoteMath.add(5.0, 3.0);
            System.out.println("5.0 + 3.0 = " + addResult);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
