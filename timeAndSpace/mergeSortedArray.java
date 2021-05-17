import java.util.*;
public class mergeSortedArray {
    public static int[] mergesortedArray(int[] arr1, int[] arr2){
        int n = arr1.length, m = arr2.length;
        int ans[] = new int[m + n];
        int i = 0, j = 0, k = 0;

        while(i < n && j < m){
            if(arr1[i] < arr2[j]){
                ans[k++] = arr1[i++];
            }else{
                ans[k++] = arr2[j++];

            }
        }

        while(i < n){
           
                ans[k++] = arr1[i++];

        }

        while(j < m){
           
                ans[k++] = arr2[j++];
           }
            return ans;

    }

    //above code is better in terms of time complexity
    public static int[] mergesortedArray2(int[] arr1, int[] arr2){
        int n = arr1.length, m = arr2.length;
        int ans[] = new int[m + n];
        int i = 0, j = 0, k = 0;

        while(i < n || j < m){
            if(i == n){
                ans[k++] = arr2[j++];
            }
            else if(j == m){
                ans[k++] = arr1[i++];
            }
            if(arr1[i] < arr2[j]){

                ans[k++] = arr1[i++];

            }else{
                ans[k++] = arr2[j++];

            }
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
        
        int[] arr3 = mergesortedArray2(arr1, arr2);
        for(int a : arr3){
            System.out.print(a + " ");
        }

    }
}
