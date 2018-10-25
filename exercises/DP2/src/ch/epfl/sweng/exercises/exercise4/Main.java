package ch.epfl.sweng.exercises.exercise4;

import java.util.LinkedList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        int coinsForKill = 1023;
        System.out.println("You have killed the Monster and gained " + coinsForKill + " coins!");

        Player andy = new Player("Andy");
        Player jane = new Player("Jane");
        Player eve = new Player("Eve");
        Player ann = new Player("Ann");
        Player edith = new Player("Edith");

        PlayersGroup developers = new PlayersGroup("Developers");
        developers.add(andy);
        developers.add(jane);
        developers.add(eve);

        List<Player> individuals = new LinkedList<>();
        individuals.add(ann);
        individuals.add(edith);

        List<PlayersGroup> groups = new LinkedList<>();
        groups.add(developers);

        int totalToSplitBy = individuals.size() + groups.size();
        int amountForEach = coinsForKill / totalToSplitBy;
        int leftOver = coinsForKill % totalToSplitBy;

        for (Player ind: individuals) {
            ind.setCollectedCoins(ind.getCollectedCoins() + amountForEach + leftOver);
            leftOver = 0;
            ind.getStatistics();
            System.out.println();
        }

        for (PlayersGroup gr: groups) {
            int amountForEachGroupMember = amountForEach / gr.getNumberOfPlayers();
            leftOver = amountForEachGroupMember % gr.getNumberOfPlayers();
            for (Player ind: gr.getMembers())
            {
                ind.setCollectedCoins(ind.getCollectedCoins() + amountForEachGroupMember + leftOver);
                leftOver = 0;
                ind.getStatistics();
                System.out.println();
            }
        }
    }
}
