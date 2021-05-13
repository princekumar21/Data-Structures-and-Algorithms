import java.util.*;
public class selectionSort {
    public static void swap(int[] arr, int i , int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
    
    public static int[] selectionsort(int[] arr){

        for(int i = 0; i <= arr.length - 2; i++){
            for(int j = i + 1; j <= arr.length - 1; j++){
                if(arr[i] > arr[j]){
                    swap(arr, i, j);
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
        int[] arr1 = selectionsort(arr);
        for(int a : arr1){
            System.out.print(a +" ");
        }

    }
    
}
