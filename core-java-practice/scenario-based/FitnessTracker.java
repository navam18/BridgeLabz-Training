class FitnessTracker{
    static void run(){
        int[] pushUps={20,30,0,25,40,0,35};
        int total=0;
        int days=0;
        for(int count:pushUps){
            if(count==0)continue;
            total+=count;
            days++;
        }
        System.out.println("Total:"+total);
        System.out.println("Average:"+(total/days));
    }

    public static void main(String[] args){
        run();
    }
}
