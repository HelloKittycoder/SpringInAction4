package com.kittycoder.rmi;

import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 * Created by shucheng on 2020/7/22 9:24
 */
public interface IRemoteMath extends Remote {

    double add(double a, double b) throws RemoteException;
}
