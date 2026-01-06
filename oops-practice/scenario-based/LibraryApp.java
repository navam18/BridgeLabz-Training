import java.util.*;
class BookNotAvailableException extends Exception{
    BookNotAvailableException(String m){super(m);}
}
class Book{
    String title,author;
    boolean available;
    Book(String t,String a,boolean av){title=t;author=a;available=av;}
}
class Library{
    private List<Book> books=new ArrayList<>();
    public void addBook(Book b){books.add(b);}
    public List<Book> search(String key){
        List<Book> res=new ArrayList<>();
        for(Book b:books)if(b.title.toLowerCase().contains(key.toLowerCase()))res.add(b);
        return res;
    }
    public void checkout(String title)throws BookNotAvailableException{
        for(Book b:books){
            if(b.title.equalsIgnoreCase(title)){
                if(!b.available)throw new BookNotAvailableException("Not available");
                b.available=false;
                return;
            }
        }
    }
}
public class LibraryApp{
    public static void main(String[] args)throws Exception{
        Scanner sc=new Scanner(System.in);
        Library lib=new Library();
        int n=sc.nextInt();
        for(int i=0;i<n;i++){
            String title=sc.next();
            String author=sc.next();
            boolean available=sc.nextBoolean();
            lib.addBook(new Book(title,author,available));
        }
        String search=sc.next();
        System.out.println(lib.search(search).size());
        String checkout=sc.next();
        lib.checkout(checkout);
    }
}
