import java.util.*;
public class stairsPath {

    public static int boardPathJump(int n , int[] arr, String ans){
        if(n == 0){
            System.out.println(ans);
            return 1;
        }
        
        int count = 0;
        for(int jump : arr){
            if(n - jump >= 0){
                count += boardPathJump(n - jump, arr, ans + jump);
            }
            
        }
        return count;
    }

    public static int boardPathLudo(int n, String ans){
        if(n == 0){
            System.out.println(ans);
            return 1;
        }
        
        int count = 0;
        for(int dice = 1; dice <= 6 && n - dice >= 0; dice++){
            count += boardPathLudo(n - dice, ans + dice);
        }

        return count;
    }


    public static int countStairsPath(int n){
        if(n == 0){
            return 1;
        }

        int count = 0; 
        for(int jump = 1; jump <= 3 && n - jump >= 0; jump++){
            count += countStairsPath(n - jump);
        }

        return count;

    }
    public static int printStairsPath(int n, String ans){
        if(n == 0){
            System.out.println(ans);
            return 1;
        }

        int count = 0; 
        for(int jump = 1; jump <= 3 && n - jump >= 0; jump++){
            count += printStairsPath(n - jump, ans + jump);
        }

        return 1;

    }
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        //int totalPath = countStairsPath(n);
        //System.out.println(totalPath);
        String ans = "";
        // printStairsPath(n, ans);
        int m = sc.nextInt();
        int arr[] = new int[m];
        for(int i = 0; i  < m; i++){
            arr[i] = sc.nextInt();
        }
        System.out.print(boardPathJump(n, arr, ans));


    }



}