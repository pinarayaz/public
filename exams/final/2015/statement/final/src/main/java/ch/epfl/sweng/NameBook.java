package ch.epfl.sweng;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public final class NameBook {
    private final Graph<String> graph;

    /**
     * Creates a new NameBook from the given list of friends.
     * 
     * Friendships are unidirectional, i.e. if Alice has Bob as a friend, Bob
     * may not have Alice as a friend.
     */
    public NameBook(List<String[]> friends) {
        graph = new Graph<>();

        for (String[] words : friends) {
            GraphNode<String> n1 = graph.getNode(words[0]);
            GraphNode<String> n2 = graph.getNode(words[1]);
            n1.addSuccessor(n2);
        }
    }

    /** Finds the person with the given name. */
    public GraphNode<String> findPerson(String name) {
        return graph.getNode(name);
    }

    /** Finds all friends of the given person, at the given distance or less. */
    public List<GraphNode<String>> findFriends(String name, int distance) {
        GraphNode<String> personNode = graph.getNode(name);
        if (distance == 0 || personNode == null) {
            return Collections.emptyList();
        }

        List<GraphNode<String>> friends = new ArrayList<>();

        for (GraphEdge<String> edge : personNode.getForwardEdges()) {
            final GraphNode<String> friend = edge.getDestination();
            if (!friends.contains(friend)) {
                friends.add(friend);
                friends.addAll(findFriends(friend.getData(), distance - 1));
            }
        }

        return friends;
    }

    /**
     * Prints all friendships. 
     * Names are printed in alphabetical order, both at the top level and when listing friends.
     * The format is the following:
     * <code>
     * Alice
     * - Bob
     * - Ted
     * - Carol
     * Bob
     * - Ted
     * Ted
     * - Carol
     * </code>
     * (where Alice is friends with Bob and Carol, Bob is friends with Ted, and Carol and Ted are friendless)
     */
    public String printFriendships() {
        List<String> peopleNames = new ArrayList<>();

        for (GraphNode<String> node : graph.getAllNodes()) {
            peopleNames.add(node.getData());
        }

        Collections.sort(peopleNames, new NaturalOrderFriendsComparator());

        StringBuilder builder = new StringBuilder();

        for (String name : peopleNames) {
            builder.append(printPerson(findPerson(name)));
        }

        return builder.toString().trim();
    }

    /** Prints the given person and their friends to the given stream. */
    private String printPerson(GraphNode<String> person) {
        if(person.getForwardEdges().isEmpty()){
            return "";
        }

        List<String> friendNames = new ArrayList<>();

        for (GraphEdge<String> edge : person.getForwardEdges()) {
            friendNames.add(edge.getDestination().getData());
        }

        Collections.sort(friendNames, new NaturalOrderFriendsComparator());

        StringBuilder builder = new StringBuilder();
        builder.append(person.getData()).append(System.lineSeparator());

        for (String name : friendNames) {
            builder.append("- ").append(name).append("\n");
        }

        return builder.toString();
    }

    /** Simple comparator for strings, using natural order. */
    private static final class NaturalOrderFriendsComparator implements Comparator<String> {
        @Override
        public int compare(String left, String right) {
            return left.compareTo(right);
        }
    }
}
