import java.util.*;
public class partitionOverPivot {
    public static void swap(int[] arr, int i, int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;

    }
    public static void partitionoverpivot(int[] arr, int si, int ei, int data){
       

        int p = si - 1, itr = si;
        while(itr <= ei){
            if(arr[itr] < data){
                swap(arr, itr, ++p);
            }
            itr++;
        }

            
        
    }
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int arr[] = new int[n];
        for(int i = 0; i < arr.length; i++){
            arr[i] = sc.nextInt();
        }
        
        partitionoverpivot(arr, 0, arr.length - 1, 7);
        for(int a : arr){
            System.out.print(a + " ");
        }

    }
    
}
