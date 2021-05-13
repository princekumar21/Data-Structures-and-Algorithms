public class firstIndex {
    public static void main(String[] args) {
        int[] arr = {2, 3, 12, 2, 34, 2, 4, 4, 12 };
        //printReverseArray(arr, 0);
        //System.out.println(maximum(arr, 0));
        //System.out.println(minimum(arr, 0));
        //System.out.println(findData(arr, 0, 2));
        System.out.println(firstIdx(arr, 0, 2));
        //System.out.println(lastIdx(arr, 0, 2));
    }

    public static int firstIdx(int[] arr, int idx, int data) {
        if(idx == arr.length) return -1;
        

        if(arr[idx] == data)  return idx;
        

        return firstIdx(arr, idx + 1, data);

    }
    public static int lastIdx(int[] arr, int idx, int data) {
        if(idx == arr.length) return -1;
        
        lastIdx(arr, idx + 1, data);
       

        if(arr[idx] == data) return idx;
    }
    
}

