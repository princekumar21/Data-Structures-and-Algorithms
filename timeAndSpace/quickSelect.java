import java.util.*;
public class kSmallest {
    public static void swap(int[] arr, int i, int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;

    }
    public static int segregate(int[] arr, int si, int ei, int pIdx){
        swap(arr, ei, pIdx);

        int  p = si - 1, itr = si;
        while(itr <= ei){
            if(arr[itr] <= arr[ei]){
                swap(arr, itr, ++p);
            }
            itr++;
        } 
        return p; 

    }
    public static void quickselect(int[] arr, int si, int ei, int k){
        if(si > ei){
            return;
        }

        int pIdx = ei;
        int p = segregate(arr, si, ei, pIdx);

       if(p == (k - 1)){
           System.out.print(arr[k - 1]);
       }else if(p < k - 1){

        quickselect(arr, p + 1, ei, k); 
          

        }else {
            quickselect(arr, 0, p - 1, k);
        }
    }

    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int arr[] = new int[n];
        for(int i = 0; i < arr.length; i++){
            arr[i] = sc.nextInt();
        }
        int k = sc.nextInt();
        quickselect(arr, 0, arr.length - 1, k);
        





    }
    
}
