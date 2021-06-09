package adapters;

public class queueUsingSelfLL {
    public static class queue{
    private class Node {
        int data;
        Node next;

        Node() {

        }

        Node(int data) {
            this.data = data;
        }
    }

    private Node head = null;
    private Node tail = null;
    private int size = 0;

    private void addLast(int data) {
        Node node = new Node(data);
        if (this.size == 0) {
            this.head = this.tail = node;

        } else {
            this.tail.next = node;
            this.tail = node;
        }
        this.size++;
    }

    private int removeFirst() {
        Node node = head;
        if (this.size == 1) {
            this.head = this.tail = null;
        } else {
            this.head = node.next;
            node.next = null;

        }
        this.size--;
        return node.data;

    }

    public int size() {
        return this.size;

    }

    public boolean isEmpty() {
        return this.size == 0;
    }

    public void add(int data) {
        addLast(data);

    }

    public int peek() {
        return this.head.data;
    }

    public int remove() {
        return removeFirst();
    }

}
public static void main(String args[]) throws Exception{
    queue q = new queue();
    q.add(10);
    q.add(20);
    q.add(30);
    q.add(40);
    
    q.peek();
    System.out.println(q.peek());
  
    


}

}
