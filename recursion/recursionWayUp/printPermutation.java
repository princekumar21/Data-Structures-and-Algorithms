import java.util.*;
public class printPermutation {
    public static void printpermutation(String str, String ans){

        if(str.length() == 0){
            System.out.println(ans);
        }

        for(int i = 0; i < str.length(); i++){
            char ch = str.charAt(i);
            String roq = str.substring(0, i) + str.substring(i + 1);

            printpermutation(roq, ans + ch);

        }
        


    }
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        String ans = "";
        printpermutation(str, ans);


    }
}
