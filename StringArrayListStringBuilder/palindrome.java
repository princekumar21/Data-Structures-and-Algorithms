import java.util.*;
public class palindrome {
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        palindrome1(str);


    }
    public static void palindrome1(String str){
       for(int i = 0; i < str.length(); i++){
            for(int j = i; j < str.length(); j++){
                if(!palindromeCheck(str, i , j)){
                    String s = str.substring(i, j + 1);
                    System.out.println(s);
                }

            }
       }
        
    }
    public static boolean palindromeCheck(String str, int i, int j){
        
        while(i < j){
            if(str.charAt(i) != str.charAt(j)){
                return false;

            } 
            i++;
            j--;
        }
        return true;
    }
    
}
