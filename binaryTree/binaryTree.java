import java.util.ArrayList;

public class binaryTree {
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

    public static void preOrder(Node root, ArrayList<Integer> ans) {
        if (root == null) {
            return;
        }

        ans.add(root.data);
        preOrder(root.left, ans);
        preOrder(root.right, ans);

    }

    public static void inOrder(Node root, ArrayList<Integer> ans) {
        if (root == null) {
            return;
        }

        ans.add(root.data);
        inOrder(root.left, ans);
        inOrder(root.right, ans);
    }

    public static void postOrder(Node root, ArrayList<Integer> ans) {
        if (root == null) {
            return;
        }

        postOrder(root.left, ans);
        postOrder(root.right, ans);
        ans.add(root.data);
    }

    public static int size(Node node) {
        if (node == null) {
            return 0;
        }

        int leftSize = size(node.left);
        int rightSize = size(node.right);

        return leftSize + rightSize + 1;
        // return node == null ? 0 : size(node.left) + size(node.right) + 1;
    }

    public static int sum(Node node) {
        if (node == null)
            return 0;

        int leftSum = sum(node.left);
        int rightSum = sum(node.right);

        return leftSum + rightSum + node.data;

        // return node == null ? 0 : sum(node.left) + sum(node.right) + node.data;
    }

    public static int max(Node node) {
        if (node == null) {
            return -(int) 1e9;
        }

        int leftMax = max(node.left);
        int rightMax = max(node.right);

        return Math.max(node.data, Math.max(leftMax, rightMax));

        // return node == null ? -(int) 1e9 : Math.max(node.data,
        // Math.max(max(node.left), max(node.right)));

    }

    public static int height(Node node) {
        if (node == null) {
            return -1;
        }

        int leftHeight = height(node.left);
        int rightHeight = height(node.right);

        return Math.max(leftHeight, rightHeight) + 1;

    }

    public static int countLeaves(Node node) {
        if (node == null) {
            return 0;
        }

        if (node.right == null && node.left == null) {
            return 1;
        }

        return countLeaves(node.left) + countLeaves(node.right);
    }

    public static void exactlyOneChild(Node node, ArrayList<Integer> ans) {
        if (node == null || (node.left == null && node.right == null)) {
            return;
        }

        if (node.left == null || node.right == null) {
            ans.add(node.data);
        }

        exactlyOneChild(node.left, ans);
        exactlyOneChild(node.right, ans);

    }

    public static boolean findData(Node node, int data) {
        if (node == null) {
            return false;
        }

        if (node.data == data) {
            return true;
        }

        return findData(node.left, data) || findData(node.right, data);
    }

    public static boolean nodeToRootPath(Node node, int data, ArrayList<Node> ans) {
        if (node == null) {
            return false;
        }
        if (node.data == data) {
            ans.add(node);
            return true;
        }

        boolean res = nodeToRootPath(node.left, data, ans) || nodeToRootPath(node.right, data, ans);
        if (res) {
            ans.add(node); 
            return true;
        }

        return false;

    }

    public static ArrayList<Node> nodeToRootPath(Node root, int data) {
        ArrayList<Node> ans = new ArrayList<>();
        nodeToRootPath(root, data, ans);
        return ans;
    }

    public static ArrayList<Node> nodeToRootPath02_(Node node, int data) {
        if (node == null) {
            return null;
        }

        if (node.data == data) {
            ArrayList<Node> ans = new ArrayList<>();
            ans.add(node);
            return ans;

        }
        ArrayList<Node> left = nodeToRootPath02_(node.left, data);
        if (left != null) {
            left.add(node);
            return left;
        }
        ArrayList<Node> right = nodeToRootPath02_(node.right, data);
        if (right != null) {
            right.add(node);
            return right;
        }

        return null;
    }

    public static ArrayList<Node> nodeToRootPath02(Node node, int data) {
        ArrayList<Node> ans = nodeToRootPath02_(node, data);
        return ans != null ? ans : new ArrayList<>();

    }

    public static void kLevelsDown(Node node, int k, ArrayList<Integer> ans) {

        if (node == null || k < 0) {
            return;
        }

        if (k == 0) {
            ans.add(node.data);
            return;
        }

        kLevelsDown(node.left, k - 1, ans);
        kLevelsDown(node.right, k - 1, ans);
    }

    public static void kLevelsDown(Node node, int k, Node block, ArrayList<Integer> ans) {

        if (node == null || k < 0 || node == block) {
            return;
        }

        if (k == 0) {
            ans.add(node.data);
            return;
        }

        kLevelsDown(node.left, k - 1, block, ans);
        kLevelsDown(node.right, k - 1, block, ans);
    }

    public static ArrayList<Integer> kAway(Node node, int data, int k) {
        ArrayList<Node> ans = new ArrayList<>();
        nodeToRootPath(node, data, ans);

        ArrayList<Integer> res = new ArrayList<>();
        Node block = null;
        for (int i = 0; i < ans.size(); i++) {
            kLevelsDown(ans.get(i), k - i, block, res);
            block = ans.get(i);

        }

        return res;

    }
    public static int kaway2(Node node, int data, int k, ArrayList<Integer> ans) {
        if (node == null)
            return -1;

        if (node.data == data) {
            kLevelsDown(node, k, null, ans);
            return 1;
        }

        int ld = kaway2(node.left, data, k, ans);
        if (ld != -1) {
            kLevelsDown(node, k - ld, node.left, ans);
            return ld + 1;
        }

        int rd = kaway2(node.right, data, k, ans);
        if (rd != -1) {
            kLevelsDown(node, k - rd, node.right, ans);
            return rd + 1;
        }

        return -1;
    }

    public static class isBSTPair {
        boolean isBST = true;
        int maxEle = -(int) 1e9;
        int minEle = (int) 1e9;
    }   

    public static isBSTPair isBST_02(Node node) {
        if (node == null)
            return new isBSTPair();

        isBSTPair left = isBST_02(node.left);
        if (!left.isBST)
            return left;

        isBSTPair right = isBST_02(node.right);
        if (!right.isBST)
            return right;

        isBSTPair self = new isBSTPair();
        self.isBST = false;

        if (left.maxEle < node.data && right.minEle > node.data) {
            self.maxEle = Math.max(right.maxEle, node.data);
            self.minEle = Math.min(left.minEle, node.data);
            self.isBST = true;
        }

        return self;
    }

    public static int heightH(Node node){
        return node != null ? Math.max(heightH(node.left), heightH(node.right)) + 1 : -1;

    }
    public static boolean isBalance(Node node){
        if(node == null){
            return true;
        }

        boolean left = isBalance(node.left);
        boolean right = isBalance(node.right);

       int lheight = heightH(node.left);
       int rheight = heightH(node.right);

       int diff = (Math.abs(lheight - rheight));
       if(diff > 1){
           return false;
       }

       return true;



    }

   
}