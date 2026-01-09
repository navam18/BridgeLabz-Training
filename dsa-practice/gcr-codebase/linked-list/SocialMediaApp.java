package linkedList;

class FriendNode {
    int friendId;
    FriendNode next;

    FriendNode(int friendId) {
        this.friendId = friendId;
    }
}

class UserNode {
    int userId;
    String name;
    int age;
    FriendNode friends;
    UserNode next;

    UserNode(int userId, String name, int age) {
        this.userId = userId;
        this.name = name;
        this.age = age;
    }
}

class SocialMediaNetwork {

    private UserNode head;

    public void addUser(int id, String name, int age) {
        UserNode node = new UserNode(id, name, age);
        node.next = head;
        head = node;
    }

    private UserNode getUserById(int id) {
        UserNode temp = head;
        while (temp != null) {
            if (temp.userId == id) return temp;
            temp = temp.next;
        }
        return null;
    }

    public void searchUserByName(String name) {
        UserNode temp = head;
        while (temp != null) {
            if (temp.name.equalsIgnoreCase(name))
                printUser(temp);
            temp = temp.next;
        }
    }

    public void addFriendConnection(int id1, int id2) {
        UserNode u1 = getUserById(id1);
        UserNode u2 = getUserById(id2);

        if (u1 == null || u2 == null) return;

        u1.friends = addFriend(u1.friends, id2);
        u2.friends = addFriend(u2.friends, id1);
    }

    private FriendNode addFriend(FriendNode head, int id) {
        FriendNode node = new FriendNode(id);
        node.next = head;
        return node;
    }

    public void removeFriendConnection(int id1, int id2) {
        UserNode u1 = getUserById(id1);
        UserNode u2 = getUserById(id2);

        if (u1 == null || u2 == null) return;

        u1.friends = removeFriend(u1.friends, id2);
        u2.friends = removeFriend(u2.friends, id1);
    }

    private FriendNode removeFriend(FriendNode head, int id) {
        if (head == null) return null;
        if (head.friendId == id) return head.next;

        FriendNode temp = head;
        while (temp.next != null && temp.next.friendId != id)
            temp = temp.next;

        if (temp.next != null)
            temp.next = temp.next.next;

        return head;
    }

    public void displayFriends(int userId) {
        UserNode user = getUserById(userId);
        if (user == null) return;

        System.out.print("Friends of " + user.name + ": ");
        FriendNode temp = user.friends;
        while (temp != null) {
            System.out.print(temp.friendId + " ");
            temp = temp.next;
        }
        System.out.println();
    }

    public void mutualFriends(int id1, int id2) {
        UserNode u1 = getUserById(id1);
        UserNode u2 = getUserById(id2);

        if (u1 == null || u2 == null) return;

        System.out.print("Mutual Friends: ");
        FriendNode f1 = u1.friends;

        while (f1 != null) {
            if (exists(u2.friends, f1.friendId))
                System.out.print(f1.friendId + " ");
            f1 = f1.next;
        }
        System.out.println();
    }

    private boolean exists(FriendNode head, int id) {
        while (head != null) {
            if (head.friendId == id) return true;
            head = head.next;
        }
        return false;
    }

    public void countFriends() {
        UserNode temp = head;
        while (temp != null) {
            int count = 0;
            FriendNode f = temp.friends;
            while (f != null) {
                count++;
                f = f.next;
            }
            System.out.println(temp.name + " has " + count + " friends");
            temp = temp.next;
        }
    }

    private void printUser(UserNode u) {
        System.out.println(u.userId + " | " + u.name + " | " + u.age);
    }
}

public class SocialMediaApp {
    public static void main(String[] args) {

        SocialMediaNetwork sm = new SocialMediaNetwork();

        sm.addUser(1, "Kapil", 21);
        sm.addUser(2, "Aman", 22);
        sm.addUser(3, "Rahul", 23);
        sm.addUser(4, "Neha", 21);

        sm.addFriendConnection(1, 2);
        sm.addFriendConnection(1, 3);
        sm.addFriendConnection(2, 3);
        sm.addFriendConnection(2, 4);

        sm.displayFriends(2);

        sm.mutualFriends(1, 2);

        sm.countFriends();

        sm.removeFriendConnection(1, 3);

        System.out.println("\nAfter Removal:");
        sm.displayFriends(1);
    }
}
