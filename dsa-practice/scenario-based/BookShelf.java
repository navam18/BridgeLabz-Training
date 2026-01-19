import java.util.*;

class Book{
    String name;
    String author;
    Book(String name,String author){
        this.name=name;
        this.author=author;
    }
    public String toString(){
        return name+" by "+author;
    }
}

class Library{
    Map<String,LinkedList<Book>> catalog=new HashMap<>();
    Map<String,HashSet<String>> duplicateCheck=new HashMap<>();

    void addBook(String genre,String name,String author){
        catalog.putIfAbsent(genre,new LinkedList<>());
        duplicateCheck.putIfAbsent(genre,new HashSet<>());

        if(duplicateCheck.get(genre).contains(name)){
            System.out.println("Duplicate book not allowed");
            return;
        }
        catalog.get(genre).add(new Book(name,author));
        duplicateCheck.get(genre).add(name);
        System.out.println("Book added");
    }

    void removeBook(String genre,String name){
        if(!catalog.containsKey(genre)){
            System.out.println("Genre not found");
            return;
        }
        Iterator<Book> it=catalog.get(genre).iterator();
        while(it.hasNext()){
            if(it.next().name.equals(name)){
                it.remove();
                duplicateCheck.get(genre).remove(name);
                System.out.println("Book removed");
                return;
            }
        }
        System.out.println("Book not found");
    }

    void display(){
        for(String genre:catalog.keySet()){
            System.out.println("Genre: "+genre);
            for(Book b:catalog.get(genre)){
                System.out.println("  "+b);
            }
        }
    }
}

public class BookShelf{
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        Library lib=new Library();
        while(true){
            System.out.println("1.Add Book 2.Remove Book 3.Display 4.Exit");
            int ch=sc.nextInt();
            if(ch==1){
                System.out.print("Genre: ");
                String g=sc.next();
                System.out.print("Book name: ");
                String n=sc.next();
                System.out.print("Author: ");
                String a=sc.next();
                lib.addBook(g,n,a);
            }
            else if(ch==2){
                System.out.print("Genre: ");
                String g=sc.next();
                System.out.print("Book name: ");
                lib.removeBook(g,sc.next());
            }
            else if(ch==3){
                lib.display();
            }
            else break;
        }
    }
}
