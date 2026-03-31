import java.util.*;
import java.util.regex.*;

class DynamicTemplateProcessor
{
    static boolean validDate(String d)
    {
        String[] p=d.split("-");
        if(p.length!=3) return false;

        int day=Integer.parseInt(p[0]);
        int month=Integer.parseInt(p[1]);
        int year=Integer.parseInt(p[2]);

        if(month<1 || month>12) return false;

        int[] days={31,28,31,30,31,30,31,31,30,31,30,31};

        boolean leap=(year%400==0)||(year%4==0 && year%100!=0);
        if(leap) days[1]=29;

        if(day<1 || day>days[month-1]) return false;

        return true;
    }

    public static void main(String[] args)
    {
        Scanner sc=new Scanner(System.in);

        int n=sc.nextInt();
        sc.nextLine();

        Pattern pattern=Pattern.compile("\\$\\{([^:]+):([^}]+)\\}");

        for(int i=0;i<n;i++)
        {
            String line=sc.nextLine();

            Matcher m=pattern.matcher(line);

            StringBuffer sb=new StringBuffer();

            while(m.find())
            {
                String type=m.group(1);
                String value=m.group(2);
                String rep="INVALID";

                if(type.equals("UPPER"))
                {
                    rep=value.toUpperCase();
                }
                else if(type.equals("LOWER"))
                {
                    rep=value.toLowerCase();
                }
                else if(type.equals("DATE"))
                {
                    if(validDate(value))
                    {
                        String[] p=value.split("-");
                        rep=p[2]+"/"+p[1]+"/"+p[0];
                    }
                }
                else if(type.equals("REPEAT"))
                {
                    String[] p=value.split(",");
                    if(p.length==2)
                    {
                        String w=p[0];
                        int c=Integer.parseInt(p[1]);
                        StringBuilder t=new StringBuilder();
                        for(int j=0;j<c;j++) t.append(w);
                        rep=t.toString();
                    }
                }

                m.appendReplacement(sb,rep);
            }

            m.appendTail(sb);

            System.out.println(sb.toString());
        }
    }
}