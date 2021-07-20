public class recursions {
    public static void pppppp(int a) {
        System.out.println("I am Base case: " + a);
        return;
    }

    public static void ppppp(int a) {
        System.out.println("hi: " + a);
        pppppp(a + 1);
        System.out.println("Bye: " + a);
    }

    public static void pppp(int a) {
        System.out.println("hi: " + a);
        ppppp(a + 1);
        System.out.println("Bye: " + a);
    }

    public static void ppp(int a) {
        System.out.println("hi: " + a);
        pppp(a + 1);
        System.out.println("Bye: " + a);
    }

    public static void pp(int a) {
        System.out.println("hi: " + a);
        ppp(a + 1);
        System.out.println("Bye: " + a);
    }

    public static void p(int a) {
        System.out.println("hi: " + a);
        pp(a + 1);
        System.out.println("Bye: " + a);
    }

    public static void recursionPattern(int a, int b) {
        if (a == b) {
            System.out.println("I am Base case: " + a);
            return;
        }

        System.out.println("Hi" + a);
        recursionPattern(a + 1, b);
        System.out.println("Bye" + a);
    }

    public static void printIncreasing(int a, int b) {
        if (a == b) {
            System.out.println(a);
            return;
        }

        System.out.println(a);
        printIncreasing(a + 1, b);

    }

    public static void printDecreasing(int a, int b) {
        if (a == b) {
            System.out.println(a);
            return;
        }

        printDecreasing(a + 1, b);
        System.out.println(a);

    }

    public static void printIncreasingDecreasing(int a, int b) {
        if (a == b) {
            System.out.println(a);
            return;
        }

        System.out.println(a);
        printIncreasingDecreasing(a + 1, b);
        System.out.println(a);

    }

    public static void oddEven(int a, int b) {
        if (a == b) {
            System.out.println(a);
            return;
        }

        if (a % 2 != 0) {
            System.out.println(a);
        }

        oddEven(a + 1, b);
        if (a % 2 == 0) {
            System.out.println(a);
        }

    }

    public static int factorial(int n) {
        if(n == 0){
            return 1;
        }

      return n * factorial(n-1);

    }

    public static void power(int a, int b) {

    }

    // // O(logn)
    // public static void powerBtr(int a, int b) {

    // }

    // public static void printArray(int[] arr) {

    // }

    // public static void printArrayReverse(int[] arr) {

    // }

    // public static int maximum(int[] arr) {

    // }

    // public static int minimum(int[] arr) {

    // }

    // public static boolean find(int[] arr, int data) {

    // }

    // public static int firstIndex(int[] arr, int data) {

    // }

    // public static int lastIndex(int[] arr, int data) {

    // }

    public static void main(String[] args) {
        // printIncreasing(1, 6);
        // printDecreasing(1,6);
        // printIncreasingDecreasing(1,6);
        // oddEven(1, 7);
        System.out.println(factorial(6));

    }

}