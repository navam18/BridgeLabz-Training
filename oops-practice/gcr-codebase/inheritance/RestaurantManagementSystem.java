interface Worker{
    void performDuties();
}
class Person{
    String name;
    int id;
    Person(String name,int id){
        this.name=name;
        this.id=id;
    }
    void display(){
        System.out.println(name+" "+id);
    }
}
class Chef extends Person implements Worker{
    Chef(String name,int id){
        super(name,id);
    }
    public void performDuties(){
        System.out.println("Preparing food");
    }
}
class Waiter extends Person implements Worker{
    Waiter(String name,int id){
        super(name,id);
    }
    public void performDuties(){
        System.out.println("Serving customers");
    }
}
class RestaurantManagementSystem{
    public static void main(String args[]){
        Chef chef=new Chef("Amit",101);
        Waiter waiter=new Waiter("Rahul",102);
        chef.display();
        chef.performDuties();
        waiter.display();
        waiter.performDuties();
    }
}
