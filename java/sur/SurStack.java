public class SurStack {

    private int maxSize;
    private int currentIndex = -1;
    private int[] store;

    public SurStack(int maxSize) {
        this.maxSize = maxSize;
        store = new int[maxSize];
    }

    public void push(int val) {
        if(currentIndex == maxSize) {
            throw new RuntimeException("Stack is full");
        }

        store[++currentIndex] = val;
    }

    public int pop() {
        if(currentIndex == 0) {
            throw new RuntimeException("Stack is empty");
        }

        return store[currentIndex--];
    }

    public void display() {
        System.out.print("[");
        
        for(int i=0; i<=currentIndex; i++) {
            System.out.print(store[i]);
            if(i != currentIndex) {
                System.out.print(", ");
            }
        }
        System.out.println("]");
    }

    public static void main(String[] args) {
        SurStack stack = new SurStack(5);
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        stack.push(5);

        stack.pop();

        stack.display();
    }
}
