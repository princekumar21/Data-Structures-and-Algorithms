import java.util.Scanner;
public class sort01{
    public static void swap(int[] arr, int itr, int p1){
        int temp = arr[itr];
        arr[itr] = arr[p1];
        arr[p1] = temp;

    }
    public static int[] sort01(int arr[]){
        int p1 = -1;
        int itr = 0;

        if(arr[itr] == 0){
            swap(arr, itr++, ++p1);
        }

        itr++;

        return arr;

    }
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int arr[] = new int[n];
        for(int i = 0; i < arr.length; i++){
            arr[i] = sc.nextInt();
        }
        int[] arr1 = sort01(arr);
        for(int a : arr){
            System.out.print(a);
        }

    }
}