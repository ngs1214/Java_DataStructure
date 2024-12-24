package avlTree;


import java.util.LinkedList;
import java.util.Queue;

public class AVL <Key extends Comparable<Key>, Value> {
    private Node root;

    public Node getRoot() {
        return root;
    }

    public void put(Key k, Value v) {
        root = put(root, k, v);
    }
    private Node put(Node n, Key k, Value v) {
        if (n == null) {
            return new Node(k, v, 1);
        }
        int t = k.compareTo((Key) n.getId());
        if (t < 0) {
            n.setLeft(put(n.getLeft(), k, v));
        } else if (t > 0) {
            n.setRight(put(n.getRight(), k, v));
        } else {
            n.setName(v);
            return n;
        }
        n.setHeight(tallerHeight(height(n.getLeft()),height(n.getRight()))+1);
        return balnce(n);
    }



    private Node balnce(Node n) {
        if (bf(n) > 1) { //왼쪽 서브트리가 높아서 불균형
            if (bf(n.getLeft()) < 0) {
                //LR유형
                n.setLeft(rotateLeft(n.getLeft()));
            }
            n = rotateRight(n); //LL유형
        } else if (bf(n) < -1) {
            if (bf(n.getRight()) > 0) { //RL 유형
                n.setRight(rotateRight(n.getRight()));
            }
            n = rotateLeft(n); //rr유형
        }
        return n;
    }

    public void inorder(Node node) {
        if (node != null) {
            inorder(node.getLeft());
            System.out.println(node.getId() + " " + node.getName());
            inorder(node.getRight());
        }
    }

    public void preorder(Node node) {
        if (node != null) {
            System.out.println(node.getId() + " " + node.getName());
            //재귀호출
            preorder(node.getLeft());
            preorder(node.getRight());
        }
    }
    public void levelorder(Node node) {
        Queue<Node> q = new LinkedList<>();
        Node t;
        q.add(node);
        while (!q.isEmpty()) {
            t = q.remove();
            System.out.println(node.getId() + " " + node.getName());
            if (t.getLeft() != null) {
                q.add(t.getLeft());
            }
            if (t.getRight() != null) {
                q.add(t.getRight());
            }

        }
    }

    private Node rotateRight(Node n) {
        Node x = n.getLeft();
        n.setLeft(x.getRight());
        x.setRight(n);

        n.setHeight(tallerHeight(height(n.getLeft()),height(n.getRight())+1));
        x.setHeight(tallerHeight(height(x.getLeft()),height(x.getRight())+1));

        return x;
    }

    private Node rotateLeft(Node n) {
        Node x = n.getRight();
        n.setRight(x.getLeft());
        x.setLeft(n);

        n.setHeight(tallerHeight(height(n.getLeft()),height(n.getRight())+1));
        x.setHeight(tallerHeight(height(x.getLeft()),height(x.getRight())+1));
        return x;
    }
    public void delete(Key k) {
        root = delete(root, k);
    }
    private Node delete(Node n, Key k) {
        int t = k.compareTo((Key) n.getId());
        if (t < 0) {
            n.setLeft(delete(n.getLeft(), k));
        } else if (t > 0) {
            n.setRight(delete(n.getRight(), k));
        } else {
            if (n.getLeft() == null) {
                return n.getRight();
            } else if (n.getRight() == null) {
                return n.getLeft();
            } else {
                Node y = n;
                n = min(y.getRight());
                n.setRight(deleteMin(y.getRight()));
                n.setLeft(y.getLeft());
            }
        }
        n.setHeight(tallerHeight(height(n.getLeft()),height(n.getRight())+1));
        return balnce(n);
    }

    public void deleteMin() {
        root = deleteMin(root);
    }
    private Node deleteMin(Node n) {
        if (n.getLeft() == null) {
            return n.getRight();
        }
        n.setLeft(deleteMin(n.getLeft()));
        n.setHeight(tallerHeight(height(n.getLeft()), height(n.getRight()) + 1));
        return balnce(n);
    }

    public Key min() {
        return (Key) min(root).getId();
    }
    private Node min(Node n) {
        if(n.getLeft() == null) {
            return n;
        }
        return min(n.getLeft());
    }
    public void print(Node root) {
        System.out.println("\nin order:\n");
        inorder(root);
        System.out.println("\npre order:\n");
        preorder(root);
        System.out.println("\nlevel order:\n");
        inorder(root);
    }

    private int bf(Node n) {
        return height(n.getLeft()) - height(n.getRight());
    }

    private int height(Node n) {
        if (n == null) return 0;
        return n.getHeight();
    }
    private int tallerHeight(int x, int y) {
        if (x>y) return x;
        else return y;

    }

}
