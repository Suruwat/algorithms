import java.util.ArrayList;
import java.util.List;

public class SurStack<T> {

    private final int maxSize;
    private int currentIndex = -1;
    private final List<T> store;

    public SurStack(int maxSize) {
        this.maxSize = maxSize;
        store = new ArrayList<>(maxSize);
    }

    public void push(T val) {
        if(currentIndex == maxSize) {
            throw new RuntimeException("Stack is full");
        }

        store.add(++currentIndex, val);
    }

    public T pop() {
        if(currentIndex == 0) {
            throw new RuntimeException("Stack is empty");
        }

        var val = store.get(currentIndex--);
        store.remove(val);

        return val;
    }

    public void display() {
        System.out.print("[");
        
        for(int i=0; i<=currentIndex; i++) {
            System.out.print(store.get(i));
            if(i != currentIndex) {
                System.out.print(", ");
            }
        }
        System.out.println("]");
    }

    public static void main(String[] args) {
        SurStack<Integer> stack = new SurStack<>(5);
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        stack.push(5);

        stack.pop();

        stack.display();
    }
}
