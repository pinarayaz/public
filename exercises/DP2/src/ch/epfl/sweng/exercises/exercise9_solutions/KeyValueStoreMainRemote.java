package ch.epfl.sweng.exercises.exercise9_solutions;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.RemoteException;

public class KeyValueStoreMainRemote {

    public static void main(String[] args) {
        KeyValueStoreRemote store;

        try {
            store = new KeyValueStoreImplRemote();
            Naming.rebind("//localhost/kvstore", store);
        } catch (RemoteException e) {
            e.printStackTrace();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
    }
}
