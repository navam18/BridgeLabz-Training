import java.util.*;
import java.util.stream.*;

class Book {

    String genre;
    int pages;

    Book(String genre, int pages) {
        this.genre = genre;
        this.pages = pages;
    }

    String getGenre() {
        return genre;
    }

    int getPages() {
        return pages;
    }
}

public class LibraryBook {

    public static void main(String args[]) {

        List<Book> list = Arrays.asList(
                new Book("Fiction", 300),
                new Book("Fiction", 250),
                new Book("Science", 400),
                new Book("Science", 350),
                new Book("History", 500)
        );

        Map<String, IntSummaryStatistics> stats =
                list.stream()
                    .collect(Collectors.groupingBy(
                            Book::getGenre,
                            Collectors.summarizingInt(Book::getPages)
                    ));

        stats.forEach((k, v) -> {
            System.out.println("Genre: " + k);
            System.out.println("Total Pages: " + v.getSum());
            System.out.println("Average Pages: " + v.getAverage());
            System.out.println("Maximum Pages: " + v.getMax());
            System.out.println();
        });
    }
}
