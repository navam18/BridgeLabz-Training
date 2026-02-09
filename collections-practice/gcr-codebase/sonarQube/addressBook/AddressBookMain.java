import java.util.*;
class Contact{
    String firstName;
    String lastName;
    String address;
    String city;
    String state;
    String email;
    long phone;
    int zip;
    public boolean equals(Object o){
        if(this==o)return true;
        if(!(o instanceof Contact))return false;
        Contact c=(Contact)o;
        return firstName.equalsIgnoreCase(c.firstName)&&lastName.equalsIgnoreCase(c.lastName);
    }
    public String toString(){
        return firstName+" "+lastName+" | "+city+" | "+state+" | "+phone;
    }
}
class AddressBook{
    List<Contact> list=new ArrayList<>();
    void addContact(Contact c){
        if(list.contains(c)){
            System.out.println("Duplicate contact not allowed");
        }else{
            list.add(c);
            System.out.println("Contact added");
        }
    }
    void editContact(String name,Scanner sc){
        for(Contact c:list){
            if(c.firstName.equalsIgnoreCase(name)){
                System.out.print("Enter new city: ");
                c.city=sc.next();
                System.out.print("Enter new state: ");
                c.state=sc.next();
                System.out.print("Enter new phone: ");
                c.phone=sc.nextLong();
                System.out.println("Contact updated");
                return;
            }
        }
        System.out.println("Contact not found");
    }
    void deleteContact(String name){
        Iterator<Contact> it=list.iterator();
        while(it.hasNext()){
            if(it.next().firstName.equalsIgnoreCase(name)){
                it.remove();
                System.out.println("Contact deleted");
                return;
            }
        }
        System.out.println("Contact not found");
    }
    void sortByName(){
        Collections.sort(list,(a,b)->a.firstName.compareToIgnoreCase(b.firstName));
    }
}
public class AddressBookMain{
    static Map<String,AddressBook> system=new HashMap<>();
    static Map<String,List<Contact>> cityMap=new HashMap<>();
    static Map<String,List<Contact>> stateMap=new HashMap<>();
    static void updateMaps(Contact c){
        cityMap.computeIfAbsent(c.city,k->new ArrayList<>()).add(c);
        stateMap.computeIfAbsent(c.state,k->new ArrayList<>()).add(c);
    }
    static Contact takeInput(Scanner sc){
        Contact c=new Contact();
        System.out.print("First name: ");
        c.firstName=sc.next();
        System.out.print("Last name: ");
        c.lastName=sc.next();
        System.out.print("Address: ");
        c.address=sc.next();
        System.out.print("City: ");
        c.city=sc.next();
        System.out.print("State: ");
        c.state=sc.next();
        System.out.print("Zip: ");
        c.zip=sc.nextInt();
        System.out.print("Phone: ");
        c.phone=sc.nextLong();
        System.out.print("Email: ");
        c.email=sc.next();
        return c;
    }
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        System.out.println("Welcome to Address Book Program");
        while(true){
            System.out.println("\n1.Create AddressBook 2.Select AddressBook 3.Search City 4.View by City 5.Count by City 6.Exit");
            int ch=sc.nextInt();
            if(ch==1){
                System.out.print("Enter address book name: ");
                String name=sc.next();
                system.put(name,new AddressBook());
                System.out.println("AddressBook created");
            }else if(ch==2){
                System.out.print("Enter address book name: ");
                String name=sc.next();
                AddressBook book=system.get(name);
                if(book==null){
                    System.out.println("Not found");
                    continue;
                }
                while(true){
                    System.out.println("\n1.Add 2.Edit 3.Delete 4.Sort 5.Show 6.Back");
                    int op=sc.nextInt();
                    if(op==1){
                        Contact c=takeInput(sc);
                        book.addContact(c);
                        updateMaps(c);
                    }else if(op==2){
                        System.out.print("Enter first name: ");
                        book.editContact(sc.next(),sc);
                    }else if(op==3){
                        System.out.print("Enter first name: ");
                        book.deleteContact(sc.next());
                    }else if(op==4){
                        book.sortByName();
                        System.out.println("Sorted");
                    }else if(op==5){
                        for(Contact c:book.list){
                            System.out.println(c);
                        }
                    }else{
                        break;
                    }
                }
            }else if(ch==3){
                System.out.print("Enter city: ");
                String city=sc.next();
                for(AddressBook b:system.values()){
                    for(Contact c:b.list){
                        if(c.city.equalsIgnoreCase(city)){
                            System.out.println(c);
                        }
                    }
                }
            }else if(ch==4){
                System.out.print("Enter city: ");
                String city=sc.next();
                List<Contact> res=cityMap.get(city);
                if(res!=null){
                    for(Contact c:res)System.out.println(c);
                }
            }else if(ch==5){
                System.out.print("Enter city: ");
                String city=sc.next();
                List<Contact> res=cityMap.get(city);
                if(res!=null)System.out.println("Count: "+res.size());
                else System.out.println("Count: 0");
            }else{
                break;
            }
        }
    }
}