package avlTree;

public class Node <Key extends Comparable<Key>, Value> {
    private Key id;
    private Value name;
    private int height;
    private Node left;
    private Node right;

    public Node(Key id, Value name, int height) {
        this.id = id;
        this.name = name;
        this.height = height;
        this.left = null;
        this.right = null;
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

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
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
