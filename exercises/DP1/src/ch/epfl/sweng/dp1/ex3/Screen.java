package ch.epfl.sweng.dp1.ex3;

public class Screen implements Observer{
    public void update(String data){
        System.out.println("Screen - New data : " + data);
    }
}