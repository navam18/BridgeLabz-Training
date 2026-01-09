package linkedList;

class BookNode {
    String title;
    String author;
    String genre;
    int bookId;
    boolean available;

    BookNode next;
    BookNode prev;

    BookNode(int bookId, String title, String author, String genre, boolean available) {
        this.bookId = bookId;
        this.title = title;
        this.author = author;
        this.genre = genre;
        this.available = available;
    }
}

class LibraryDoublyLinkedList {

    private BookNode head;
    private BookNode tail;

    public void addAtBeginning(int id, String title, String author, String genre, boolean available) {
        BookNode node = new BookNode(id, title, author, genre, available);

        if (head == null) {
            head = tail = node;
            return;
        }

        node.next = head;
        head.prev = node;
        head = node;
    }

    public void addAtEnd(int id, String title, String author, String genre, boolean available) {
        BookNode node = new BookNode(id, title, author, genre, available);

        if (tail == null) {
            head = tail = node;
            return;
        }

        tail.next = node;
        node.prev = tail;
        tail = node;
    }

    public void addAtPosition(int pos, int id, String title, String author, String genre, boolean available) {
        if (pos == 1 || head == null) {
            addAtBeginning(id, title, author, genre, available);
            return;
        }

        BookNode temp = head;
        for (int i = 1; i < pos - 1 && temp.next != null; i++)
            temp = temp.next;

        if (temp.next == null) {
            addAtEnd(id, title, author, genre, available);
            return;
        }

        BookNode node = new BookNode(id, title, author, genre, available);
        node.next = temp.next;
        node.prev = temp;
        temp.next.prev = node;
        temp.next = node;
    }

    public void removeById(int id) {
        if (head == null) return;

        BookNode temp = head;

        while (temp != null && temp.bookId != id)
            temp = temp.next;

        if (temp == null) return;

        if (temp == head) head = temp.next;
        if (temp == tail) tail = temp.prev;

        if (temp.prev != null) temp.prev.next = temp.next;
        if (temp.next != null) temp.next.prev = temp.prev;
    }

    public void updateAvailability(int id, boolean status) {
        BookNode book = searchById(id);
        if (book != null)
            book.available = status;
    }

    private BookNode searchById(int id) {
        BookNode temp = head;
        while (temp != null) {
            if (temp.bookId == id) return temp;
            temp = temp.next;
        }
        return null;
    }

    public void searchByTitle(String title) {
        BookNode temp = head;
        while (temp != null) {
            if (temp.title.equalsIgnoreCase(title))
                print(temp);
            temp = temp.next;
        }
    }

    public void searchByAuthor(String author) {
        BookNode temp = head;
        while (temp != null) {
            if (temp.author.equalsIgnoreCase(author))
                print(temp);
            temp = temp.next;
        }
    }

    public void displayForward() {
        BookNode temp = head;
        while (temp != null) {
            print(temp);
            temp = temp.next;
        }
    }

    public void displayReverse() {
        BookNode temp = tail;
        while (temp != null) {
            print(temp);
            temp = temp.prev;
        }
    }

    public int countBooks() {
        int count = 0;
        BookNode temp = head;
        while (temp != null) {
            count++;
            temp = temp.next;
        }
        return count;
    }

    private void print(BookNode b) {
        System.out.println(
                b.bookId + " | " + b.title + " | " + b.author + " | " +
                        b.genre + " | " + (b.available ? "Available" : "Issued")
        );
    }
}

public class LibraryManagementApp {

    public static void main(String[] args) {

        LibraryDoublyLinkedList library = new LibraryDoublyLinkedList();

        library.addAtEnd(101, "Clean Code", "Robert Martin", "Programming", true);
        library.addAtEnd(102, "Effective Java", "Joshua Bloch", "Programming", true);
        library.addAtBeginning(103, "Atomic Habits", "James Clear", "Self-Help", true);
        library.addAtPosition(2, 104, "Deep Work", "Cal Newport", "Productivity", false);

        System.out.println("Library (Forward):");
        library.displayForward();

        System.out.println("\nLibrary (Reverse):");
        library.displayReverse();

        System.out.println("\nTotal Books: " + library.countBooks());

        library.updateAvailability(104, true);
        library.removeById(102);

        System.out.println("\nAfter Updates:");
        library.displayForward();
    }
}
