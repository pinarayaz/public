package ch.epfl.sweng.interpreter;

import java.util.ArrayList;
import java.util.HashMap;

public class CacheNode{

    private HashMap<Integer, Integer> cachedData;

    public CacheNode(HashMap<Integer, Integer> cachedData){
        this.cachedData = cachedData;
    }

    public HashMap<Integer, Integer> getCachedData() {
        return cachedData;
    }
}
