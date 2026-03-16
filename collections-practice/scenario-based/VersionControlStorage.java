import java.util.*;

class VersionControlledStorage
{
    static class FileVersion
    {
        String version;
        int size;

        FileVersion(String version,int size)
        {
            this.version=version;
            this.size=size;
        }
    }

    public static void main(String[] args)
    {
        Scanner sc=new Scanner(System.in);

        int n=sc.nextInt();
        sc.nextLine();

        Map<String,List<FileVersion>> map=new HashMap<>();

        for(int i=0;i<n;i++)
        {
            String line=sc.nextLine();
            String[] p=line.split(" ");

            if(p[0].equals("UPLOAD"))
            {
                String file=p[1];
                String version=p[2];
                int size=Integer.parseInt(p[3]);

                map.putIfAbsent(file,new ArrayList<>());

                boolean exists=false;

                for(FileVersion fv:map.get(file))
                {
                    if(fv.version.equals(version))
                    {
                        exists=true;
                        break;
                    }
                }

                if(!exists)
                {
                    map.get(file).add(new FileVersion(version,size));
                }
            }
            else if(p[0].equals("FETCH"))
            {
                String file=p[1];

                if(!map.containsKey(file))
                {
                    System.out.println("File Not Found");
                    continue;
                }

                List<FileVersion> list=new ArrayList<>(map.get(file));

                Collections.sort(list,(a,b)->{
                    if(a.size!=b.size) return a.size-b.size;
                    return a.version.compareTo(b.version);
                });

                for(FileVersion fv:list)
                {
                    System.out.println(file+" "+fv.version+" "+fv.size);
                }
            }
            else if(p[0].equals("LATEST"))
            {
                String file=p[1];

                if(!map.containsKey(file))
                {
                    System.out.println("File Not Found");
                    continue;
                }

                List<FileVersion> list=map.get(file);
                FileVersion fv=list.get(list.size()-1);

                System.out.println(file+" "+fv.version+" "+fv.size);
            }
            else if(p[0].equals("TOTAL_STORAGE"))
            {
                String file=p[1];

                if(!map.containsKey(file))
                {
                    System.out.println("File Not Found");
                    continue;
                }

                int sum=0;

                for(FileVersion fv:map.get(file))
                {
                    sum+=fv.size;
                }

                System.out.println(file+" "+sum);
            }
        }
    }
}