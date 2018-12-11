package ch.epfl.sweng.dp1.ex3;

import java.util.ArrayList;
import java.util.List;

public class DataStore {
    private String data;
    ArrayList<Observer> observers = new ArrayList<>();

    public String getData() {
        return data;
    }

    public void addObserver(Observer o){
        observers.add(o);
    }

    public void setData(String data) {
        this.data = data;
        updateObservers();
    }

    private void updateObservers(){
        for(Observer o: observers){
            o.update(data);
        }
    }
}