class question {
    public static void main(String args[]){
        int arr[] = {9, 5, 6, 10, 3};
        largest(arr);
    }
    public static void largest(int[] arr){

        int first = -(int) 1e9;
        int second = -(int) 1e9;
        int third = -(int) 1e9;

        for(int i = 0; i < arr.length; i++){
            if(arr[i] > third && arr[i] < second) {
                third = arr[i];
            }
            
            if(arr[i] > second && arr[i] < first){
                second = arr[i];
            }
           
            if(arr[i] > first){
                first = arr[i];
            }

        }
        System.out.println(first+ " " +second + " "+ third);

    }
}