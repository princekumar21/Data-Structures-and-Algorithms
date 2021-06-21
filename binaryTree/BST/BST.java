public class BST {
    public static class Node {
        int data;
        Node left;
        Node right;

        Node(int data, Node left, Node right){
            this.data = data;
            this.left = left;
            this.right = right;
        }

        Node(int data){
            this(data, null, null);


        }
    }

    public static int size(Node node){
        if(node == null){
            return 0;
        }

        return size(node.left) + size(node.right) + 1;
    }

    public static int height(Node node){
        if(node == null){
            return -1;
        }

        return Math.max(height(node.left), height(node.right)) + 1;
    }
}