import java.util.*;

public class lastFirstIndex {
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        
        int arr[] = new int[n];
        for(int i = 0; i < n; i++){
            arr[i] = sc.nextInt();
        }
        int find = sc.nextInt();
        
        
        System.out.println(firstIndex(arr, find));
        System.out.println(lastIndex(arr, find));
        
    }
    

public static int lastIndex(int[] arr, int find){
    int l = 0;
    int h = arr.length - 1;
    
    while(l <= h){

        int mid = (l + h) / 2;

        if(find == arr[mid]){

            if(mid + 1 <= arr.length - 1 && find == arr[mid + 1]){
                l = mid + 1;
            }else{
                return mid;
            }

        }else if(find < arr[mid]){

            h = mid - 1;

        }else{
         l = mid + 1;

        }
    }
    return -1;
   
    

}
public static int firstIndex(int[] arr, int find){
    int l = 0;
    int h = arr.length - 1;
    
    while(l <= h){

        int mid = (l + h) / 2;

        if(find == arr[mid]){

            if(mid - 1  >= 0 && find == arr[mid -1]){
                h = mid - 1;
            }else{
                return mid;
            }

        }else if(find < arr[mid]){

            h = mid - 1;

        }else{
         l = mid + 1;

        }
    }
    return -1;
   
    } 

}
