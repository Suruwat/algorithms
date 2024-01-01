import java.util.Scanner;

public class StackRaj {
    private int size;
    private int[] stackArray;
    private int top = -1;

    public StackRaj(int size) {
        this.size = size;
        this.stackArray = new int[size];
    }

    public void push(int value) {
        if( top == size){
            throw new RuntimeException("Stack is full");
        }
        stackArray[++top] = value;
    }

    public int pop() {
        if(top == -1){
            throw new RuntimeException("Empty Stack");
        }
        return stackArray[top--];
    }

    public void stackElements() {
        if(top ==-1){
            System.out.println("Empty stack");
        } else {
            for (int i = 0; i <= top; i++) {
                System.out.println(stackArray[i]+ ",");
            }
        }
    }


    public static void main(String[] args) {
        StackRaj stack1 = new StackRaj(5);
         stack1.push(20);
         stack1.push(30);
         stack1.push(21);
         stack1.push(50);
         stack1.push(55);

         stack1.pop();
         stack1.stackElements();

    }
}
