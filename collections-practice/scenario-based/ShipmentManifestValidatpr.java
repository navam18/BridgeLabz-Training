import java.util.*;

class ShipmentManifestValidator
{
    static boolean isLeap(int y)
    {
        if(y%400==0) return true;
        if(y%100==0) return false;
        return y%4==0;
    }

    static boolean validCode(String code)
    {
        if(!code.matches("SHIP-[1-9][0-9]{5}")) return false;

        String d=code.substring(5);
        int c=1;

        for(int i=1;i<d.length();i++)
        {
            if(d.charAt(i)==d.charAt(i-1))
            {
                c++;
                if(c>3) return false;
            }
            else
            {
                c=1;
            }
        }
        return true;
    }

    static boolean validDate(String date)
    {
        if(!date.matches("20[0-9]{2}-[0-9]{2}-[0-9]{2}")) return false;

        String[] p=date.split("-");
        int y=Integer.parseInt(p[0]);
        int m=Integer.parseInt(p[1]);
        int d=Integer.parseInt(p[2]);

        if(m<1 || m>12) return false;

        int[] days={31,28,31,30,31,30,31,31,30,31,30,31};

        if(isLeap(y)) days[1]=29;

        if(d<1 || d>days[m-1]) return false;

        return true;
    }

    static boolean validMode(String mode)
    {
        return mode.matches("AIR|SEA|ROAD|RAIL|EXPRESS|FREIGHT");
    }

    static boolean validWeight(String w)
    {
        if(!w.matches("(0|[1-9][0-9]{0,5})(\\.[0-9]{1,2})?")) return false;

        double val=Double.parseDouble(w);

        return val>=0 && val<=999999.99;
    }

    static boolean validStatus(String s)
    {
        return s.matches("DELIVERED|CANCELLED|IN_TRANSIT");
    }

    public static void main(String[] args)
    {
        Scanner sc=new Scanner(System.in);

        int n=sc.nextInt();
        sc.nextLine();

        for(int i=0;i<n;i++)
        {
            String rec=sc.nextLine();

            String[] p=rec.split("\\|");

            if(p.length!=5)
            {
                System.out.println("NON-COMPLIANT RECORD");
                continue;
            }

            if(validCode(p[0]) && validDate(p[1]) && validMode(p[2]) && validWeight(p[3]) && validStatus(p[4]))
            {
                System.out.println("COMPLIANT RECORD");
            }
            else
            {
                System.out.println("NON-COMPLIANT RECORD");
            }
        }
    }
}