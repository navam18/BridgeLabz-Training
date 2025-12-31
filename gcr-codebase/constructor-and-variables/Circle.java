class Circle{
    double radius;

    Circle(){
        this(5.0);
    }

    Circle(double radius){
        this.radius=radius;
    }

    public static void main(String[] args){
        Circle c1=new Circle();
        Circle c2=new Circle(10.5);
        System.out.println("Radius of c1: " + c1.radius);
        System.out.println("Radius of c2: " + c2.radius);
    }
}
