import java.util.*;
public class countSort {
    public static void countsort(int[] arr){
        int freq[] = new int[21];
        for(int i = 0; i < arr.length; i++){
                int idx = arr[i];
                freq[idx]++;
        }

        for(int p = 0; p < freq.length; p++){
            for(int k = 0; k < freq[p]; k++){
                System.out.print(p + " ");
            }
        }

    }
    public static void main(String args[]){
        
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int arr[] = new int[n];
        for(int i = 0; i < arr.length; i++){
            arr[i] = sc.nextInt();
        }
        countsort(arr);
        
    }
    
}
