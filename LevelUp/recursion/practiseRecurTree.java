import java.util.*;
public class practiseRecurTree {
    //this is also a permutation means we acn a make a choice use coins repeatidily
    public static int InfiCoinsPerm(int [] arr, int tar, String asf){
        if(tar == 0){
            System.out.println(asf);
            return 1;
        }
        int count = 0;
        for(int i = 0; i < arr.length; i++){
            if(tar - arr[i] >= 0){
                count += InfiCoinsPerm(arr, tar - arr[i],  asf  + i + " ");

            }
        }
        return count;

    }

    public static int unlimitCoinsCombination(int arr[], int tar, String asf, int idx){
        if(tar == 0){
            System.out.println(asf );
            return 1;
        }
        int count = 0;
        for(int i = idx; i < arr.length; i++){
            if(tar - arr[i] >= 0 ){
               
               count +=  unlimitCoinsCombination(arr, tar - arr[i], asf  + arr[i], i);
                

            }
          
        }
        return count;

    }

    public static int limitCoinsCombination(int arr[], int tar, String asf, int idx){
        if(tar == 0){
            System.out.println(asf );
            return 1;
        }
        int count = 0;
        for(int i = idx; i < arr.length; i++){
            if(tar - arr[i] >= 0 ){
               
               count +=  limitCoinsCombination(arr, tar - arr[i], asf  + arr[i], i + 1);
                

            }
          
        }
        return count;

    }

    public static int limitedCoinsPerm(int [] arr, int tar, String asf, int idx){
        if(tar == 0){
            System.out.println(asf);
            return 1;
        }
        int count = 0;
        for(int i = idx; i < arr.length; i++){
            if(tar - arr[i] >= 0){
                count += limitedCoinsPerm(arr, tar - arr[i],  asf  + arr[i] + " ", i  + 1);

            }
        }
        return count;

    }

    public static void combinationsum(int[] candidate, int target, int idx, List<List<Integer>> ans, List<Integer> smallAns){
        
        if(target == 0){
            List<Integer> base = new ArrayList<>(smallAns); //deep copy 
             ans.add(base);    //shallow copy
           return;
        }
        for(int i = idx ; i < candidate.length; i++){
            if(target - candidate[i] >= 0){
                smallAns.add(candidate[i]);
                combinationsum(candidate, target - candidate[i], i, ans, smallAns);
                smallAns.remove(smallAns.size() - 1);
                
            }
        }
    }
    
    
    public static List<List<Integer>> combinationSum(int[] candidates, int target) {
         List<Integer> smallAns = new ArrayList<>();
         List<List<Integer>> ans = new ArrayList<>();
             
         combinationsum(candidates,target, 0, ans, smallAns);
            
        return ans;
    }

    



    public static void main(String[] args){
        int arr[] = {2,3,5,7};
        boolean vis[] = new boolean[arr.length];
        // InfiCoins(arr, 10, "");
        // combinationSum(arr, 10);
    }
}
