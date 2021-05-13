import java.util.*;
public class anyBaseMultiplication {
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
            int n1 = sc.nextInt();
            int n2 = sc.nextInt();
            int b = sc.nextInt();
            mult(n1, n2, b);
            
    
        }
        public static void mult(int n1, int n2, int b){
            int pow = 1;
            int ans = 0;
            
            while(n2 != 0){
                //int rem = n2 % 10; i reduced this 
                
                int prod = (multiplication(n1, n2 % 10, b) * pow);
                
                //int pro = prod * pow; and also this
                
                ans = getSum(ans, prod, b);
                n2 /= 10;
                pow *= 10;
            }
            System.out.print(ans);
        } 
        public static int getSum(int n1, int n2, int b){
            int pow  = 1;
            int ans = 0;
            int carry = 0;
            
            while(n1 > 0 || n2 > 0 || carry > 0){
                
                int rem1 = n1 % 10;
                int rem2 = n2 % 10;
                
                int rem3 = carry + rem1 + rem2;
                
                ans += (rem3 % b) * pow;
                carry = rem3 / b;
               
                pow *=10;
                
                
                n1 /= 10;
                n2 /= 10;
                
            }
            return ans;
      }
    
    
    public static int multiplication(int n1, int n2, int b){
        int ans = 0;
        int pow = 1; 
        int carry = 0;
    
        while(n1 != 0 || carry  > 0){
            
            int rem = n1 > 0 ? n1 % 10 : 0;
            int prod =  carry + (rem * n2);
            int mult = prod % b;
            ans += mult * pow;
            
            carry = prod / b;
    
            pow *= 10;
            n1 /= 10;
            
            
        }
        return ans;
    
    
    }


}

