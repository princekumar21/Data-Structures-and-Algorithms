import java.util.*;
public class floodfill2{
    public static void main(String args[]){
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int m = scn.nextInt();
        int[][] arr = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                arr[i][j] = scn.nextInt();
            }
        }
        boolean board[][] = new boolean[n][m];
        int dir[][] = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}}; //we have to move four direction
        String dirS[] = {"r", "d", "l", "t"};
        floodfill3(0, 0, 2, 2, arr, "", board, dir, dirS);
    }
    public static int floodfill3(int sr, int sc, int er, int ec, int[][] arr, String ans,boolean[][] board, int[][] dir, String[] dirS ){
        if(sr == er && sc == ec){
            System.out.println(ans);
            return 1;
        }
        board[sr][sc] = true;
        int n = arr.length - 1; int m = arr[0].length - 1;
        int count = 0;
        for(int d = 0; d < dir.length; d++){
            int r = sr + dir[d][0];
            int c = sc + dir[d][1];
            
            
            if(r >= 0 && c >= 0 && r <= n && c <= m){
                if(board[r][c] == false){
                    count += floodfill3(r, c, er, ec, arr, ans + dirS[d], board, dir, dirS);
                }
               
                
            }
        }
        board[sr][sc] = false;
        return count;
    }
}