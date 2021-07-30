import java.util.Scanner;
public class targetSumPair{
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
    public static void targetsumpair(int[] arr, int target){
        quickSort(arr, 0, arr.length - 1);

        int i = 0, k = arr.length - 1;
        int sum = target;

        while(i < k){
            if(arr[i] + arr[k] == sum){
                System.out.print(arr[i] + ","+ arr[k]);
                i++;
                k--;
            }
            else if(arr[i] + arr[k]  > sum){
                k--;
            }else {
                i++;
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
        int target = sc.nextInt();
        targetsumpair(arr, target);


    }
    
}
