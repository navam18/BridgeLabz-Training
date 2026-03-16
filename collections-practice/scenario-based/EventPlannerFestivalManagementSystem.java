import java.util.*;

abstract class Festival
{
    String name;
    String location;
    String date;

    Festival(String name,String location,String date)
    {
        this.name=name;
        this.location=location;
        this.date=date;
    }

    abstract void display();
}

class MusicFestival extends Festival
{
    String headliner;
    String musicGenre;
    int ticketPrice;

    MusicFestival(String name,String location,String date,String headliner,String musicGenre,int ticketPrice)
    {
        super(name,location,date);
        this.headliner=headliner;
        this.musicGenre=musicGenre;
        this.ticketPrice=ticketPrice;
    }

    void display()
    {
        System.out.println("Festival Name: "+name);
        System.out.println("Location: "+location);
        System.out.println("Date: "+date);
        System.out.println("Headliner: "+headliner);
        System.out.println("Music Genre: "+musicGenre);
        System.out.println("Ticket Price: "+ticketPrice);
    }
}

class FoodFestival extends Festival
{
    String cuisine;
    int numStalls;
    int entryFee;

    FoodFestival(String name,String location,String date,String cuisine,int numStalls,int entryFee)
    {
        super(name,location,date);
        this.cuisine=cuisine;
        this.numStalls=numStalls;
        this.entryFee=entryFee;
    }

    void display()
    {
        System.out.println("Festival Name: "+name);
        System.out.println("Location: "+location);
        System.out.println("Date: "+date);
        System.out.println("Cuisine: "+cuisine);
        System.out.println("Number of Stalls: "+numStalls);
        System.out.println("Entry Fee: "+entryFee);
    }
}

class ArtFestival extends Festival
{
    String artType;
    int numArtists;
    int exhibitionFee;

    ArtFestival(String name,String location,String date,String artType,int numArtists,int exhibitionFee)
    {
        super(name,location,date);
        this.artType=artType;
        this.numArtists=numArtists;
        this.exhibitionFee=exhibitionFee;
    }

    void display()
    {
        System.out.println("Festival Name: "+name);
        System.out.println("Location: "+location);
        System.out.println("Date: "+date);
        System.out.println("Art Type: "+artType);
        System.out.println("Number of Artists: "+numArtists);
        System.out.println("Exhibition Fee: "+exhibitionFee);
    }
}

class EventPlannerFestivalManagementSystem
{
    public static void main(String[] args)
    {
        Scanner sc=new Scanner(System.in);

        Map<String,Festival> map=new HashMap<>();

        while(true)
        {
            String line=sc.nextLine();
            String[] p=line.split(" ");

            if(p[0].equals("ADD_FESTIVAL"))
            {
                String type=p[1];

                if(type.equals("MUSIC"))
                {
                    String name=p[2];
                    String location=p[3];
                    String date=p[4];
                    String headliner=p[5];
                    String genre=p[6];
                    int price=Integer.parseInt(p[7]);

                    map.put(name,new MusicFestival(name,location,date,headliner,genre,price));
                }
                else if(type.equals("FOOD"))
                {
                    String name=p[2];
                    String location=p[3];
                    String date=p[4];
                    String cuisine=p[5];
                    int stalls=Integer.parseInt(p[6]);
                    int fee=Integer.parseInt(p[7]);

                    map.put(name,new FoodFestival(name,location,date,cuisine,stalls,fee));
                }
                else if(type.equals("ART"))
                {
                    String name=p[2];
                    String location=p[3];
                    String date=p[4];
                    String artType=p[5];
                    int artists=Integer.parseInt(p[6]);
                    int fee=Integer.parseInt(p[7]);

                    map.put(name,new ArtFestival(name,location,date,artType,artists,fee));
                }
            }
            else if(p[0].equals("DISPLAY_DETAILS"))
            {
                String name=p[1];

                if(map.containsKey(name))
                {
                    map.get(name).display();
                }
            }
            else if(p[0].equals("EXIT"))
            {
                break;
            }
        }
    }
}