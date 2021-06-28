import java.util.ArrayList;

public class genericTree {
    public static class Node {
        int data;
        ArrayList<Node> child;

        Node(int data) {
            this.data = data;
            this.child = new ArrayList<>();
        }
    }

    public static int size(Node node) {
        int count = 0;
        for (Node children : node.child) {
            count += size(children);
        }
        return count + 1;
    }
    public static int size2(Node node) {
        int s = 0;

        for (Node childs : node.child) {
            s += size(childs);
        }
        s += 1;

        return s;
    }

   

    public static boolean find(Node node, int data) {
        if(node.data == data){
            return true;
        }
        
        boolean found = false;
     for(Node childs : node.child){
        found =  find(childs, data) || found;
     }
     return found;
    }

    

    public static boolean nodeToRootPath(Node node, int data, ArrayList<Integer> list) {
        if (node.data == data) {
            list.add(node.data);
            return true;
        }

        boolean found = false;
        for (Node children : node.child) {
            found = nodeToRootPath(children, data, list) || found;
        }

        if (found) {
            list.add(node.data);
        }

        return found;

    }

    public static ArrayList<Integer> nodeToRootPath(Node node, int data) {
        if (node.data == data) {
            ArrayList<Integer> list = new ArrayList<>();
            list.add(node.data);
            return list;
        }
        ArrayList<Integer> path = new ArrayList<>();
        for (Node children : node.child) {
            path = nodeToRootPath(children, data);
            if (path.size() != 0) {
                break;
            }
        }
        if (path.size() != 0) {
            path.add(node.data);
        }
        return path;
    }

    public static Node lowestCommonAncestor(Node node, int d1, int d2){
    
    }

    

}