import java.util.ArrayList;
public class BST {
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

    // T : O(n), S : O(1)
    public static int size(Node node) {
        if (node == null) {
            return 0;
        }

        return size(node.left) + size(node.right) + 1;
    }

    // T : O(n), S : O(1)
    public static int height(Node node) {
        if (node == null) {
            return -1;
        }

        return Math.max(height(node.left), height(node.right)) + 1;
    }

    // T : O(log n), S : O(1)
    public static int max(Node node) {
        while (node.right != null) {
            node = node.right;
        }

        return node.data;

    }

    // T : O(log n), S : O(1)
    public static int min(Node node) {
        while (node.left != null) {
            node = node.left;
        }

        return node.data;
    }

    // T : O(log n), S : O(1)
    public static boolean find(Node node, int data) {

        while (node != null) {
            if (node.data < data) {
                node = node.right;
            } else if (node.data > data) {
                node = node.left;

            } else if (node.data == data) {
                return true;

            }
        }
        return false;
    }

    public static int sum(Node node){
        return node == null ? 0 : sum(node.left) + sum(node.right) + node.data;
    }

    public static ArrayList<Node> nodeToRootPath(Node node, int data){
        ArrayList<Node> path = new ArrayList<>();

        while(node != null){
            if(node.data == data){
                path.add(node);
                break;
            }else if(node.data < data){
                path.add(node);
                node = node.right;
            }else{
                path.add(node);
                node = node.left;
            }
        }

        return path;

    }
}