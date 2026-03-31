import java.util.*;

class Product{
    int id;
    String name;
    double price;

    Product(int id,String name,double price){
        this.id=id;
        this.name=name;
        this.price=price;
    }

    public String toString(){
        return id+" "+name+" Rs."+price;
    }
}

class Order{
    int orderId;
    Product product;
    String status;

    Order(int orderId,Product product){
        this.orderId=orderId;
        this.product=product;
        status="Placed";
    }

    public String toString(){
        return orderId+" "+product.name+" "+product.price+" "+status;
    }
}

public class Ecommerce{
    static Scanner sc=new Scanner(System.in);
    static ArrayList<Product> products=new ArrayList<>();
    static ArrayList<Order> orders=new ArrayList<>();
    static int oid=101;

    public static void main(String[] args){
        products.add(new Product(1,"Laptop",50000));
        products.add(new Product(2,"Mobile",20000));
        products.add(new Product(3,"Mouse",500));

        while(true){
            System.out.println("\n1.View 2.Buy 3.Cancel 4.Track 5.Exit");
            int ch=sc.nextInt();

            if(ch==1){
                for(Product p:products){
                    System.out.println(p);
                }
            }
            else if(ch==2){
                int id=sc.nextInt();
                Product sel=null;
                for(Product p:products){
                    if(p.id==id){
                        sel=p;
                    }
                }
                if(sel!=null){
                    Order o=new Order(oid++,sel);
                    orders.add(o);
                    System.out.println("Order Placed "+o);
                }
                else{
                    System.out.println("Invalid Product");
                }
            }
            else if(ch==3){
                int id=sc.nextInt();
                for(Order o:orders){
                    if(o.orderId==id){
                        o.status="Cancelled";
                        System.out.println("Cancelled");
                    }
                }
            }
            else if(ch==4){
                for(Order o:orders){
                    System.out.println(o);
                }
            }
            else if(ch==5){
                break;
            }
        }
    }
}
