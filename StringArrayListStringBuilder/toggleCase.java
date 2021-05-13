import java.util.*;
public class toggleCase {
    public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		String str = scn.next();
		System.out.println(toggleCase(str));
	}
    public static String toggleCase(String str){
		StringBuilder sb = new StringBuilder();

        for(int i = 0; i < sb.length(); i++){
            char ch = sb.charAt(i);

            if(ch >= 'a' && ch <= 'z'){
               char chu = (char)(ch + 'A' - 'a'); 
               sb.setCharAt(i, chu);
            }else{
                char chara = (char)(ch + 'a' - 'A');
                sb.setCharAt(i, chara); 
            }

        }
        return sb.toString();
		
		

		
	}
    
}
