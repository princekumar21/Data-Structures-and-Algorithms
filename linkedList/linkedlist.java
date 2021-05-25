public class linkedlist{

    public class  Node {
        int data = 0;
        Node next = null;

        // Node(int data){
        //     this.data = data;
        // }
    } 

    private Node head = null;
    private Node tail = null;
    private int size = 0;
    
    public int size(){
        return this.size;
    }

    public void addFirstNode(Node node){

        if(this.size == 0){
            this.tail = this.head = node;
        }else {
            node.next = this.head;
            this.head = node;
        }
        this.size++;
    }

    public void addFirst(int data){
        Node node = new Node();
        node.data = data;
        addFirstNode(node);
    }

    public void addLastNode(Node node){
        if(this.size == 0){
            this.head = this.tail = node;
        }else{
            tail.next = node;
            this.tail = node;
        }
        this.size++;
    }
    
    public void addLast(int data){
        Node node = new Node();
        node.data = data;

        addLastNode(node);
    }

    private Node removeFirstNode(){

    }

    public Node removeFirst(){
        
    }

    public static void main(String args[]){

    }

}