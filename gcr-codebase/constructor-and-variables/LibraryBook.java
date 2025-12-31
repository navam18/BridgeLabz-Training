class Book{
    String title;
    String author;
    double price;
    boolean availability;

    Book(String title,String author,double price,boolean availability){
        this.title=title;
        this.author=author;
        this.price=price;
        this.availability=availability;
    }

    void borrowBook(){
        if(availability){
            availability=false;
        }
    }

    public static void main(String[] args){
        Book b1=new Book("Java Basics","Herbert Schildt",450.0,true);
        b1.borrowBook();
        System.out.println("Is the book available? " + b1.availability);
    }
}
