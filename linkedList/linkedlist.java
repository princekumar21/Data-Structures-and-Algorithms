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
        Node node = this.head;
        if(this.size == 1){
            this.head = this.tail = null;
        }else{
            this.head = this.head.next;
            node.next = null;
        }
        this.size--;

        return node;
    }

    public int removeFirst(){
        if(this.size == 0){
            return -1;
        }

        Node node = removeFirstNode();
        return node.data;

    }
    private Node getFirstNode(){

        return this.head;
    }

    public int getFirst(){
        if(this.size == 0){
            return -1;
        }

       Node node =  getFirstNode();
       return node.data;

    }

    private Node getLastNode(){
        return this.tail;
    }

    public int getLast(){
        if(this.size == 0){
            return -1;
        }

        return getLastNode().data;

    }

    public static void main(String args[]){

    }

}