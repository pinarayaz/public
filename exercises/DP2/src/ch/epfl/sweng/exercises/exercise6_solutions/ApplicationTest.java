package ch.epfl.sweng.exercises.exercise6_solutions;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ApplicationTest {

    @Test
    public void testDecoratedUser() {
        User user = new DecoratedUser(new User("the_donald"), "Donald", "Clinton", 66);
        assertEquals("first name: Donald, last name: Clinton, age: 66", user.getPersonalInfo());
        assertEquals("the_donald", user.getUsername());
    }

    @Test
    public void testCapitalizedUser() {
        User user = new CapitalizedUser(new User("the_donald"));
        assertEquals("THE_DONALD", user.getUsername());
    }
}
