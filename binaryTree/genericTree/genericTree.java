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

    public static int max(Node node) {
        int max = node.data;
        for (Node childs : node.child) {
            max = Math.max(max(childs), max);

        }
        return max;
    }

    public static boolean find(Node node, int data) {
        if (node.data == data) {
            return true;
        }

        boolean found = false;
        for (Node childs : node.child) {
            found = find(childs, data) || found;
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

    public static Node lowestCommonAncestor(Node node, int d1, int d2) {
        ArrayList<Node> path1 = nodeToRootPath(node, d1);
        ArrayList<Node> path2 = nodeToRootPath(node, d2);
        Node LCA = null;
        int i = path1.size() - 1;
        int j = path2.size() - 1;

        while (i >= 0 && j >= 0) {

            if (path1.get(i) != path2.get(j)) {
                break;
            }

            LCA = path2.get(j);

            i--;
            j--;
        }
        return LCA;
    }

}