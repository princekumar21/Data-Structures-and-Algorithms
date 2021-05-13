import java.util.*;
public class subSequence {
    public static void subsequence(String str, String ans){
        if(str.length() == 0){
            System.out.println(ans);
            return;
        }
        char ch = str.charAt(0);
        String roq = str.substring(1);

        
        subsequence(roq, ans + ch);
        subsequence(roq, ans);

    }
    public static int subsequenceStore(String str, String ans, ArrayList<String> res){
        if(str.length() == 0){
            res.add(ans);
            return 1;
        }
        int count = 0;
        char ch = str.charAt(0);
        String roq = str.substring(1);

        
        count += subsequenceStore(roq, ans + ch, res);
        count += subsequenceStore(roq, ans, res);

        return count;
    }
    public static void printStairsPath(){
        

    }
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        String ans = "";
        //subsequence(str, ans);

        ArrayList<String> res = new ArrayList<>();
        subsequenceStore(str, ans, res);
        System.out.println(res);

    }
    
}
