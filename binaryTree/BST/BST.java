import java.util.ArrayList;
import java.util.Collection;
import java.util.*;

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

    public static int sum(Node node) {
        return node == null ? 0 : sum(node.left) + sum(node.right) + node.data;
    }

    public static ArrayList<Node> nodeToRootPath(Node node, int data) {
        ArrayList<Node> path = new ArrayList<>();
        boolean flag = false;
        while (node != null) {
            path.add(node);
            if (node.data == data) {
                flag = true;
                break;
            } else if (node.data < data) {
                node = node.right;
            } else {
                node = node.left;
            }
        }
        if (!flag)
            path.clear();

        Collections.reverse(path);
        return path;

    }

    // Lowest Common Ancestor
    public static int LCA(Node node, int d1, int d2) {
        int lca = -1;
        while (node != null) {
            if (node.data < d1 && node.data < d2) {
                node = node.right;
            } else if (node.data > d1 && node.data > d2) {
                node = node.left;
            } else {
                lca = node.data;
                break;
            }
        }

        return lca;

    }

    public static void printInRange(Node node, int lr, int rr) {
        if (node == null) {
            return;
        }

        if (node.data < lr && node.data < rr) {
            printInRange(node.left, lr, rr);

        } else if (node.data > lr && node.data > rr) {
            printInRange(node.right, lr, rr);
        } else {
            printInRange(node.left, lr, rr);
            System.out.println(node.data);
            printInRange(node.right, lr, rr);
        }

    }

    public static Node addData(Node node, int data) {
        if (node == null) {
            return new Node(data);
        }

        if (node.data < data) {
            node.right = addData(node.right, data);
        } else if (node.data > data) {
            node.left = addData(node.left, data);
        }
        return node;
    }

    public static Node removeNode(Node node, int data) {
        if (node.data < data) {
            node.right = removeNode(node.right, data);
        } else if (node.data > data) {
            node.left = removeNode(node.left, data);
        } else {
            if (node.left == null || node.right == null) {
                return node.left != null ? node.left : node.right;
            } else {
                int minEle = min(node.right);
                node.data = minEle;

                node.right = removeNode(node.right, minEle);
            }
        }
        return node;

    }

    static int sum = 0;
    public static void replaceWithSumOfLarger(Node node) {
        if (node == null) {
            return;
        }
        replaceWithSumOfLarger(node.right);
        int pre = node.data;
        node.data = sum;
        sum += pre;
        replaceWithSumOfLarger(node.left);
    }

    public void replaceWithSumOfLarger2(Node root, int arr[])
    {
        if(root == null){
            return;
        }
        replaceWithSumOfLarger2(root.right, arr);
       root.data += arr[0];
       arr[0] = root.data;
       replaceWithSumOfLarger2(root.left, arr);
        
        
        
    }
    public Node modify(Node root){
    int arr[] = new int[1];
    replaceWithSumOfLarger2(root, arr);
        
        return root;
    }
}