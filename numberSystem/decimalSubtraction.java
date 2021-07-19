import java.util.*;
public class decimalSubtraction {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int n1 = sc.nextInt();
        int n2 = sc.nextInt();
        int b = sc.nextInt();
        System.out.print(anyBaseSubtraction(n1, n2, b));
    
    }
    public static int decimalsubtraction(int n1, int n2, int b){
        int carry = 0;
        int pow = 1;
        int ans = 0;

        while(n2 != 0){
            int rem2 = n1 != 0 ? n1 % 10 : 0;
            int rem1 = n2 % 10;

            if((carry + rem1) < rem2){
                int diff = 10 + (carry + rem1) - rem2;
                ans += diff * pow;
                carry = -1;
                pow *= 10;
            }else {
                ans += (carry + (rem1 - rem2)) * pow;
                carry = 0;
                pow *= 10;
            }

            n1 /= 10;
            n2 /= 10; 
        }
        return ans;

    }
    
}
