public class bst {
    public static class Node {
        int data;
        Node left;
        Node right;

        Node(int data, Node left, Node right) {
            this.data = data;
            this.left = left;
            this.right = right;
        }

        Node(int data) {
            this(data, null, null);
        }

    }

    static Node prev = null;

    public static boolean isBST(Node root) {
        if (root == null)
            return true;

        if (!isBST(root.left))
            return false;

        if (prev != null && prev.data >= root.data)
            return false;
        prev = root;

        if (!isBST(root.right))
            return false;

        return true;

    }

    public static class isBSTPair {
        boolean isBst = true;
        long maxEle = -(long) 1e18;
        long minEle = (long) 1e18;
    }

    public static isBSTPair isBST_02(Node root) {
        if (root == null) {
            return new isBSTPair();
        }

        isBSTPair left = isBST_02(root.left);
        if (!left.isBst) {
            return left;
        }

        isBSTPair right = isBST_02(root.right);
        if (!right.isBst) {
            return right;
        }

        isBSTPair self = new isBSTPair();
        self.isBst = false;
        if (left.maxEle < root.data && right.minEle > root.data) {
            self.maxEle = Math.max(right.maxEle, root.data);
            self.minEle = Math.min(left.minEle, root.data);
            self.isBst = true;

        }
        return self;

    }

    
}
