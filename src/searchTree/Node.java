package searchTree;

public class Node <Key extends Comparable<Key>, Value> {
    private Key id;
    private Value name;
    private Node  left;
    private Node  right;

    public Node(Key id, Value name) {
        this.id = id;
        this.name = name;
        left = null;
        right = null;
    }

    public Key getId() {
        return id;
    }

    public void setId(Key id) {
        this.id = id;
    }

    public Value getName() {
        return name;
    }

    public void setName(Value name) {
        this.name = name;
    }

    public Node getLeft() {
        return left;
    }

    public void setLeft(Node left) {
        this.left = left;
    }

    public Node getRight() {
        return right;
    }

    public void setRight(Node right) {
        this.right = right;
    }
}
