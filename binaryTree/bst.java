public class bst {
    public static class Node{
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

    Node prev = null;
    public static boolean isBST(Node root){

    }
}
