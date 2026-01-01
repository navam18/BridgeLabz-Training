
public class BookManagementSystem {

    // Static variable
    static String libraryName = "Egmore Library";

    // Instance variables
    String title;
    String author;
    final String isbn;   // final variable

    // Constructor using this
    BookManagementSystem(String title, String author, String isbn) {
        this.title = title;
        this.author = author;
        this.isbn = isbn;
    }

    // Static method
    static void displayLibraryName() {
        System.out.println("Library Name: " + libraryName);
    }

    // Method to display details
    void displayDetails(Object obj) {
        if (obj instanceof BookManagementSystem) {
            System.out.println("Title: " + title);
            System.out.println("Author: " + author);
            System.out.println("ISBN: " + isbn);
        }
    }

    public static void main(String[] args) {
        BookManagementSystem b1 = new BookManagementSystem("Effective Java", "Joshua Bloch", "978-0134685991");

        BookManagementSystem.displayLibraryName();
        b1.displayDetails(b1);
    }
}

