public class NqueenSet {

    public static boolean isSafeToPlaceQueen(boolean box[][], int sr, int sc) {
        int dir[][] = { { -1, 0 }, { 0, -1 }, { -1, -1 }, { -1, 1 } };
        int n = box.length, m = box[0].length;
        for (int d = 0; d < dir.length; d++) {
            for (int rad = 1; rad <= n; rad++) {
                int r = sr + (rad * dir[d][0]);
                int c = sc + (rad * dir[d][1]);
                if (r >= 0 && c >= 0 && r < n && c < m) {
                    if (box[r][c]) {
                        return false;
                    }
                } else {
                    break;
                }
            }
        }

        return true;

    }

    public static int Nqueen_01(boolean box[][], int tnq, int bno, String asf) {
        int n = box.length, m = box[0].length;
        if (tnq == 0) {
            System.out.println(asf);
            return 1;
        }

        int count = 0;
        for (int b = bno; b < m * n; b++) {
            int r = b / m;
            int c = b % m;
            if (isSafeToPlaceQueen(box, r, c)) {
                box[r][c] = true;
                count += Nqueen_01(box, tnq - 1, b + 1, asf + "(" + r + "," + c + ") ");
                box[r][c] = false;

            }
        }

        return count;

    }

    public static void main(String args[]) {
        boolean box[][] = new boolean[4][4];
       System.out.println( Nqueen_01(box, 4, 0, ""));
    }
}
