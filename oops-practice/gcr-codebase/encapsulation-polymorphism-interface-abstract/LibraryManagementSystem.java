import java.util.ArrayList;

abstract class LibraryItem{
    private int itemId;
    private String title;
    private String author;
    private boolean available=true;
    private String borrowerName;
    public LibraryItem(int itemId,String title,String author){
        this.itemId=itemId;
        this.title=title;
        this.author=author;
    }
    public int getItemId(){
        return itemId;
    }
    public void setItemId(int itemId){
        this.itemId=itemId;
    }
    public String getTitle(){
        return title;
    }
    public void setTitle(String title){
        this.title=title;
    }
    public String getAuthor(){
        return author;
    }
    public void setAuthor(String author){
        this.author=author;
    }
    protected void setBorrowerName(String borrowerName){
        this.borrowerName=borrowerName;
        this.available=false;
    }
    protected void clearBorrower(){
        this.borrowerName=null;
        this.available=true;
    }
    public boolean isAvailable(){
        return available;
    }
    public abstract int getLoanDuration();
    public void getItemDetails(){
        System.out.println("Id:"+itemId+" Title:"+title+" Author:"+author+" Available:"+available+" LoanDays:"+getLoanDuration());
    }
}

interface Reservable{
    void reserveItem(String borrowerName);
    boolean checkAvailability();
}

class Book extends LibraryItem implements Reservable{
    public Book(int itemId,String title,String author){
        super(itemId,title,author);
    }
    public int getLoanDuration(){
        return 14;
    }
    public void reserveItem(String borrowerName){
        if(isAvailable()){
            setBorrowerName(borrowerName);
        }
    }
    public boolean checkAvailability(){
        return isAvailable();
    }
}

class Magazine extends LibraryItem implements Reservable{
    public Magazine(int itemId,String title,String author){
        super(itemId,title,author);
    }
    public int getLoanDuration(){
        return 7;
    }
    public void reserveItem(String borrowerName){
        if(isAvailable()){
            setBorrowerName(borrowerName);
        }
    }
    public boolean checkAvailability(){
        return isAvailable();
    }
}

class DVD extends LibraryItem implements Reservable{
    public DVD(int itemId,String title,String author){
        super(itemId,title,author);
    }
    public int getLoanDuration(){
        return 3;
    }
    public void reserveItem(String borrowerName){
        if(isAvailable()){
            setBorrowerName(borrowerName);
        }
    }
    public boolean checkAvailability(){
        return isAvailable();
    }
}

public class LibraryManagementSystem{
    public static void main(String[] args){
        ArrayList<LibraryItem> items=new ArrayList<>();
        items.add(new Book(1,"Java Programming","Herbert Schildt"));
        items.add(new Magazine(2,"Tech Today","Editorial Board"));
        items.add(new DVD(3,"Inception","Christopher Nolan"));
        ((Reservable)items.get(0)).reserveItem("Amit");
        for(LibraryItem item:items){
            item.getItemDetails();
        }
    }
}
