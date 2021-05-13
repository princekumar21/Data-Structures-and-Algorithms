import java.util.*;
public class string {
     public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        //solution(str);
        stringCompression(str);

    }
    public static void solution(String str){
       for(int i = 0; i < str.length(); i++){
            for(int j = i; i < str.length(); j++){
                if(!isPalindrome(str, i , j)){
                    String s = str.substring(i, j + 1);
                    System.out.print(s);
                }

            }
       }
        
    }
    public static boolean isPalindrome(String str, int i, int j){
        
        while(i < j){
            if(str.charAt(i) != str.charAt(j)){
                return false;

            } 
            i++;
            j--;
        }
        return true;
    }
    public static void removeDuplicate(String str){
        String s = "";
        s = str.charAt(0) + "";
        for(int i = 1; i < str.length(); i++){
            if(str.charAt(i) != str.charAt(i - 1)){
                s += str.charAt(i);

            }
        }
        System.out.print(s);
    }
    public static void removeDuplicate2(String str){
        String ans = "";
        ans = str.charAt(0) + "";
        int n = str.length();
        int i = 1;
        while(i < n){
            while( i < n && str.charAt(i) == ans.charAt(ans.length() - 1)){
                i++;

            }
            if(i < n){
                ans += str.charAt(i);
                i++;
            }
        }
        
    }
    public static void stringCompression(String str){
        String ans = "";
        ans = str.charAt(0) + "";
        int n = str.length();
        int count  = 1;
        int i = 1;
        while(i < n){
            while( i < n && str.charAt(i) == ans.charAt(ans.length() - 1)){
                i++;
                count++;
            }
            if(i < n){
                if(count > 1){
                    ans += count;
                    ans += str.charAt(i);
                }else{
                    ans += str.charAt(i);
                }
                count = 1;
                i++;
            }
        }
        ans += count;
        
        System.out.print(ans);
        
    }

    
}

