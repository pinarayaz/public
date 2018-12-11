package ch.epfl.sweng.contracts;

import com.google.java.contract.Invariant;
import com.google.java.contract.Requires;

@Invariant("d != 0")
public class Fraction {
    private int n;
    private int d;

    @Requires("d != 0")
    public Fraction(int n, int d) {
        this.n = n;
        this.d = d;
    }

    public int toInt() {
        return n/d;
    }
}