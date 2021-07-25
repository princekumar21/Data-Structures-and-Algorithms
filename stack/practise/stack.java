package practise;

public class stack {
    private int arr[];
    private int tos;
    private int size;
    private int maxSize;

    public void initilize(int len){
        this.arr = new int[len];
        this.size = 0;
        this.tos = -1;
        this.maxSize = len;

    }

    stack(){
        initilize(5);
    }

    stack(int size){
        initilize(size);
    }

    private void stackIsOverFlow() throws Exception {
        if(this.size == this.maxSize){
        throw new Exception("stackIsOverFlow : -1");

        }
        
    }
    private void stackIsEmpty() throws Exception {
        if(this.size == 0){
            throw new Exception("stackIsEmpty : -1");
        }
       
    }

    public boolean IsEmpty(){
        return this.size == 0;
    }

    public int size() {
        return this.size;

    }

    private void add_(int data){
        this.arr[++this.tos] = data;
        this.size++;


    }

    public void add(int data) throws Exception{
        stackIsOverFlow();

        add_(data);
    }

    private int pop_(){
        int rv = arr[this.tos];
        arr[this.tos] = 0;
        this.tos--;
        this.size--;

        return rv;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        for(int i = this.size; i >= 0; i--){
            sb.append(this.arr[i]);
            if(i != 0){
                sb.append(",");

            }
        }
        sb.append("]");

        return sb.toString();
    }

    public int pop() throws Exception{
        stackIsEmpty();
        
        return pop_();

    }
    public int top() {
        return arr[this.tos];
    }
    
}
