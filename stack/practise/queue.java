package practise;

public class queue {
    private int arr[];
    private int size;
    private int maxSize;
    private int front;
    private int back;

    public void initilize(int len) {
        this.arr = new int[len];
        this.size = 0;
        this.front = -1;
        this.maxSize = len;
        this.back = 0;

    }
    queue(int size) {
        initilize(size);
    }
    queue() {
        
        initilize(5); 
    }

    private void queueIsOverFlowException() throws Exception {
        if(this.size == this.maxSize){
        throw new Exception("queueIsOverFlowException : -1");

        }
        
    }
    private void stackIsEmptyException() throws Exception {
        if(this.size == 0){
            throw new Exception("stackIsEmpty : -1");
        }
       
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        for(int i = 0; i < this.size; i++){
            int idx = (i  + this.front) % this.maxSize;
            sb.append(arr[idx]);
            if(i < this.size - 1){
                sb.append("]");
            }
        }

        return sb.toString();
    }

    public int size(){
        return this.size;

    }

    public boolean isEmpty() {
        return this.size == 0;
    }

    private void add_(int data){
        int idx = (this.back  + 1) % this.maxSize;
        
        arr[this.back] = data;
        this.back = idx;
        this.size++;
    }

    public void add(int data) throws Exception {
        queueIsOverFlowException();

        add_(data);

    }

    public int  peek() {
        return arr[this.front];

    }

    private int remove_(){
        int idx = (this.front + 1) % this.maxSize;
        int rv = arr[this.front];
        arr[this.front] = 0;
        this.front = idx;
        this.size--;

        return rv;
    }
    public int remove() throws Exception{
        stackIsEmptyException();

        return remove_();
    }

    
}
