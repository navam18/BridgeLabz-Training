import java.util.*;

class Solution{
    public int[] twoSum(int[] nums,int target){
        for(int x=0;x<nums.length;x++){
            for(int y=x+1;y<nums.length;y++){
                if(nums[x]+nums[y]==target){
                    return new int[]{x,y};
                }
            }
        }
        return new int[]{};
    }

    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int[] nums=new int[n];
        for(int i=0;i<n;i++){
            nums[i]=sc.nextInt();
        }
        int target=sc.nextInt();
        Solution obj=new Solution();
        int[] result=obj.twoSum(nums,target);
        if(result.length==2){
            System.out.println(result[0]+" "+result[1]);
        }else{
            System.out.println("No pair found");
        }
    }
}
