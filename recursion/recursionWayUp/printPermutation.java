import java.util.*;
public class printPermutation {

    //permutation with repetition
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

    public static int countprintpermutation(String str, String ans){

        if(str.length() == 0){
            System.out.println(ans);
            return 1;
        }
        int count = 0;
        for(int i = 0; i < str.length(); i++){
            char ch = str.charAt(i);
            String roq = str.substring(0, i) + str.substring(i + 1);

            count += countprintpermutation(roq, ans + ch);

        }

        return count;
        


    }
    
    //permutation without repetition
    public static void permutationNoRepetition(String str, String ans){
        if(str.length() == 0){
            System.out.println(ans);
        }
        
        char prev = '$';
        for(int i = 0; i < str.length(); i++){

            if(str.charAt(i) != prev ){
                char ch = str.charAt(i);
                String roq = str.substring(0, i) +  str.substring(i + 1);
                permutationNoRepetition(roq, ans + ch);

            }

            prev = str.charAt(i);
            
        }
        
    }

    //permutation with repetition
    public static void permutationNoRepetition(String str){
        //first we will sort the string by storing it in freq array and then we will change it to string

        StringBuilder sb = new StringBuilder();

        int freq[] = new int[26];
        for(int i = 0; i < str.length(); i++){
           int alphabetIndex = str.charAt(i) - 'a';
            freq[alphabetIndex]++;
        }
        
        //appended the char to sb from freq array
        for(int i = 0; i < freq.length; i++){
            for(int j = 0; j < freq[i]; j++){
                sb.append((char)(i + 'a'));              
            }
        }
        
        
        permutationNoRepetition(sb.toString(), "");
        
        


    }
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        //String ans = "";
        printpermutation(str, "");
        //permutationNoRepetition(str);


    }
}
