// Namebook: CS305, SwEng Final Exam 2015.
// Author: James Larus, james.larus@epfl.ch

package ch.epfl.sweng.tests;

import ch.epfl.sweng.Main;
import ch.epfl.sweng.NameBook;
import org.junit.Test;

import java.io.*;
import java.util.List;

import static org.junit.Assert.assertEquals;

public final class NameBookTests {

    @Test
    public void main() throws IOException {
        System.out.println(new File(".").getAbsolutePath());
        List<String[]> friends = Main.readFriends(new FileInputStream("friends.txt"));
        NameBook nb = new NameBook(friends);

        assertEquals(3, nb.findFriends("alice", 1).size());
        assertEquals(3, nb.findFriends("alice", 2).size());

        assertEquals(1, nb.findFriends("bob", 1).size());
        assertEquals(2, nb.findFriends("bob", 2).size());
    }

    @Test
    public void testFindPerson() throws IOException {
        System.out.println(new File(".").getAbsolutePath());
        List<String[]> friends = Main.readFriends(new FileInputStream("friends.txt"));
        NameBook nb = new NameBook(friends);

        assertEquals("alice", nb.findPerson("alice").getData());
    }

    @Test
    public void testPrintFriendships() throws IOException {
        System.out.println(new File(".").getAbsolutePath());
        List<String[]> friends = Main.readFriends(new FileInputStream("friends.txt"));
        NameBook nb = new NameBook(friends);

        String expected = "alice\n" +
                "- bob\n" +
                "- carol\n" +
                "- ted\n" +
                "bob\n" +
                "- ted\n" +
                "ted\n" +
                "- carol";

        assertEquals(expected, nb.printFriendships());
    }
}