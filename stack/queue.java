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

    private void queueIsEmptyException() throws Exception{
        if(this.size == this.maxsize){
            throw new Exception("queueIsEmptyException : -1");
        }

    }

    public int size(){
        return this.size;
    }

    public boolean isEmpty(){
        return this.size == 0;
    }

    private void add_(int data){
        this.arr[this.back] = data; 
        this.back = (this.back + 1) % this.maxsize;
        this.size++; 
    }

    public void add(int data) throws Exception{
        queueIsEmptyException();
        add_(data);  
            
    }

    public int peek(){
        return this.arr[front];
    }

    
    
}
