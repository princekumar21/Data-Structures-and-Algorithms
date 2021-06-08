public class stack {
    private int[] arr;
    private int tos;
    private int size;
    private int maxsize;

    private void initialize(int len){
        this.arr = new int[len];
        this.tos = -1;
        this.size = 0;
        this.maxsize = len;


    }
    private void stackIsEmptyException() throws Exception{
        if(this.size == 0){
            throw new Exception("stackISEmptyException : -1");
        }

    }

    private void stackIsOverFlowException() throws Exception{
        if(this.size == this.maxsize){
            throw new Exception("stackIsoverFlowException : -1");
        }
    }

    stack(){
        initialize(5);
    }

    stack(int size){
        initialize(size);
    }

    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        for(int i = tos; i >= 0; i--){
            sb.append(this.arr[i]);
            if(i != 0){
                sb.append(",");
            }

        }
        sb.append("]");
        return sb.toString();
    }

    public int size(){
        return this.size;
    }
    public boolean isEmpty(){
        return this.size == 0;
    }

    private void push_(int data){
        this.arr[++this.tos] = data;
        this.size++;
    }

    public void push(int data) throws Exception{
        stackIsOverFlowException();
        push_(data);
    }

    public int top() throws Exception{
        stackIsEmptyException();
        return arr[this.tos];
    }

    public void pop() throws Exception{
        stackIsEmptyException();
        this.arr[this.tos--] = 0;
        this.size--;
    }
}