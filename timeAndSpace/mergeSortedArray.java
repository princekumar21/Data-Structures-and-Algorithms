import java.util.*;
public class mergeSortedArray {
    public static int[] mergesortedArray(int[] arr, int[] arr1){
        int n = arr.length, m = arr1.length;
        int ans[] = new int[m + n];
        int i = 0, j = 0, k = 0;

        while(i < n && j < m){
            if(arr[i] < arr1[j]){
                ans[k++] = arr[i++];
            }else if(arr[i] >= arr1[j]){
                ans[k++] = arr1[j++];

            }
        }

        while(i < n){
           
                ans[k++] = arr[i++];

        }

        while(j < m){
           
                ans[k++] = arr1[j++];
           

        }
            return ans;

    }
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        

        int arr1[] = new int[n];
        for(int i = 0; i < arr1.length; i++){
            arr1[i] = sc.nextInt();
        }

        int n1 = sc.nextInt();
        int arr2[] = new int[n1];
        for(int i = 0; i < arr2.length; i++){
            arr2[i] = sc.nextInt();
        }
        //int[] arr1 = sort011(arr);
        int[] arr3 = mergesortedArray(arr1, arr2);
        for(int a : arr3){
            System.out.print(a + " ");
        }

    }
}
