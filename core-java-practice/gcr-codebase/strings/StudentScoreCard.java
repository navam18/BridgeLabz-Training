import java.util.*;
class StudentScoreCard{
    static int[][] generateScores(int n){
        Random r=new Random();
        int[][] pcm=new int[n][3];
        for(int i=0;i<n;i++){
            for(int j=0;j<3;j++){
                pcm[i][j]=r.nextInt(90)+10;
            }
        }
        return pcm;
    }
    static double[][] calculateStats(int[][] pcm){
        int n=pcm.length;
        double[][] stats=new double[n][4];
        for(int i=0;i<n;i++){
            int total=pcm[i][0]+pcm[i][1]+pcm[i][2];
            double avg=total/3.0;
            double per=avg;
            stats[i][0]=total;
            stats[i][1]=Math.round(avg*100.0)/100.0;
            stats[i][2]=Math.round(per*100.0)/100.0;
        }
        return stats;
    }
    static char[] calculateGrade(double[][] stats){
        int n=stats.length;
        char[] g=new char[n];
        for(int i=0;i<n;i++){
            double p=stats[i][2];
            if(p>=80) g[i]='A';
            else if(p>=70) g[i]='B';
            else if(p>=60) g[i]='C';
            else if(p>=50) g[i]='D';
            else if(p>=40) g[i]='E';
            else g[i]='R';
        }
        return g;
    }
    static void display(int[][] pcm,double[][] stats,char[] g){
        System.out.println("Phy\tChem\tMath\tTotal\tAvg\t%\tGrade");
        for(int i=0;i<pcm.length;i++){
            System.out.println(pcm[i][0]+"\t"+pcm[i][1]+"\t"+pcm[i][2]+"\t"+(int)stats[i][0]+"\t"+stats[i][1]+"\t"+stats[i][2]+"\t"+g[i]);
        }
    }
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int[][] pcm=generateScores(n);
        double[][] stats=calculateStats(pcm);
        char[] grade=calculateGrade(stats);
        display(pcm,stats,grade);
    }
}
