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

        return true;

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
}