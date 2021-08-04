public class practiseRecurTree {
    //this is also a permutation means we acn a make a choice use coins repeatidily
    public static int InfiCoins(int [] arr, int tar, String asf){
        if(tar == 0){
            System.out.println(asf);
            return 1;
        }
        int count = 0;
        for(int i = 0; i < arr.length; i++){
            if(tar - arr[i] >= 0){
                count += InfiCoins(arr, tar - arr[i],  asf  + i + " ");

            }
        }
        return count;

    }

    public static int limitCoins(int arr[], int tar, String asf, int idx){
        if(tar == 0){
            System.out.println(asf );
            return 1;
        }
        int count = 0;
        for(int i = idx; i < arr.length; i++){
            if(tar - arr[i] >= 0 ){
               
               count +=  limitCoins(arr, tar - arr[i], asf  + arr[i], i);
                

            }
          
        }
        return count;

    }

   
}
