import java.util.*;
class InvalidPhoneNumberException extends Exception{
    InvalidPhoneNumberException(String m){super(m);}
}
class Contact{
    private String name;
    private String phone;
    Contact(String name,String phone){this.name=name;this.phone=phone;}
    public String getPhone(){return phone;}
    public String getName(){return name;}
}
class ContactManager{
    private List<Contact> contacts=new ArrayList<>();
    public void addContact(String name,String phone)throws InvalidPhoneNumberException{
        if(!phone.matches("\\d{10}"))throw new InvalidPhoneNumberException("Invalid phone");
        for(Contact c:contacts)if(c.getPhone().equals(phone))return;
        contacts.add(new Contact(name,phone));
    }
    public void deleteContact(String phone){
        contacts.removeIf(c->c.getPhone().equals(phone));
    }
    public Contact searchContact(String phone){
        for(Contact c:contacts)if(c.getPhone().equals(phone))return c;
        return null;
    }
}
public class ContactApp{
    public static void main(String[] args)throws Exception{
        Scanner sc=new Scanner(System.in);
        ContactManager cm=new ContactManager();
        int n=sc.nextInt();
        while(n-->0){
            String name=sc.next();
            String phone=sc.next();
            cm.addContact(name,phone);
        }
        String search=sc.next();
        Contact c=cm.searchContact(search);
        if(c!=null)System.out.println(c.getName());
        else System.out.println("Not Found");
    }
}
