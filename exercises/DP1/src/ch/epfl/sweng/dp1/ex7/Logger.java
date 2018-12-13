package ch.epfl.sweng.dp1.ex7;

public class Logger {

    public static final Logger loggerInstance = new Logger();

    private Logger(){
        if(loggerInstance != null){
            throw new IllegalStateException("Instance exists!");
        }
    }

    public static Logger getInstance() {
        return loggerInstance;
    }

    public void print(){
        System.out.println("Logged");
    }
}