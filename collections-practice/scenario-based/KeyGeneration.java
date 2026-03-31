import java.util.*;

class KeyGeneration
{
    public static void main(String[] args)
    {
        Scanner sc=new Scanner(System.in);

        int n=sc.nextInt();
        sc.nextLine();

        for(int i=0;i<n;i++)
        {
            String s=sc.nextLine();

            if(s.length()==0)
            {
                System.out.println("Invalid Input (empty string)");
                continue;
            }

            if(s.length()<6)
            {
                System.out.println("Invalid Input (length < 6)");
                continue;
            }

            if(s.contains(" "))
            {
                System.out.println("Invalid Input (contains space)");
                continue;
            }

            if(s.matches(".*[0-9].*"))
            {
                System.out.println("Invalid Input (contains digits)");
                continue;
            }

            if(!s.matches("[a-zA-Z]+"))
            {
                System.out.println("Invalid Input (contains special character)");
                continue;
            }

            s=s.toLowerCase();

            StringBuilder sb=new StringBuilder();

            for(int j=0;j<s.length();j++)
            {
                char c=s.charAt(j);

                if(((int)c)%2!=0)
                {
                    sb.append(c);
                }
            }

            sb.reverse();

            for(int j=0;j<sb.length();j++)
            {
                if(j%2==0)
                {
                    sb.setCharAt(j,Character.toUpperCase(sb.charAt(j)));
                }
            }

            System.out.println("The generated key is - "+sb.toString());
        }
    }
}