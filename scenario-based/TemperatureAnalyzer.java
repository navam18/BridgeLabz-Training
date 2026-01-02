import java.util.*;
class TemperatureAnalyzer{
    static double[] analyze(float[][] temp){
        double[] avg=new double[7];
        int hotDay=0,coldDay=0;
        double hotSum=Double.MIN_VALUE,coldSum=Double.MAX_VALUE;
        for(int i=0;i<7;i++){
            double sum=0;
            for(int j=0;j<24;j++){
                sum+=temp[i][j];
            }
            avg[i]=sum/24;
            if(sum>hotSum){
                hotSum=sum;
                hotDay=i;
            }
            if(sum<coldSum){
                coldSum=sum;
                coldDay=i;
            }
        }
        System.out.println(hotDay);
        System.out.println(coldDay);
        return avg;
    }
    public static void main(String[] args){
        float[][] temp=new float[7][24];
        Random r=new Random();
        for(int i=0;i<7;i++){
            for(int j=0;j<24;j++){
                temp[i][j]=20+r.nextFloat()*15;
            }
        }
        double[] avg=analyze(temp);
        for(int i=0;i<7;i++){
            System.out.println(avg[i]);
        }
    }
}
