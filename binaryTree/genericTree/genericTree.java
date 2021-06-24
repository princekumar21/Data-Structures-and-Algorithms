import java.util.ArrayList;
public class genericTree {
    public static class Node {
        int data;
        ArrayList<Node> child ;

        Node(int data){
            this.data = data;
            this.child = new ArrayList<>();
        }
    }
    
    public static int size(Node node){
        int count = 0;
        for(Node children : node.child){
            count += size(children);
        }
        return count + 1;
      }
    
}