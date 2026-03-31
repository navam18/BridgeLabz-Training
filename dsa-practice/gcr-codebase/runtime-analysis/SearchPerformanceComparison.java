import java.util.*;

public class SearchPerformanceComparison {

    public static void main(String[] args) {

        int N = 1_000_000;
        int target = N - 1;

        // ---------------- Array ----------------
        int[] array = new int[N];
        for (int i = 0; i < N; i++) {
            array[i] = i;
        }

        long startArray = System.nanoTime();
        boolean foundArray = false;
        for (int i = 0; i < N; i++) {
            if (array[i] == target) {
                foundArray = true;
                break;
            }
        }
        long endArray = System.nanoTime();
        System.out.println("Array Search Time: " + (endArray - startArray) + " ns");

        // ---------------- HashSet ----------------
        HashSet<Integer> hashSet = new HashSet<>();
        for (int i = 0; i < N; i++) {
            hashSet.add(i);
        }

        long startHashSet = System.nanoTime();
        boolean foundHashSet = hashSet.contains(target);
        long endHashSet = System.nanoTime();
        System.out.println("HashSet Search Time: " + (endHashSet - startHashSet) + " ns");

        // ---------------- TreeSet ----------------
        TreeSet<Integer> treeSet = new TreeSet<>();
        for (int i = 0; i < N; i++) {
            treeSet.add(i);
        }

        long startTreeSet = System.nanoTime();
        boolean foundTreeSet = treeSet.contains(target);
        long endTreeSet = System.nanoTime();
        System.out.println("TreeSet Search Time: " + (endTreeSet - startTreeSet) + " ns");
    }
}
