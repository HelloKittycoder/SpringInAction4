package com.kittycoder.jdk;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

/**
 * Created by shucheng on 2020/7/22 10:32
 */
public class Client {
    public Client() {
    }

    public static void main(String[] args) {
        String host = (args.length < 1) ? null : args[0];
        try {
            Registry registry = LocateRegistry.getRegistry(host);
            Hello stub = (Hello) registry.lookup("Hello");
            String response = stub.sayHello();
            System.out.println("response: " + response);
        } catch (Exception e) {
            System.err.println("Client exception: " + e.toString());
            e.printStackTrace();
        }
    }
}
