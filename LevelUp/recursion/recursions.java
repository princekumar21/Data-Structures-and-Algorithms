public class recursions {
    

    public static int power(int a, int b) {
        if (b == 0) {
            return 1;
        }

        return a * power(a, b - 1);

    }

    // O(logn)
    public static int powerBtr(int a, int b) {
        if(b == 0){
            return 1;
        }

        int ans = a * powerBtr(a, b / 2);
        ans *= ans;

        return b % 2 == 0 ? ans : ans * a;

    }

    public static void printArray(int[] arr, int idx) {
        if (idx == arr.length) {
            System.out.println(arr[idx]);
        }

        System.out.println(arr[idx]);
        printArray(arr, idx + 1);

    }

    public static void printArrayReverse(int[] arr, int idx) {
        if (idx == arr.length) {
            System.out.println(arr[idx]);
            return;
        }

        printArray(arr, idx + 1);
        System.out.println(arr[idx]);

    }

    public static int maximum(int[] arr, int idx) {
        if(idx > arr.length - 1){
            return -(int) 1e9;
        }

        int maxValue = maximum(arr, idx + 1);
        return Math.max(arr[idx], maxValue);
    }

    public static int minimum(int[] arr, int idx) {
        if(idx > arr.length - 1){
            return (int) 1e9;
        }

        int maxValue = maximum(arr, idx + 1);
        return Math.min(arr[idx], maxValue);
    }

    public static boolean find(int[] arr, int data, int idx) {
        if (idx > arr.length) {
            return false;
        }

        return arr[idx] == data || find(arr, data, idx + 1);

    }

    public static int firstIndex(int[] arr, int data, int idx) {
        if(idx >= arr.length){
            return -1;
        }

        if(arr[idx] == data){
            return idx;
        }
        return  firstIndex(arr, data, idx + 1);

        
    }

    public static int lastIndex(int[] arr, int data, int idx) {
        if(idx >= arr.length){
            return -1;
        }

        int ans = lastIndex(arr, data, idx + 1);
        if(ans != -1){
            return ans;
        }

        return arr[idx] == data ? idx : -1;
    }

    public static int[] allIndex(int[] arr, int data, int idx, int count) {
        if(idx >= arr.length){
            return new int[count];
        }


        if(arr[idx] == data)
        count++;

        int[] ans = allIndex(arr, data, idx + 1, count);

        if(arr[idx] == data){
            ans[count - 1] = idx;
        }

        return ans;
        


    }

    public static ArrayList<String> subsequnce(String str,int idx) {

    }

    // public static int subsequnce(String str,int idx,String asf,ArrayList<String> ans) {

    // }

    public static void main(String[] args) {
        int arr[] = {4, 5, 3, 2, 5 ,7};
        // printIncreasing(1, 6);
        // printDecreasing(1,6);
        // printIncreasingDecreasing(1,6);
        // oddEven(1, 7);
        // System.out.println(factorial(6));
        // System.out.println(power(3, 3));
        // System.out.println(find(arr, 10, 0));
        // System.out.println(maximum(arr, 0));
        // System.out.println(lastIndex(arr, 6, 0));
        int[] ans = allIndex(arr, 5, 0, 0);
        for(int i = 0; i < ans.length; i++){
            System.out.println(ans[i]);

        }

    }

}