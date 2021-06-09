import java.util.ArrayList;

public class binaryTree{
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

    public static void preOrder(Node root, ArrayList<Integer> ans){
        if(root == null){
            return;
        }

        ans.add(root.data);
        preOrder(root.left, ans);
        preOrder(root.right, ans);

    }
    public static void inOrder(Node root, ArrayList<Integer> ans){
        if(root == null){
            return;
        }

        ans.add(root.data);
        inOrder(root.left, ans);
        inOrder(root.right, ans);
    }

    public static void postOrder(Node root, ArrayList<Integer> ans){
        if(root == null){
            return;
        }

        postOrder(root.left, ans);
        postOrder(root.right, ans);
        ans.add(root.data);
    }

    public static int size(Node node){
        if(node == null){
            return 0;
        }
        
        int leftSize = size(node.left);
        int rightSize = size(node.right);

        return leftSize + rightSize + 1;
        // return node == null ? 0 : size(node.left) + size(node.right) + 1;
    }

    public static int sum(Node node){
        if(node == null) return 0;

        int leftSum = sum(node.left);
        int rightSum = sum(node.right);
        
        return leftSum + rightSum + node.data;

        // return node == null ? 0 : sum(node.left) + sum(node.right) + node.data;
    }

    public static int max(Node node){
        

    }

    

}