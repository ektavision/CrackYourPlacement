class MyQueue {
    Stack<Integer> pushStack = new Stack<>();
       Stack<Integer> popStack = new Stack<>();
   
       public MyQueue() {
           
       }
       
       public void push(int x) {
                   pushStack.add(x);
   
       }
       
       public int pop() {
             transferItems();
           return popStack.pop();
       }
       
        private void transferItems() {
           if (popStack.isEmpty()) {
               while (!pushStack.isEmpty()) {
                   popStack.add(pushStack.pop());
               }
           }
       }
       public int peek() {
            transferItems();
           return popStack.peek();
       }
       
       public boolean empty() {
           return pushStack.isEmpty() && popStack.isEmpty();
   
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