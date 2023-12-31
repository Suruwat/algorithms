public class SurSinglyLL<T> {
    private class Node<T>{
        T data; 
        Node<T> next;

        public Node (T data, Node<T> next) {
            this.data = data;
            this.next = next;
        }
    };

    private int size;
    private Node<T> head = null;

    public void insert(T val) {
        if(head == null) {
            head = new Node<>(val, null);
        } else {
            var currNode = head;
            while(currNode.next != null) {
                currNode = currNode.next;
            }
            
            currNode.next = new Node<>(val, null);
            size++;
        }
    }

    public void remove(T val) {

        var prev = head;
        var curr = head;

        while(curr != null) {
            if(curr.data.equals(val)) {
                prev.next = curr.next;
                size--;
                break;
            }

            prev = curr;
            curr = prev.next;
        }
        
    }

    public int size() {
        return this.size;
    }

    public void display() {
        System.out.print("[");
        var currNode = head;
        while(currNode != null) {
            System.out.print(currNode.data);
            currNode = currNode.next;
            if(currNode != null) {
                System.out.print(", ");
            }
        }
        System.out.println("]");
    }

    public static void main(String[] args) {
        SurSinglyLL<Integer> ll = new SurSinglyLL<>();
        ll.insert(10);
        ll.insert(20);
        ll.insert(5);
        ll.insert(8);

        ll.display();
        
        ll.remove(5);

        ll.display();

        ll.remove(8);

        ll.display();
    }
} 
