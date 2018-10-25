package ch.epfl.sweng.exercises.exercise4;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.Assert.assertEquals;

// import static org.junit.Assert.assertEquals;

public class GameTest {

    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();

    @Before
    public void setUpStreams() {
        System.setOut(new PrintStream(outContent));
    }

    @After
    public void cleanUpStreams() {
        System.setOut(null);
    }

    @Test
    public void testFunctionality() {
        int coinsForKill = 3049;
        System.out.print("You have killed the Monster and gained " + coinsForKill + " coins!");

//        TODO: uncomment the following lines and make sure you pass the test
//        Participant andy = new Player("Andy");
//        Participant jane = new Player("Jane");
//        Participant eve = new Player("Eve");
//        Participant ann = new Player("Ann");
//        Participant edith = new Player("Edith");
//        Participant oldBob = new Player("Old Bob");
//        Participant newBob = new Player("New Bob");
//
//        Participant bobs = new PlayersGroup("Bobs");
//        bobs.add(oldBob);
//        bobs.add(newBob);
//
//        Participant developers = new PlayersGroup("Developers");
//        developers.add(andy);
//        developers.add(jane);
//        developers.add(eve);
//        developers.add(bobs);
//
//        Participant participants = new PlayersGroup("all the participants");
//        participants.add(developers);
//        participants.add(ann);
//        participants.add(edith);
//
//        assertEquals(7, participants.getNumberOfPlayers());
//
//        participants.setCollectedCoins(participants.getCollectedCoins() + coinsForKill);
//
//        String expectedResult =
//                "You have killed the Monster and gained 3049 coins!" +
//                        "Player Andy has collected 255 coins" +
//                        "Player Jane has collected 254 coins" +
//                        "Player Eve has collected 254 coins" +
//                        "Player Old Bob has collected 127 coins" +
//                        "Player New Bob has collected 127 coins" +
//                        "Player Ann has collected 1016 coins" +
//                        "Player Edith has collected 1016 coins";
//        participants.getStatistics();

        // small hack (from https://stackoverflow.com/questions/1119385/junit-test-for-system-out-println)
        // to test what the getStatistics call printed on System.out
//        assertEquals(expectedResult, outContent.toString());
    }
}
