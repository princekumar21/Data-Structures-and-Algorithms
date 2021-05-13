import java.util.*;
public class mazePath {
    public static void main(String args[]){
        Scanner scn = new Scanner(System.in);
        int sr = scn.nextInt();
        int sc = scn.nextInt();
        int dr = scn.nextInt();
        int dc = scn.nextInt();
        String psf = "";
       mazePath2(sr, sc, dr, dc, psf);

    }
    public static int mazePath1(int sr, int sc, int dr, int dc){
        if(sr == dr && sc == dc){
            return 1;
        }

        int count = 0;
        if(sc + 1 <= dc){
            count += mazePath1(sr, sc + 1, dr, dc);
        }
        if(sc + 1 <= dc && sr + 1 <= dr){
            count += mazePath1(sr + 1, sc + 1, dr, dc);
        }
        if(sr + 1 <= dr){
            count += mazePath1(sr + 1, sc, dr, dc);
        }
        

        return count;
    }
    public static void mazePath2(int sr, int sc, int dr, int dc, String ans){
        if(sr == dr && sc == dc){

            System.out.println(ans);
            return;
        }

        int count = 0;
        if(sc + 1 <= dc){
             mazePath2(sr, sc + 1, dr, dc, ans + "H");
        }
        if(sc + 1 <= dc && sr + 1 <= dr){
            mazePath2(sr + 1, sc + 1, dr, dc, ans + "D");
        }
        if(sr + 1 <= dr){
             mazePath2(sr + 1, sc, dr, dc, ans + "V");
        }
        

        
    }
    
}
