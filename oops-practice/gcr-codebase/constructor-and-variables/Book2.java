class Book2{
    public String isbn;
    protected String title;
    private String author;

    Book2(String isbn,String title,String author){
        this.isbn=isbn;
        this.title=title;
        this.author=author;
    }

    public String getAuthor(){
        return author;
    }

    public void setAuthor(String author){
        this.author=author;
    }
}

class EBook extends Book2{
    EBook(String isbn,String title,String author){
        super(isbn,title,author);
    }

    void displayDetails(){
        System.out.println(isbn+" "+title);
    }

    public static void main(String[] args){
        EBook b1=new EBook("ISBN123","Java Basics","Xander");
        b1.displayDetails();
        b1.setAuthor("David");
        System.out.println(b1.getAuthor());
    }
}
