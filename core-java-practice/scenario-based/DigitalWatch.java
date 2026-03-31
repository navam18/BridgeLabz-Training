class DigitalWatch{
    static void run(){
        for(int hour=0;hour<24;hour++){
            for(int minute=0;minute<60;minute++){
                if(hour==13&&minute==0)break;
                System.out.println(hour+":"+minute);
            }
            if(hour==13)break;
        }
    }

    public static void main(String[] args){
        run();
    }
}
