import java.util.Scanner;
public class sort01{
    public static int[] sort012(int[] arr){
        int n = arr.length,  p = -1, itr = 0, p2 = n - 1;
        
        while(itr <= p2){

            if(arr[itr] == 0){
                swap(arr, itr++, ++p);
            }else if(arr[itr] == 2){

                swap(arr, itr, p2--);
              
            }else{
                itr++;
            }

        }
        return arr; 
    }
    
    public static int[] sort011(int[] arr){
        int p = -1;
        int itr = 0;

        while(itr < arr.length){

            if(arr[itr] == 0){
                swap(arr, itr, ++p);
            }
    
            itr++;
        }

        return arr;

    }

    public static void swap(int[] arr, int itr, int p1){
        int temp = arr[itr];
        arr[itr] = arr[p1];
        arr[p1] = temp;

    }
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int arr[] = new int[n];
        for(int i = 0; i < arr.length; i++){
            arr[i] = sc.nextInt();
        }
        //int[] arr1 = sort011(arr);
        int[] arr1 = sort012(arr);
        for(int a : arr1){
            System.out.print(a + " ");
        }

    }
}