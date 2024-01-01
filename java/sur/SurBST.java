import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SurBST<T extends Comparable<T>> {
    private class Node<T extends Comparable<T>> {
        T val;
        Node<T> left;
        Node<T> right;

        public Node(T val, Node<T> left, Node<T> right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    private Node<T> root;

    public SurBST(T val) {
        this.root = new Node<T>(val, null, null);
    }

    public List<T> traverseIn() { // Le-Ro-Ri
        var data = new ArrayList<T>();
        traverseIn(data, root);
        return data;
    }

    public List<T> traversePre() { // Ro-Le-Ri
        var data = new ArrayList<T>();
        traversePre(data, root);
        return data;
    }

    public List<T> traversePos() { // Le-Ri-Ro
        var data = new ArrayList<T>();
        traversePos(data, root);
        return data;
    }

    public void insert(T val) {
        if (root == null) {
            root = new Node<T>(val, null, null);
        } else {
            insert(val, root);
        }
    }

    // Sort ascending
    public void traverseIn(List<T> data, Node<T> subTree) { // Le-Ro-Ri
        if (subTree == null) {
            return;
        }
        traverseIn(data, subTree.left);
        data.add(subTree.val);
        traverseIn(data, subTree.right);
    }

    public void traversePre(List<T> data, Node<T> subTree) { // Ro-Le-Ri
        if (subTree == null) {
            return;
        }
        data.add(subTree.val);
        traverseIn(data, subTree.left);
        traverseIn(data, subTree.right);
    }

    public void traversePos(List<T> data, Node<T> subTree) { // Le-Ri-Ro
        if (subTree == null) {
            return;
        }
        traverseIn(data, subTree.left);
        traverseIn(data, subTree.right);
        data.add(subTree.val);
    }

    private Node<T> insert(T val, Node<T> subTree) {
        if (subTree == null) {
            return new Node<T>(val, null, null);
        }

        if (val.compareTo(subTree.val) <= 0) {
            subTree.left = insert(val, subTree.left);
        } else {
            subTree.right = insert(val, subTree.right);
        }

        return subTree;
    }

    public static void main(String[] args) {
        SurBST<Integer> bst = new SurBST<Integer>(10);
        //        10
        //       /   \
        //      1     15
        //      \     / \
        //       8   11  29
        //      / 	   \
        //     5        15
        //    /     
        //   3      

        bst.insert(1);
        bst.insert(15);
        bst.insert(8);
        bst.insert(5);
        bst.insert(29);
        bst.insert(11);
        bst.insert(15);
        bst.insert(3);

        var inorderList = bst.traverseIn();
        System.out.println("=== Inorder ===");
        System.out.println(Arrays.toString(inorderList.toArray()));
        var preorderList = bst.traversePre();
        System.out.println("=== Preorder ===");
        System.out.println(Arrays.toString(preorderList.toArray()));
        var postorderList = bst.traversePos();
        System.out.println("=== Postorder ===");
        System.out.println(Arrays.toString(postorderList.toArray()));
    }
}