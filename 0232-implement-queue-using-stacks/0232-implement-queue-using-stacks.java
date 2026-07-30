class MyQueue {
    Stack<Integer> st = new Stack<>();
    Stack<Integer> helper = new Stack<>();

    public MyQueue() {
        
    }
    
    public void push(int x) {    //O(n)
        while(st.size()>0) helper.push(st.pop());
        st.push(x);
        while(helper.size()>0) st.push(helper.pop());    
        
    }
    
    public int pop(){     //O(1)
        return st.pop();
    }
    
    public int peek() {     //O(1)
       return st.peek();
    }

    /*public MyQueue() {
        
    }
    
    public void push(int x) {    //O(1)
        st.push(x);
        
    }
    
    public int pop(){     //O(n)
        while(st.size()>1) helper.push(st.pop());
        int front = st.pop();
        while(helper.size()>0) st.push(helper.pop());
        return front;
    }
    
    public int peek() {     //O(n)
        while(st.size()>1) helper.push(st.pop());
        int front = st.peek();
        while(helper.size()>0) st.push(helper.pop());
        return front;
    }*/
    public boolean empty() {
        return (st.size()==0);
        
    }
    
}

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */