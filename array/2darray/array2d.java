import java.util.*;
public class array2d {
    public static Scanner sc = new Scanner(System.in);
    public static void main(String args[]){
        
        int n = sc.nextInt();
       // int m = sc.nextInt();
        //int data = sc.nextInt();
        int arr[][] = new int[n][n];
        
        input(arr);
        int find = sc.nextInt();
        searchInMatrix(arr, find);



    }
    public static void input(int arr[][]){
        for(int n = 0; n < arr.length; n++){
            for(int m = 0; m < arr[0].length; m++){
                arr[n][m] = sc.nextInt();
            }

        }
    }
    public static void display(int arr[][]){
        for(int n = 0; n < arr.length; n++){
            for(int m = 0; m < arr[0].length; m++){
                System.out.print(arr[n][m]);
            }

        }
    }
    public static int maximum(int arr[][]){
        int max = -(int)1e9;
        for(int n = 0; n < arr.length; n++){
            for(int m = 0; m < arr[0].length; m++){
                if(arr[n][m] > max){
                    max = arr[n][m];
                }
            }

        }
        return max;
    }
    public static int minimum(int arr[][]){
        int min = (int)1e9;
        for(int n = 0; n < arr.length; n++){
            for(int m = 0; m < arr[0].length; m++){
                if(arr[n][m] < min){
                    min = arr[n][m];
                }
            }

        }
        return min;
    }
    public static boolean searchData(int arr[][], int data){
        
        for(int n = 0; n < arr.length; n++){
            for(int m = 0; m < arr[0].length; m++){
                if(arr[n][m] == data){
                    return true;
                }
            }

        }
        return false;
        
    }
    public static void wave(int arr[][]){
        int n = arr.length;
        int m = arr[0].length;
        for(int i= 0; i < n; i++){
            for(int j = 0; j < m; j++){
                

                
            }

        }

    }
    public static void spiral(int[][] arr){
        int n = arr.length; int m = arr[0].length;
        int rmin = 0; int rmax = n - 1; int cmin = 0; int cmax = m - 1;

        int tlc = m * n;

        while(tlc > 0){

            for(int i = rmin; i <= rmax && tlc > 0; i++){

                System.out.print(arr[i][cmin] + " ");
                tlc--;
                
            }
            cmin++;

            for(int i = cmin; i <= cmax && tlc > 0; i++){

                System.out.print(arr[rmax][i] + " ");
                tlc--;
                
            }
            rmax--;

            for(int i = rmax; i >= rmin && tlc > 0; i-- ){

                System.out.print(arr[i][cmax]+ " ");
                tlc--;
                
            }
            cmax--;

            for(int i = cmax; i >= cmin && tlc > 0; i--){
                System.out.print(arr[rmin][i] + " ");
                tlc--;
                
            }
            rmin++;
        }



    }
    
    public static void exitPoint(int arr[][]){
        
            int n = arr.length - 1;
            int m = arr[0].length - 1;
            
            int dir = 0;
            int i = 0;
            int j = 0;
            
            while(true){
                dir = (dir + arr[i][j]) % 4;
                
                if(dir == 0){
                    j++;
                    if(j > m){
                        System.out.println(i);
                        System.out.println((j - 1));
                        break;
                    }
                    
                    
                    
                }else if(dir == 1){
                    i++;
                    if(i > n){
                        System.out.println((i - 1));
                        System.out.println(j);
                        break;
                    }
                    
                    
                }else if(dir == 2){
                    j--;
                    if(j < 0){
                        System.out.println(i);
                        System.out.println(j + 1);
                        break;
                    }
                    
                    
                }else if(dir == 3){
                    i--;
                    if(i < 0){
                        System.out.println(i + 1);
                        System.out.println(j);

                        break;
                    }
                    
                    
                }
                
            }
            
        }
        public static void saddlePoint(int arr[][]){
            int n = arr.length;
            boolean flag = false;
            for(int i = 0; i < n; i++){

                int max = -(int)1e9;
                int min = (int)1e9;
                int r = 0;
                int c = 0;
               
                
                for(int j = 0; j < n; j++){
                   if(arr[i][j] < min){
                       min = arr[i][j];
                       c = j;
                       //System.out.println(c+ "in min");
                    
                   }
                }
            
                for(int j = 0; j < n; j++){
                    //System.out.println(c + "in max");
                   if(arr[j][c] > max){
                       
                       max = arr[j][c];
                       r = j;
                   }

                }
                //System.out.println(r + "r");
                //System.out.println(c + "c");
                if(r == i){
                    System.out.println(arr[r][c]);
                    flag = true;
                }
                


            }
            if(flag == false){
                System.out.println("Invalid input");
            }

    }
    public static void swap(int arr[][] , int i, int j, int m, int n){
        int temp = arr[i][j];
        arr[i][j] = arr[m][n];
        arr[m][n] = temp;
        
    }
    public static void reverse(int arr[][], int i, int si, int j, int ei ){

        while(si < ei){
            int temp = arr[i][si];
            arr[i][si] = arr[j][ei];
            arr[j][ei] = temp;
            si++;
            ei--;
        }
        
    }
    public static void rotateBy90(int arr[][]){
        int n = arr.length;
        int m = arr[0].length;
        for(int i = 0; i < n; i++){
            for(int j = i; j < m; j++){
                swap(arr, i, j, j, i);
            }
        }

        for(int i = 0; i < n; i++){
            int si = 0;
            int ei = m - 1;

            reverse(arr, i, si, i, ei);

        }
        display1(arr);
        


    }
    public static void searchInMatrix(int arr[][], int find){
        int n = arr.length - 1;
        int m = arr[0].length - 1;

        int i = 0; 
        int j = m;

        while( i <= n && j >= 0){

            if(find == arr[i][j]){
                System.out.println(i + " "+ j);
                return;
            }else if(find > arr[i][j]){
                i++;
            }else if(find < arr[i][j]){
                j--;
            }

        }
        System.out.println("Not Found");

    }
    public static void display1(int[][] arr){
        for(int i = 0; i < arr.length; i++){
            for(int j = 0; j < arr[0].length; j++){
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }

    
}
