package com.kittycoder.rmi;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

/**
 * Created by shucheng on 2020/7/22 9:25
 */
public class RemoteMath extends UnicastRemoteObject implements IRemoteMath {

    private int numberOfComputations;

    public RemoteMath() throws RemoteException {
        numberOfComputations = 0;
    }

    @Override
    public double add(double a, double b) {
        numberOfComputations++;
        System.out.println("Number of computations performed so far = "
            + numberOfComputations);
        return a + b;
    }
}
