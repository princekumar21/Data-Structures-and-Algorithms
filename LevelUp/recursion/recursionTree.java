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

    public static void main(String[] args) {
        int arr[] = { 2, 3, 5, 7 };
        // infiPermutation(arr, 10, 0, "");
        // infiCombination(arr, 10, 0, 0, "");
        singleCombination(arr, 10, 0, 0, "");
    }
}
