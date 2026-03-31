import java.util.*;

class VotingSystem {

    Map<String, Integer> votes = new HashMap<>();
    Map<String, Integer> voteOrder = new LinkedHashMap<>();

    public void castVote(String candidate) {
        votes.put(candidate, votes.getOrDefault(candidate, 0) + 1);
        voteOrder.put(candidate, votes.get(candidate));
    }

    public void displaySortedResults() {
        TreeMap<String, Integer> sorted = new TreeMap<>(votes);
        System.out.println("Sorted Results: " + sorted);
    }
}
public class VotingApp {

    public static void main(String[] args) {

        VotingSystem voting = new VotingSystem();

        voting.castVote("Alice");
        voting.castVote("Bob");
        voting.castVote("Alice");
        voting.castVote("Charlie");

        System.out.println("Vote Order:");
        System.out.println(voting.voteOrder);

        voting.displaySortedResults();
    }
}
