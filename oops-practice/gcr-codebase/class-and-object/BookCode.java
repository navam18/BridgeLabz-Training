class BookCode {
    String title;
    String author;
    double price;

    void display() {
        System.out.println("Title of the book: " + title);
        System.out.println("Author of the book: " + author);
        System.out.println("Price of the book: " + price);
        System.out.println("------------------------------");
    }

    public static void main(String[] args) {
        BookCode b1 = new BookCode();
        b1.title = "2States";
        b1.author = "Chetan Bhagat";
        b1.price = 500.0;

        BookCode b2 = new BookCode();
        b2.title = "Wings Of Fire";
        b2.author = "Abdul kalam.A.P.J";
        b2.price = 500.0;

        b1.display();
        b2.display();
    }
}
