import java.util.*;
public class printEncoding {

    public static void printEncodings(String str, String ans) {
        if(str.length() == 0){
            System.out.println(ans);
            return;
        }
        
        char ch = str.charAt(0);
        if(ch == '0'){
            return;
        }
        
        printEncodings(str.substring(1), ans + (char)('a' + (ch - '0') - 1));
        
        if(str.length() > 1){
            int num = (ch - '0') * 10 + str.charAt(1) - '0';
            
            if(num <= 26){
                printEncodings(str.substring(2), ans + (char)((num - 1) + 'a'));
            }
        }
        
    }
    
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        //String ans = "";
        printEncodings(str, "");
        //permutationNoRepetition(str);


    }
    
}
