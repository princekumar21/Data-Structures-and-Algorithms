import java.util.*;
public class binarySearch {
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        
        int arr[] = new int[n];
        for(int i = 0; i < n; i++){
            arr[i] = sc.nextInt();
        }
        int find = sc.nextInt();
        System.out.print(binarySearching(arr, find));
        
        
    }
    public static int binarySearching(int[] arr, int find){
        int l = 0;
        int h = arr.length - 1;
        
        while(l <= h){

            int mid = (l + h) / 2;

           if(find < arr[mid]) h = mid - 1;

           else if(find > arr[mid]) l = mid + 1;

           else return mid;

        }
        return -1;
       
        

    }
    
    
    
}
