import java.lang.reflect.Array;
import java.util.ArrayList;

public class binartTreePrac {
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
        if (root == null)
            return;

        ans.add(root.data);
        preOrder(root.left, ans);
        preOrder(root.right, ans);

    }

    public static void inOrder(Node root, ArrayList<Integer> ans) {
        if (root == null)
            return;

        preOrder(root.left, ans);
        ans.add(root.data);
        preOrder(root.right, ans);

    }

    public static void postOrder(Node root, ArrayList<Integer> ans) {
        if (root == null)
            return;

        preOrder(root.left, ans);
        preOrder(root.right, ans);
        ans.add(root.data);

    }

    public static int countLeaves(Node node) {
        if (node == null)
            return 0;
        if (node.left == null && node.right == null)
            return 1;

        return countLeaves(node.left) + countLeaves(node.right);
    }

    public static void exactlyOneChild(Node root, ArrayList<Integer> ans) {
        if (root == null || (root.left == null && root.right == null))
            return;
        if (root.left == null || root.right == null) {
            ans.add(root.data);

        }

        exactlyOneChild(root.left, ans);
        exactlyOneChild(root.right, ans);

    }

    public static int countExactlyOneChild(Node root, int count) {
        if (root == null || (root.left == null && root.right == null))
            return 0;

        int leftCount = countExactlyOneChild(root.left, count);
        int rightCount = countExactlyOneChild(root.right, count);
        int sum = leftCount + rightCount;
        if (root.left == null || root.right == null) {
            sum += 1;
        }
        return sum;

    }

    public static boolean isNodePresent(Node node, int data) {
        if (node == null)
            return false;

        if (node.data == data) {
            return true;
        }

        return isNodePresent(node.left, data) || isNodePresent(node.right, data);

    }

    public static boolean findNodeToRootPath(Node node, int data, ArrayList<Integer> ans) {

        if (node == null) {
            return false;

        }

        if (node.data == data) {
            ans.add(node.data);
            return true;
        }

        boolean res = findNodeToRootPath(node.left, data, ans) || findNodeToRootPath(node.right, data, ans);
        if (res) {
            ans.add(node.data);
        }
        return res;

    }

    public static ArrayList<Integer> nodeToRootPath(Node node, int data){
        ArrayList<Integer> ans = new ArrayList<>();
        findNodeToRootPath(node, data, ans);
        return ans;

    }

}
