import java.util.*;
public class printPermutation {

    //permutation without repetition
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
    //permutation with repetation
    public static int countprintpermutationNoRepetition(String str, String ans){

        if(str.length() == 0){
            System.out.println(ans);
            return 1;
        }
        int count = 0;

        char cha = '$';
        for(int i = 0; i < str.length(); i++){

            
            
            if(str.charAt(i) != cha){

                char ch = str.charAt(i);
                String roq = str.substring(0, i) + str.substring(i + 1);
                count += countprintpermutationNoRepetition(roq, ans + ch);


            }

            cha = str.charAt(i);
            

        }

        return count;
        


    }
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        String ans = "";
        //printpermutation(str, ans);
        System.out.println(countprintpermutationNoRepetition(str, ans));


    }
}
