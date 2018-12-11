package ch.epfl.sweng.interpreter;

import java.util.ArrayList;
import java.util.HashMap;

public class CacheNode{
    private String functionName;
    private HashMap<Integer, Integer> cachedData;

    public CacheNode(String functionName, HashMap<Integer, Integer> cachedData){
        this.functionName = functionName;
        this.cachedData = cachedData;
    }

    public String getFunctionName() {
        return functionName;
    }

    public HashMap<Integer, Integer> getCachedData() {
        return cachedData;
    }
}
