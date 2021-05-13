import java.util.*;
public class prime {
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
       // int n = sc.nextInt();
        //primeornot(n);
        int low = sc.nextInt();
        int high = sc.nextInt();
        primetilln(low, high);

    }
    public static void primeornot(int n){

        int count = 0;

        for(int i = 2; i * i <= n; i++){
            if(n % i == 0){
                count++;
            }
        }
        if(count == 0){
            System.out.println("Prime");
        }else{
            System.out.println("Not Prime");
        }

    }
    public static void primetilln(int low, int high){
        for(int i = low; i <= high; i++){
            int count = 0;
            for(int j = 2; j * j <= i; j++){
                if(i % j == 0){
                    count++;
                }
            }
            if(count == 0){
                System.out.print(i+" ");
            }
        }
        

    }
    
}
