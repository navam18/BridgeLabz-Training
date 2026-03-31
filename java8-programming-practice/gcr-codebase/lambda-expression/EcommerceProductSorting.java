import java.util.*;

class Product{
    int price;
    double rating;
    int discount;
    Product(int p,double r,int d){
        price=p;
        rating=r;
        discount=d;
    }
    public String toString(){
        return price+" "+rating+" "+discount;
    }
}

public class EcommerceProductSorting{
    public static void main(String[] args){
        List<Product> list=new ArrayList<>();
        list.add(new Product(500,4.5,10));
        list.add(new Product(300,4.2,20));
        list.add(new Product(800,4.8,5));

        list.sort((a,b)->a.price-b.price);
        list.sort((a,b)->Double.compare(b.rating,a.rating));
        list.sort((a,b)->b.discount-a.discount);

        list.forEach(System.out::println);
    }
}
