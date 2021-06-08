public class client {
    public static void main(String args[]) throws Exception{
        stack st = new stack(3);
        st.push(10);
        st.push(20);
        st.push(30);
        st.pop();
        st.pop();
      
        

        System.out.println(st.top());
        

    }
    
}
