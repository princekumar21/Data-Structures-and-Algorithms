public class queue {
    private int arr[];
    private int size;
    private int maxsize;
    private int front;
    private int back;
    
    private void initilize(int len){
        this.arr = new int[len];
        this.size = 0;
        this.maxsize = len;
        this.front = this.back = 0;
    }
    
    queue(){
        initilize(5);
    }

    queue(int size){
        initilize(size);
    }

    public int size(){
        return this.size;
    }

    public boolean isEmpty(){
        return this.size == 0;
    }

    public void add(){
        
    }

    
    
}
