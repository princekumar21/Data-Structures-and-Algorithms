import java.util.*;

public class practiseRecurTree {
    // this is also a permutation means we acn a make a choice use coins repeatidily
    public static int InfiCoinsPerm(int[] arr, int tar, String asf) {
        if (tar == 0) {
            System.out.println(asf);
            return 1;
        }
        int count = 0;
        for (int i = 0; i < arr.length; i++) {
            if (tar - arr[i] >= 0) {
                count += InfiCoinsPerm(arr, tar - arr[i], asf + i + " ");

            }
        }
        return count;

    }

    // this is ncr methood
    public static int unlimitCoinsCombination(int arr[], int tar, String asf, int idx) {
        if (tar == 0) {
            System.out.println(asf);
            return 1;
        }
        int count = 0;
        for (int i = idx; i < arr.length; i++) {
            if (tar - arr[i] >= 0) {

                count += unlimitCoinsCombination(arr, tar - arr[i], asf + arr[i], i);

            }

        }
        return count;

    }

    public static int limitCoinsCombination(int arr[], int tar, String asf, int idx) {
        if (tar == 0) {
            System.out.println(asf);
            return 1;
        }
        int count = 0;
        for (int i = idx; i < arr.length; i++) {
            if (tar - arr[i] >= 0) {

                count += limitCoinsCombination(arr, tar - arr[i], asf + arr[i], i + 1);

            }

        }
        return count;

    }

    public static int limitedCoinsPerm(int[] arr, int tar, String asf, int idx) {
        if (tar == 0) {
            System.out.println(asf);
            return 1;
        }
        int count = 0;
        for (int i = idx; i < arr.length; i++) {
            if (tar - arr[i] >= 0) {
                count += limitedCoinsPerm(arr, tar - arr[i], asf + arr[i] + " ", i + 1);

            }
        }
        return count;

    }

    public static void combinationsum(int[] candidate, int target, int idx, List<List<Integer>> ans,
            List<Integer> smallAns) {

        if (target == 0) {
            List<Integer> base = new ArrayList<>(smallAns); // deep copy
            ans.add(base); // shallow copy
            return;
        }
        for (int i = idx; i < candidate.length; i++) {
            if (target - candidate[i] >= 0) {
                smallAns.add(candidate[i]);
                combinationsum(candidate, target - candidate[i], i, ans, smallAns);
                smallAns.remove(smallAns.size() - 1);

            }
        }
    }

    public static List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<Integer> smallAns = new ArrayList<>();
        List<List<Integer>> ans = new ArrayList<>();

        combinationsum(candidates, target, 0, ans, smallAns);

        return ans;
    }

    public static int singlePermutation(int arr[], int target, String ans) {
        if (target == 0) {
            System.out.println(ans);
            return 1;
        }
        int count = 0;
        for (int i = 0; i < arr.length; i++) {

            if (arr[i] > 0 && target - arr[i] >= 0) {
                int val = arr[i];
                arr[i] = -arr[i];
                count += singlePermutation(arr, target - val, ans + val);
                arr[i] = -arr[i];
            }
        }
        return count;
    }

    public static int singleCombination_subset(int arr[], int tar, int idx, String ans) {
        if (tar == 0 || idx >= arr.length) {
            if (tar == 0) {
                System.out.println(ans);
                return 1;
            }
            return 0;
        }
        int count = 0;
        if (tar - arr[idx] >= 0) {
            count += singleCombination_subset(arr, tar, idx + 1, ans);
            count += singleCombination_subset(arr, tar - arr[idx], idx + 1, ans + arr[idx]);
        }

        return count;
    }

    public static int infiCombination_subset(int arr[], int tar, int idx, String ans) {
        if (tar == 0 || idx >= arr.length) {
            if (tar == 0) {
                System.out.println(ans);
                return 1;
            }
            return 0;
        }
        int count = 0;
        if (tar - arr[idx] >= 0) {
            count += infiCombination_subset(arr, tar, idx + 1, ans);
            count += infiCombination_subset(arr, tar - arr[idx], idx, ans + arr[idx]);
        }

        return count;
    }

    public static int infiPermutation_subset(int arr[], int tar, int idx, String ans) {
        if (tar == 0 || idx >= arr.length) {
            if (tar == 0) {
                System.out.println(ans);
                return 1;
            }
            return 0;
        }
        int count = 0;
        if (tar - arr[idx] >= 0) {
            count += infiCombination_subset(arr, tar - arr[idx], 0, ans + arr[idx]);
            count += infiCombination_subset(arr, tar, idx + 1, ans);
        }

        return count;
    }

    // Queen Set
    // -----------------------------------------------------------------------------------

    public static int queenCombination1D(int tnb, int bno, int tnq, int qpsf, String asf) {

        if (qpsf == tnq) {
            System.out.println(asf);
            return 1;
        }

        int count = 0;

        for (int b = bno; b <= tnb; b++) {

            count += queenCombination1D(tnb, b + 1, tnq, qpsf + 1, asf + b);

        }

        return count;
    }

    public static int queenCombination1D_subsequence(int tnb, int bno, int tnq, int qpsf, String asf) {

        if (qpsf > tnq || bno > tnb) {
            if (qpsf > tnq) {
                System.out.println(asf);
                return 1;
            }
            return 0;
        }

        int count = 0;

        count += queenCombination1D_subsequence(tnb, bno + 1, tnq, qpsf, asf);
        count += queenCombination1D_subsequence(tnb, bno + 1, tnq, qpsf + 1, asf + bno);

        return count;
    }

    public static int queenPermutation1D(int tnb, int tnq, boolean vis[], int qpsf, String asf) {
        if (qpsf > tnq) {
            System.out.println(asf);
            return 1;
        }
        int count = 0;
        for (int b = 1; b <= tnb; b++) {
            if (!vis[b]) {
                vis[b] = true;
                count += queenPermutation1D(tnb, tnq, vis, qpsf + 1, asf + "bn" + b + "q" + qpsf + " ");
                vis[b] = false;
            }
        }
        return count;

    }

    public static int queenPermutation1D_subsequence(int tnb, int tnq, int bno, boolean vis[], int qpsf, String asf) {
       if(qpsf > tnq || bno > tnb){
           if(qpsf > tnq){
               System.out.println(asf);
               return 1;
           }
           return 0;
        }
        int count = 0;
        
            if (!vis[bno]) {
                vis[bno] = true;
                count += queenPermutation1D_subsequence(tnb, tnq, bno + 1, vis, qpsf + 1, asf + "bn" + bno + "q" + qpsf + " ");
                vis[bno] = false;
            }
            count += queenPermutation1D_subsequence(tnb, tnq, bno + 1, vis, qpsf, asf);
        return count;

    }

    2D Queen set

    public static void main(String[] args) {
        int arr[] = { 2, 3, 5, 7 };
        // boolean vis[] = new boolean[arr.length];
        // InfiCoins(arr, 10, "");
        // combinationSum(arr, 10);
        // singlePermutation(arr, 10, "");
        // singleCombination_subset(arr, 10, 0, "");
        // infiCombination_subset(arr, 10, 0, "");
        // infiPermutation_subset(arr, 10, 0, "");
        // queenCombination1D(6, 0, 4, 0, "");
        boolean vis[] = new boolean[7];
        // queenPermutation1D(3, 2, vis, 1, "");
        // queenCombination1D_subsequence(6, 1, 4, 1, "");
        // queenPermutation1D(6, 4, vis, 1, "");
        queenPermutation1D_subsequence(6, 4, 1, vis, 1, "");
    }
}
