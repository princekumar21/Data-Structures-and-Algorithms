import java.util.Scanner;
import java.util.ArrayList;
public class arrayList {
    public static Scanner sc = new Scanner(System.in);
    public static void main(String args[]){
        removeData();
        

    }
    public static void removeData(){
        ArrayList<Integer> al = new ArrayList<>();
        for(int i = 0; i < 15; i++){

            Integer n = sc.nextInt();
            al.add(n);

        }
        Integer data = sc.nextInt();

        removeOt(al, data);


    }
    public static void removeOt(ArrayList<Integer> arr, int data){
        for(int i = 0; i < arr.size(); i++){
            if(arr.get(i) == data){
                arr.remove(i);
            }
        }
        System.out.println(arr);

    }
    
    
}
