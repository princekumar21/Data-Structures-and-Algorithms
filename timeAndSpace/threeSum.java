import java.util.ArrayList;
import java.util.Scanner;
public class threeSum{
    public static void swap(int[] arr, int i, int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;

    }
    public static int segregate(int[] arr, int si, int ei, int pIdx){
        swap(arr, pIdx, ei);

        int p = si - 1, itr = si; 
        while(itr <= ei){
            if(arr[itr] <= arr[ei]){
                swap(arr, itr, ++p);
            }
            itr++;
        }

        return p;

    }
    public static void quickSort(int[] arr, int si, int ei){
        if(si > ei){
            return;
        }

        int pIdx = ei;
        int p = segregate(arr, si, ei, pIdx);

        quickSort(arr, 0, p - 1);
        quickSort(arr, p  + 1, ei);

    }
    public static ArrayList<int[]> sumpair(int[] arr, int tar){
        quickSort(arr, 0, arr.length - 1);

        int i = 0, j = arr.length - 1;
        ArrayList<int[]> ans = new ArrayList<>();

        while(i < j){
            if(arr[i] + arr[j] == tar){
                ans.add(new int[] {arr[i], arr[j]});
                i++;
                j--;
            }else if(arr[i] + arr[j] < tar){
                i++;

            }else{
                j--;
            }

        }

        return ans;

    }
    public static void threesum(int[] arr, int target){
        
        

    }
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int arr[] = new int[n];
        for(int i = 0; i < arr.length; i++){
            arr[i] = sc.nextInt();
        }
        int target = sc.nextInt();
        ArrayLis
        = sumpair(arr, target);
        for(int[] a : al){
            System.out.print(a[0] + arr[1]);
        }

        
        

    }


}