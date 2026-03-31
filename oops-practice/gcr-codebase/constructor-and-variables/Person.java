class Person{
    String name;
    int age;

    Person(String name,int age){
        this.name=name;
        this.age=age;
    }

    Person(Person p){
        this.name=p.name;
        this.age=p.age;
    }

    public static void main(String[] args){
        Person p1=new Person("Amit",25);
        Person p2=new Person(p1);
        System.out.println("Name: " + p1.name + ", Age: " + p1.age);
        System.out.println("Name: " + p2.name + ", Age: " + p2.age);
    }
}
