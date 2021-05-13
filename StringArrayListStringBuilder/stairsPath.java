import java.util.*;
public class stairsPath {
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        //System.out.println(getStrairsPath(n));
        System.out.println(boardPath(n));
    }
    public static ArrayList<String> getStrairsPath(int n){
        if(n == 0){
            ArrayList<String> base = new ArrayList<String>();
            base.add("");
            return base;
        }
        
        ArrayList<String> myAns = new ArrayList<String>();
        for(int i = 1; i  <= 3 && n - i >= 0 ; i++){
            ArrayList<String> path1 = getStrairsPath(n - i);
            
            for(String p1 : path1){
                myAns.add(i + p1);
            }
           
        }
        
        return myAns;
       

       



    }
    public static ArrayList<String> boardPath(int n){
        if(n == 0){
            ArrayList<String> base = new ArrayList<String>();
            base.add("");
            return base;
        }
        
        ArrayList<String> myAns = new ArrayList<String>();
        for(int i = 1; i  <= 6 && n - i >= 0 ; i++){
            ArrayList<String> path1 = boardPath(n - i);
            
            for(String p1 : path1){
                myAns.add(i + p1);
            }
           
        }
        
        return myAns;
       

       



    }
    
}
