import java.util.*;
public class removePrime {
    public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int n = scn.nextInt();
		ArrayList<Integer> al = new ArrayList<>();
		for(int i = 0 ; i < n; i++){
			al.add(scn.nextInt());
		}
		solution(al);
		
	}
    public static void solution(ArrayList<Integer> al){
        ArrayList<Integer> ans = new ArrayList<>();

        for(int i = 0; i < al.size(); i++){
            
            if(!isPrime(al, i)) {
                ans.add(al.get(i));
                
            }
            
        }
        System.out.print(ans);

    }
    public static boolean isPrime(ArrayList<Integer> al, int j){
        int n = al.get(j);
       
        for(int i = 2; i * i <= n; i++){

            if(n % i == 0){
                return false;
            }
        
    
        }
        return true;
    }
    public static void solution2(ArrayList<Integer> al){
        

        for(int i = al.size() - 1; i >= 0; i--){
            
            if(isPrime(al, i)) {
                al.remove(i);
                
            }
            
        }
        System.out.print(al);

    }
}
