import java.util.*;
public class getKpc {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        System.out.println(getKPC(str));

    }
    public static String[] keys = {".;", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tu", "vwx", "yz",};

    public static ArrayList<String> getKPC(String str) {
        if(str.length() == 0){
            ArrayList<String> base = new ArrayList<String>();
            base.add("");
            return base;
        }
       
        char ch = str.charAt(0);
        String code = keys[ch - '0'];
        ArrayList<String> recAns =  getKPC(str.substring(1));
        ArrayList<String> myAns = new ArrayList<String>();
        
        for(int i = 0; i < code.length(); i++){
            
            for(String s : recAns){
                myAns.add(code.charAt(i) + s);

            }
        }
        return myAns;
    }

}
    

