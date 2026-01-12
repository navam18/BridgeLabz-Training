import java.util.*;
class DuplicateVoteException extends Exception {
    public DuplicateVoteException(String msg) {
        super(msg);
    }
}
class Voter {
    int voterId;
    String name;
    boolean hasVoted = false;

    Voter(int id, String name) {
        this.voterId = id;
        this.name = name;
    }
}

class Candidate {
    int candidateId;
    String name;
    int votes = 0;

    Candidate(int id, String name) {
        this.candidateId = id;
        this.name = name;
    }
}

class Vote {
    Voter voter;
    Candidate candidate;

    Vote(Voter v, Candidate c) {
        voter = v;
        candidate = c;
    }
}

abstract class ElectionService {
    abstract void castVote(Voter voter, Candidate candidate)
            throws DuplicateVoteException;
    abstract void declareResult();
}

class ElectionSystem extends ElectionService {
    List<Voter> voters = new ArrayList<>();
    List<Candidate> candidates = new ArrayList<>();

    // CREATE
    void registerVoter(Voter v) {
        voters.add(v);
    }

    void addCandidate(Candidate c) {
        candidates.add(c);
    }

    // UPDATE / ACTION
    @Override
    void castVote(Voter voter, Candidate candidate)
            throws DuplicateVoteException {
        if (voter.hasVoted)
            throw new DuplicateVoteException("Voter has already voted!");

        voter.hasVoted = true;
        candidate.votes++;
        System.out.println("Vote cast successfully by " + voter.name);
    }

    // READ
    @Override
    void declareResult() {
        System.out.println("Election Results:");
        for (Candidate c : candidates) {
            System.out.println(c.name + " -> " + c.votes + " votes");
        }
    }
}

// ================= Main Driver =================
public class OnlineVotingSystem {
    public static void main(String[] args) {

        ElectionSystem system = new ElectionSystem();

        Voter v1 = new Voter(1, "Amit");
        Candidate c1 = new Candidate(101, "Alice");
        Candidate c2 = new Candidate(102, "Bob");

        system.registerVoter(v1);
        system.addCandidate(c1);
        system.addCandidate(c2);

        try {
            system.castVote(v1, c1);
            system.castVote(v1, c2); // duplicate vote
        } catch (DuplicateVoteException e) {
            System.out.println(e.getMessage());
        }

        system.declareResult();
    }
}
