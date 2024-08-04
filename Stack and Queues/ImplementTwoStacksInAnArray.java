
class twoStacks {
    int size,top1,top2;
    int[] arr;
    
    twoStacks() {
          this.size=100;
        this.arr=new int[size];
        this.top1=-1;
        this.top2=size;
    }

    void push1(int x) {
        if(top1>=top2) return;
        
        arr[++top1]=x;
    }

    void push2(int x) {
         if(top1>=top2) return;
       arr[--top2]=x;
    }

    int pop1() {
         if(top1==-1) return -1;
        return arr[top1--];
    }
    int pop2() {
        if(top2==size) return -1;
        return arr[top2++];
    }
}
