import java.util.ArrayList;
public class genericTree {
    public static class Node {
        int data;
        ArrayList<Node> node ;

        Node(int data){
            this.data = data;
            this.node = new ArrayList<>();
        }
    }

    
}