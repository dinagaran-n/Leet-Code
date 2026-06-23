class MyQueue {
    Stack<Integer> pri = new Stack<>();
    Stack<Integer> sec = new Stack<>();

    public MyQueue() {
        
    }
    
    public void push(int x) {
        pri.push(x);
    }
    
    public int pop() {
        if(!empty()){
            while(pri.size()!=0){
                sec.push(pri.pop());
            } 
            int result = sec.pop();
            while(sec.size()!=0){
                pri.push(sec.pop());
            }
            return result;
        }
        return 0;
    }
    
    public int peek() {
        if(!empty()){
            while(pri.size()!=0){
                sec.push(pri.pop());
            } 
            int result = sec.peek();
            while(sec.size()!=0){
                pri.push(sec.pop());
            }
            return result;
        }
        return 0;
    }
    
    public boolean empty() {
        return pri.size()==0;
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
