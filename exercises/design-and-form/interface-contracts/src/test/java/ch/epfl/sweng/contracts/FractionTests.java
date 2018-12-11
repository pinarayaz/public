
package ch.epfl.sweng.contracts;

import org.junit.Test;
import static org.junit.Assert.*;
import com.google.java.contract.PreconditionError;


public class FractionTests {

    @Test(expected = PreconditionError.class)
    public void fractionWithZeroFails() {
        Fraction f = new Fraction(5, 0);
        f.toInt();
    }

    @Test
    public void validFraction() {
        Fraction f = new Fraction(5,2);
        assertEquals(2, f.toInt());
    }
}
