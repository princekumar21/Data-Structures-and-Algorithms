package array;
import java.util.*;
public class array1 {
    public static Scanner sc = new Scanner(System.in);
    public static int[] inputArray(int n){
        int arr[] = new int[n];
        for(int i = 0; i < n; i++){
            arr[i] = sc.nextInt();
        }
        return arr;

    }
    public static void diplayArray(int[] arr){
        for(int i = 0; i < arr.length; i++){
            System.out.println(arr[i]);
        }
    }

    public static void main(String args[]){
        int n = sc.nextInt();
        int arr[] = inputArray(n);
        diplayArray(arr);


    }

}
