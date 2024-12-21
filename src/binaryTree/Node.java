package binaryTree;

public class Node<Key extends Comparable<Key>> {
    private Key item;
    private Node<Key> left;
    private Node<Key> right;

    public Key getItem() {
        return item;
    }

    public void setItem(Key item) {
        this.item = item;
    }

    public Node<Key> getLeft() {
        return left;
    }

    public void setLeft(Node<Key> left) {
        this.left = left;
    }

    public Node<Key> getRight() {
        return right;
    }

    public void setRight(Node<Key> right) {
        this.right = right;
    }

    public Node(Key newItem, Node<Key> lt, Node<Key> rt) {
        this.item = newItem;
        this.left = lt;
        this.right = rt;
    }
}
