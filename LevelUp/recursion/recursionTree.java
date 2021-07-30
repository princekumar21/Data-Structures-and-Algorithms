import java.util.ArrayList;
public class recursionTree {
    public static int infiPermutation(int coins[], int tar, int count, String psf) {
        if (tar == 0) {
            System.out.println(psf);
            return 1;

        }

        for (int i = 0; i < coins.length; i++) {
            if (tar - coins[i] >= 0) {
                count += infiPermutation(coins, tar - coins[i], count + 1, psf + coins[i]);
            }
        }

        return count;

    }

    public static int infiCombination(int coins[], int tar, int count, int idx, String psf) {
        if (tar == 0) {
            System.out.println(psf);
            return 1;
        }

        for (int i = idx; i < coins.length; i++) {
            if (tar - coins[i] >= 0) {

                count += infiCombination(coins, tar - coins[i], count, i, psf + coins[i]);

            }
        }
        return count;

    }

    public static int singleCombination(int coins[], int tar, int count, int idx, String psf) {
        if (tar == 0) {
            System.out.println(psf);
            return 1;
        }

        for (int i = idx; i < coins.length; i++) {
            if (tar - coins[i] >= 0) {
                count += singleCombination(coins, tar, count, i + 1, psf + coins[i]);
            }
        }
        return count;
    }

    public static int singlePermutation(int coins[], int tar, int count, String psf, boolean vis[]) {
        if (tar == 0) {
            System.out.println(psf);
            return 1;

        }

        for (int i = 0; i < coins.length; i++) {
           

            if (!vis[i] && tar - coins[i] >= 0) {
                vis[i] = true;
                count += singlePermutation(coins, tar - coins[i], count + 1, psf + coins[i], vis);
                vis[i] = false;
            }
        }

        return count;

    }
    public static int singleCombination_subseq(int[] coins, int tar, int idx, String asf) {
        if (tar == 0 || idx >= coins.length) {
            if (tar == 0) {
                System.out.println(asf);
                return 1;
            }
            return 0;
        }

        int count = 0;
        if (tar - coins[idx] >= 0)
            count += singleCombination_subseq(coins, tar - coins[idx], idx + 1 , asf + coins[idx] + " ");
        count += singleCombination_subseq(coins, tar, idx + 1, asf);

        return count;
    }

    public static int infiCombination_subseq(int[] coins, int tar, int idx, String asf) {
        if (tar == 0 || idx >= coins.length) {
            if (tar == 0) {
                System.out.println(asf);
                return 1;
            }
            return 0;
        }

        int count = 0;
        if (tar - coins[idx] >= 0)
            count += infiCombination_subseq(coins, tar - coins[idx], idx , asf + coins[idx] + " ");
        count += infiCombination_subseq(coins, tar, idx + 1, asf);

        return count;
    }

    public static int infiPermutation_subseq(int[] coins, int tar,int idx, String asf) {
        if (tar == 0 || idx >= coins.length) {
            if (tar == 0) {
                System.out.println(asf);
                return 1;
            }
            return 0;
        }

        int count = 0;
        if (tar - coins[idx] >= 0)
            count += infiPermutation_subseq(coins, tar - coins[idx], 0 , asf + coins[idx] + " ");
        count += infiPermutation_subseq(coins, tar, idx + 1, asf);

        return count;
    }

    public static int singlePermutation_subseq(int[] coins, int tar, boolean[] vis,int idx String asf) {
        if (tar == 0 || idx >= coins.length) {
            if (tar == 0) {
                System.out.println(asf);
                return 1;
            }
            return 0;
        }

        int count = 0;
        if (tar - coins[idx] >= 0){
           
            vis[idx] = true;
            count += infiPermutation_subseq(coins, tar - val, 0 , asf + coins[idx] + " ");
            vis[idx] = false;
        }

        if (!vis[idx]){
           
            vis[idx] = true;
            count += infiPermutation_subseq(coins, tar, 0 , asf + coins[idx] + " ");
            vis[idx] = false;
        }
            
            
       

        return count;
    }

    public ArrayList<ArrayList<Integer>> subset(ArrayList<Integer> A, ArrayList<Integer> Smallans,  ArrayList<ArrayList<Integer>> ans,int idx){
        if(idx == A.size()){
            ans.add(Smallans);
            return ans;

        }

        int val = A[idx];
        subset(A,Smallans.add(val) , idx + 1 );
        subset(A, Smallans, idx  +1);
        Smallans.remove(Smallans.size() - 1);

        return ans;

    }

    public ArrayList<ArrayList<Integer>> subsets(ArrayList<Integer> A) {
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
       ArrayList<Integer> Smallans = new ArrayList<>();

        subset(A, Smallans, ans, 0);

        return ans;
    }

    public static void main(String[] args) {
        // int arr[] = { 1,2,3};
        ArrayList<Integer> A = new ArrayList<>();
        A.add(1);
        A.add(2);
        A.add(3);

        // infiPermutation(arr, 10, 0, "");
        // infiCombination(arr, 10, 0, 0, "");
        // singleCombination(arr, 10, 0, 0, "");
       subsets(A);
        
    }
}
