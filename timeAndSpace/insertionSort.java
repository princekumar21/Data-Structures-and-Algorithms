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
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int arr[] = new int[n];
        for(int i = 0; i < arr.length; i++){
            arr[i] = sc.nextInt();
        }
        int[] arr1 = insertionsort(arr);
        for(int a : arr1){
            System.out.print(a +" ");
        }

    }
    
    
}
