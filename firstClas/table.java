import java.util.*;

public class table {
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        table(n);

    }
    public static void table(int n){

        for(int i = 1; i<=n; i++){

            for(int j = 1; j <= 10; j++){

                System.out.println(i + " X " + j + " = " + i * j);

            }
            System.out.println();
        }

    }
    
}
