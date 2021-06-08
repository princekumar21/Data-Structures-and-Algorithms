package adapters;
import java.util.LinkedList;
public class queueUsingJavaLL {
    public static class queue{
        private LinkedList<Integer> ll = new LinkedList<>();
        
        public int size(){
            return this.ll.size();

        }

        public boolean isEmpty(){
            return this.ll.isEmpty();
        }

        public void add(int data){
            this.ll.addLast(data);

        }

        public int peek(){
            return this.ll.getFirst();

        }

        public int remove(){
            return this.ll.removeFirst();

        }
    }
    public static void main(String args[]){

        queue q = new queue();
        q.add(10);
        System.out.println(q.peek());

    }
    
}
