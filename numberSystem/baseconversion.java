import java.util.*;
public class baseconversion {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int b = sc.nextInt();
        int nb = sc.nextInt();
        int toDecimal = anyBaseToDecimal(n, b);
        int decimalTo = decimalToAnyBase(toDecimal, nb);
        System.out.println(decimalTo);
        
    }
    public static void decimalToBinary(int n){
        int ans = 0;
        int pow = 1;
        while(n != 0){
           int  rem = n % 2;
            ans += rem * pow;
            pow *= 10;
             n /= 2;
        }
        System.out.println(ans);
    }
    public static void binaryToDecimal(int n){
        int ans = 0;
        int pow = 1;
        while(n != 0){
            int rem = n % 10;
            ans += rem * pow;
            pow *= 2;
            n /= 10;

        }
        System.out.print(ans);

    }
    
    public static int anyBaseToDecimal(int n, int b){
        int ans = 0;
        int pow = 1;
        while(n != 0){
            int rem = n % 10;
            ans += rem * pow;
            pow *= b;
            n /= 10;

        }
        return ans;

    }


    
}
