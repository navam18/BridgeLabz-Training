import java.util.*;

class Solution{
    public List<String> fizzBuzz(int n){
        List<String> list=new ArrayList<>();
        String s="";
        for(int x=1;x<=n;x++){
            if(x%3==0&&x%5==0){
                list.add("FizzBuzz");
            }else if(x%3==0){
                list.add("Fizz");
            }else if(x%5==0){
                list.add("Buzz");
            }else{
                list.add(s.valueOf(x));
            }
        }
        return list;
    }

    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        Solution obj=new Solution();
        List<String> result=obj.fizzBuzz(n);
        for(int i=0;i<result.size();i++){
            System.out.println(result.get(i));
        }
    }
}
