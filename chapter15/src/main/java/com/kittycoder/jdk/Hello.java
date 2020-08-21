package com.kittycoder.jdk;

import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 * Created by shucheng on 2020/7/22 10:28
 */
public interface Hello extends Remote {
    String sayHello() throws RemoteException;
}
