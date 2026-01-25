package exceptions;
class ThrowAndThrows{
    public static double  calculateInterest(double principal,double time,double rate)throws IllegalArgumentException{
        if(principal<0||rate<0){
            throw new IllegalArgumentException();
        }
        return (principal*rate*time)/100.0;
    }
    public static void main(String args[]){
        try{
            double ans=calculateInterest(1000,2,-5);
            System.out.println("Interest:"+ans);
        }
        catch(IllegalArgumentException e){
            System.out.println("Principal and rate should be positive");
        }
    }
}