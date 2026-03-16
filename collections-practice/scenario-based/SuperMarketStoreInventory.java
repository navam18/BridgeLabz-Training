import java.util.*;

abstract class Product
{
    String name;
    double price;
    int quantity;

    Product(String name,double price,int quantity)
    {
        this.name=name;
        this.price=price;
        this.quantity=quantity;
    }

    abstract void display();

    double totalValue()
    {
        return price*quantity;
    }
}

class Electronics extends Product
{
    int warranty;

    Electronics(String name,double price,int quantity,int warranty)
    {
        super(name,price,quantity);
        this.warranty=warranty;
    }

    void display()
    {
        System.out.println(name+" - Price: "+price+", Quantity: "+quantity+", Warranty: "+warranty+" months");
    }
}

class Clothing extends Product
{
    String size;

    Clothing(String name,double price,int quantity,String size)
    {
        super(name,price,quantity);
        this.size=size;
    }

    void display()
    {
        System.out.println(name+" - Price: "+price+", Quantity: "+quantity+", Size: "+size);
    }
}

class SupermarketStoreInventory
{
    public static void main(String[] args)
    {
        Scanner sc=new Scanner(System.in);

        int n=Integer.parseInt(sc.nextLine());

        List<Product> list=new ArrayList<>();

        for(int i=0;i<n;i++)
        {
            String line=sc.nextLine();

            if(line.trim().length()==0)
            {
                i--;
                continue;
            }

            String[] p=line.split(",\\s*");

            if(p[0].equals("Electronics"))
            {
                String name=p[1];
                double price=Double.parseDouble(p[2]);
                int quantity=Integer.parseInt(p[3]);
                int warranty=Integer.parseInt(p[4]);

                Electronics e=new Electronics(name,price,quantity,warranty);
                list.add(e);

                System.out.println("Product added to inventory: "+name);
            }
            else if(p[0].equals("Clothing"))
            {
                String name=p[1];
                double price=Double.parseDouble(p[2]);
                int quantity=Integer.parseInt(p[3]);
                String size=p[4];

                Clothing c=new Clothing(name,price,quantity,size);
                list.add(c);

                System.out.println("Product added to inventory: "+name);
            }
        }

        System.out.println("Inventory:");

        double total=0;

        for(Product p:list)
        {
            p.display();
            total+=p.totalValue();
        }

        System.out.printf("Total value of the inventory: %.2f\n",total);
    }
}