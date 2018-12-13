package ch.epfl.sweng.dp1.ex4;

public class Main {

    public static void main(String[] args) {
        // A PC with 2 GB RAM, 500 GB HDD, 2.4HZ CPU
        ComputerFactory pc = new PCFactory("2", "500", "2.4");// Your implementaion
        // A Server with 16GB RAM, 1 TB HDD, 2.9GHZ GPU
        ComputerFactory server = new ServerFactory("16", "1", "2.9");// Your implementation
        System.out.println("PC Config::" + pc.createComputer());
        System.out.println("Server Config::" + server.createComputer());
    }
}