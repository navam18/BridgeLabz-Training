class Book {
    String title;
    int publicationYear;

    void displayInfo() {
        System.out.println(title + " - " + publicationYear);
    }
}

class Author extends Book {
    String authorName;
    String bio;
}

public class BookTest {
    public static void main(String[] args) {
        Author bookAuthor = new Author();
        bookAuthor.title = "Java Basics";
        bookAuthor.publicationYear = 2023;
        bookAuthor.authorName = "James";
        bookAuthor.bio = "Java Expert";

        bookAuthor.displayInfo();
        System.out.println("Author: " + bookAuthor.authorName);
    }
}
