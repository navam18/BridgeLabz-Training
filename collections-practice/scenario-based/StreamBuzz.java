import java.util.*;

class CreatorStats{

    public String CreatorName;
    public double[] WeeklyLikes;

}

class StreamBuzz{

    public static List<CreatorStats> EngagementBoard = new ArrayList<>();

    public void RegisterCreatorStats(CreatorStats record){
        EngagementBoard.add(record);
    }

    public Dictionary<String, Integer> GetTopPostCounts(List<CreatorStats> records, double likeThreshold){

        Dictionary<String, Integer> result = new Hashtable<>();


        for(CreatorStats creator : records){
            int count =0;

            for(double likes : creator.WeeklyLikes){

                if(likes >= likeThreshold){
                    count++;
                }

            }

            if(count > 0){
                result.put(creator.CreatorName, count);
            }   
        }

        return result;
    }

    public double CalculateAverageLikes(){
        double totalLikes = 0;
        int total = 0;

        for(CreatorStats creator : EngagementBoard){
            for(double likes : creator.WeeklyLikes){
                totalLikes += likes;
                total++;
            }
        }

        return totalLikes / total;
    }


    public static void main(String[] args){

       Scanner scanner = new Scanner(System.in);
       StreamBuzz program = new StreamBuzz();
       int choice = 0;

       do{
        System.out.println("1. Register Creator Stats");
        System.out.println("2. Show Top Posts");
        System.out.println("3. Calculate Average Likes");
        System.out.println("4. Exit");

        System.out.println("Enter your choice: ");
        choice = scanner.nextInt();
        scanner.nextLine();

        switch (choice) {
            case 1 : 
                CreatorStats creator = new CreatorStats();
                System.out.println("Enter Creator Name: ");
                String creatorName = scanner.nextLine();
                creator.CreatorName = creatorName;

                double[] weeklylikes = new double[4];
                System.out.println("Enter weekly likes (Week 1 to 4): ");
                for(int i=0;i<4;i++){
                    weeklylikes[i] = scanner.nextDouble();
                }
                creator.WeeklyLikes = weeklylikes;

                EngagementBoard.add(creator);

                System.out.println("Creator registered successfully");
                break;
            
            case 2 : 
                System.out.println("Enter like threshold: ");
                double threshold = scanner.nextDouble();

                Dictionary<String, Integer> topPosts = program.GetTopPostCounts(EngagementBoard, threshold);

                if(topPosts.isEmpty()){
                    System.out.println("No top-performing posts this week");
                }
                else{

                    Enumeration<String> keys = topPosts.keys();
                        while (keys.hasMoreElements()) {
                            String name = keys.nextElement();
                            System.out.println(name + " - " + topPosts.get(name));
                        }
                }
                break;
                
            case 3 : 
                double Average = program.CalculateAverageLikes();
                System.out.println("Overall Average weekly likes: "+Average);
                break;
            case 4 : 
                System.out.println("Logging off - Keep Creating with StreamBuzz!");
                break;       
        }
    }while(choice != 4);
    scanner.close();
}
}