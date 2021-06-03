import java.util.LinkedList;

public class linkedlist{

    public class  Node {
        int data = 0;
        Node next = null;

        Node(int data){
            this.data = data;
        }

        Node(){

        }
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

    private Node getNodeAt(int idx){
        Node curr = this.head;
        while(idx-- > 0){
            curr = curr.next;

        }

        return curr;

    }

    public int getAt(int idx){
        if(idx < 0 && idx >= this.size){
            return -1;
        }
        Node node = getNodeAt(idx);
        return node.data;
    }

    public int mid(){
        if(head == null){
            return -1;
        }
          Node fast = head;
          Node slow = head;
          //fast.next != null doubt about this
          while(fast.next != null && fast.next.next != null){
              fast = fast.next.next;
              slow = slow.next;
              
          }
          
          return slow.data;
        }

    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder();
        Node curr = head;
        sb.append("[");
        while(curr != null){ 
            sb.append(curr.data);
            if(curr != null){
                sb.append(",");
            }
            curr = curr.next;
        }
        
        sb.append("]");
       
        
        return sb.toString();
    }

    public void oddEven(){
        Node even = new Node(-1);
        Node ep = even;
        
        Node odd = new Node(-1);
        Node op = odd;
        
        Node curr = head;
        
        while(curr != null){
            if(curr.data % 2 != 0){
                op.next = curr;
                op = op.next;
            }else{
                ep.next = curr;
                ep = ep.next;
            }
            
            curr = curr.next;
            
        }
        
        op.next = even.next;
        head = odd.next;
        
       
        
        
    }
    public  void reverseOfLinkedList(Node head){
        Node curr = head;
        Node forw = curr.next;
        Node prev = new Node(-1);
        Node node = new Node();
        
    


    }
    public static void addLinkedList(Node l1, Node l2){

    }

    public static void main(String args[]){

       linkedlist ll = new linkedlist();
       ll.addFirst(1);

    }

}