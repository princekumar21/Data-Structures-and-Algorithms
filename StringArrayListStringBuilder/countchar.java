import java.util.*;
public class countchar {
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        charCount(str);


    }
    public static void charCount(String str){
        int count = 0;
        String ans = "";
        ans = str.charAt(0) +"";
        for(int i = 0; i < str.length(); i++){
            

            if(str.charAt(i) != str.charAt(i  - 1)){
                ans += str.charAt(i) + count;
                count = 0;

            }else if(str.charAt(i) != str.charAt(i  - 1) && count == 1){
                ans += (str.charAt(i));
                count = 0;


            }else{
                    count++;
            }
        }
    }
    
}
