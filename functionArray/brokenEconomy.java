import java.util.*;
public class brokenEconomy {
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        
        int arr[] = new int[n];
        for(int i = 0; i < n; i++){
            arr[i] = sc.nextInt();
        }
        int find = sc.nextInt();
       
        brokenEconomy(arr, find);
    }
    

public static void brokenEconomy(int arr[], int find){
        

    int l = 0;
    int h = arr.length - 1;
    int floor = 0;
    int ceil = 0;
    
    while(l <= h){

        int mid = (l + h) / 2;

        if(find == arr[mid]){

            System.out.println(mid);
            System.out.println(mid);
            return;

        }else if(find < arr[mid]){

            h = mid - 1;
            floor = arr[mid];

        }else{
         l = mid + 1;
         ceil = arr[mid];

        }
    }
    System.out.println(floor);
    System.out.println(ceil);

    } 

}
