package ch.epfl.sweng.dp1.ex3;

public class Phone implements Observer{
     public void update(String data){
        System.out.println("Phone - New data : " + data);
    }
}
