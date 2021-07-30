import java.util.*;
public class insertionSort {
    public static void swap(int[] arr, int i, int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;

    }
    public static int[] insertionsort(int[] arr){

        for(int i = 1; i < arr.length; i++){
            if(arr[i] < arr[i - 1]){
                for(int j = i; j > 0; j--){
                    if(arr[j] < arr[j - 1]){
                        swap(arr, j , j - 1);
                    }
                }
            }
        }
        return arr;
        


    }
    
    
    
}
