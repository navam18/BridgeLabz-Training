package interfaces;

import java.util.*;

class ReverseQueue {
    static void reverse(Queue<Integer> q) {
        if(q.isEmpty()) return;
        int x = q.remove();
        reverse(q);
        q.add(x);
    }
}
