package com.kittycoder.jdk;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

/**
 * Created by shucheng on 2020/7/22 10:28
 * jdk官方的例子
 * https://docs.oracle.com/javase/7/docs/technotes/guides/rmi/hello/hello-world.html
 *
 * Finally, the client invokes the sayHello method on the remote object's stub, which causes the following actions to happen:
 *
 * The client-side runtime opens a connection to the server using the host and port information in the remote object's stub and then serializes the call data.
 * The server-side runtime accepts the incoming call, dispatches the call to the remote object, and serializes the result (the reply string "Hello, world!") to the client.
 * The client-side runtime receives, deserializes, and returns the result to the caller.
 *
 * 从客户端调用sayHello方法，到远程对象返回数据，中间经历了以下几个操作：
 * 1. 客户端运行时通过host和port信息开启一个和服务端的连接，通向远程对象，并且把调用数据（需要调用哪个类、哪个方法）序列化传给服务端
 * 2. 服务端运行时接收发来的调用，将调用分发给相应的远程对象进行处理，然后把处理结果（响应字符串“Hello, world!”）序列化返回给客户端
 * 3. 客户端运行时接收处理结果，并将其反序列化，最后把结果返回给调用者
 */
public class Server implements Hello {
    @Override
    public String sayHello() {
        return "Hello, world!";
    }

    public static void main(String[] args) {
        try {
            Server obj = new Server();
            Hello stub = (Hello) UnicastRemoteObject.exportObject(obj, 0);

            // 说明：jdk官方给的代码写错了，这里应该是createRegistry，而不是getRegistry
            Registry registry = LocateRegistry.createRegistry(Registry.REGISTRY_PORT); // 参考https://www.codota.com/code/java/methods/java.rmi.server.UnicastRemoteObject/exportObject
            registry.bind("Hello", stub);

            System.err.println("Server ready");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
