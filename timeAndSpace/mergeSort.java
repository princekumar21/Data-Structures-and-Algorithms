import java.util.*;
public class mergeSort {
    public static void main(){
        
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
