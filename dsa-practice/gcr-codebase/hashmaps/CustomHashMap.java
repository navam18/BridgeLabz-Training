public class CustomHashMap {
    public static void main(String[] args) {
        MyHashMap map = new MyHashMap();
        map.put(1, 10);
        map.put(2, 20);
        map.put(12, 30);   // collision example (12 % 10 == 2)
        System.out.println(map.get(1));   // 10
        System.out.println(map.get(2));   // 20
        System.out.println(map.get(12));  // 30
        map.remove(2);
        System.out.println(map.get(2));   // -1
    }
    // Custom HashMap class
    static class MyHashMap {
        // Node for linked list
        class Node {
            int key, value;
            Node next;
            Node(int k, int v) {
                key = k;
                value = v;
            }
        }
        // Array of linked lists
        private Node[] table = new Node[10];
        // Hash function
        private int hash(int key) {
            return key % table.length;
        }
        // Insert or update
        void put(int key, int value) {
            int index = hash(key);
            Node head = table[index];
            // update value if key exists
            while (head != null) {
                if (head.key == key) {
                    head.value = value;
                    return;
                }
                head = head.next;
            }
            // insert new node at beginning
            Node node = new Node(key, value);
            node.next = table[index];
            table[index] = node;
        }
        // Retrieve value
        int get(int key) {
            int index = hash(key);
            Node head = table[index];
            while (head != null) {
                if (head.key == key)
                    return head.value;
                head = head.next;
            }
            return -1;
        }
        // Delete key
        void remove(int key) {
            int index = hash(key);
            Node curr = table[index];
            Node prev = null;
            while (curr != null) {
                if (curr.key == key) {
                    if (prev == null)
                        table[index] = curr.next;
                    else
                        prev.next = curr.next;
                    return;
                }
                prev = curr;
                curr = curr.next;
            }
        }
    }
}