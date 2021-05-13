import java.util.*;
public class subsequence {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        System.out.println(getSubsequence(str));

    }
    public static ArrayList<String> getSubsequence(String str){
        if(str.length() == 0){
            ArrayList<String> base = new ArrayList<String>();
            base.add("");
            return base;
        }

        char ch = str.charAt(0);
        ArrayList<String> recAns = getSubsequence(str.substring(1));

        ArrayList<String> res = new ArrayList<String>();
        for(String s : recAns){
            res.add(s);
            res.add(ch + s);
        }
        return res;

    }
    
}
