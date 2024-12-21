package binaryTree;

import java.util.LinkedList;
import java.util.Queue;

public class BinaryTree<Key extends Comparable<Key>> {
    private Node root;

    public BinaryTree() {
        this.root = null;
    }

    public Node getRoot() {
        return root;
    }

    public void setRoot(Node root) {
        this.root = root;
    }
    public boolean isEmpty(){
        return root == null;
    }

    //              1
    //        2                3
    //    4      5        6        7
    // 8   9   10  11  12  13  14    15
    //이진트리 4가지 순회방식
    //전위순회 : 노드x에 도착했을 때 x를 방문하고 x의 왼쪽 자식노드를 순회 후 오른쪽 순회 NLR (node left right)
    //-> 1 2 4 8 9 5 10 11 3 6 12 13 7 14 15
    public void preorder(Node node) {
        if (node != null) {
            System.out.println(node.getItem());
            //재귀호출
            preorder(node.getLeft());
            preorder(node.getRight());
        }
    }

    //중위순회 : 노드x에 도착하면 x의 방문을 보류하고 x의 왼쪽 서브트르로 순회를 진행 LNR(left node right)
    //->8 4 9 2 10 5 11 1  12 6 13 3 14 7 15
    public void inorder(Node node) {
        if (node != null) {
            inorder(node.getLeft());
            System.out.println(node.getItem());
            inorder(node.getRight());
        }
    }

    //후위순회 : 노드x에 방문하면 보류하고 왼쪽서브트리 방문 후에 오른쪽 서브트리 방문후에 노드x 방문 LRN(left node right)
    //-> 8  9  4  10 11 5  2  12 13 6  14 15 7 3 1
    public void postorder(Node node) {
        if (node != null) {
            postorder(node.getLeft());
            postorder(node.getRight());
            System.out.println(node.getItem());

        }
    }

    //레벨순회 : 루트 노드가 있는 최상위 레벨부터 시작하여 각레벨 왼쪽에서 오른쪽으로 방문
    // ->  1 2 3 4 5 6 7 8 9 10 11 12 13 14 15
    public void levelorder(Node node) {
        Queue<Node> q = new LinkedList<>();
        Node t;
        q.add(node);
        while (!q.isEmpty()) {
            t = q.remove();
            System.out.println(t.getItem() + " ");
            if (t.getLeft() != null) {
                q.add(t.getLeft());
            }
            if (t.getRight() != null) {
                q.add(t.getRight());
            }

        }
    }

    //size() : 트리의 노드수 계산 (후위순회기반)
    //height() : 트리의 높이 계산 (후위순회기반)
    //isEqual(): 2개의 이진트리 대한 동일성 검사 (전위순회기반)
    public int size(Node node) {
        if (node != null) {
            //재귀 호출
            return (1 + size(node.getLeft()) + size(node.getRight()));
        }else{
            return 0;
        }
    }

    public int height(Node node) {
        if (node != null) {
            return 1 + Math.max(height(node.getLeft()), height(node.getRight()));
        } else {
            return 0;
        }
    }

    public static  boolean isEqual(Node nodeA, Node nodeB) {
        if (nodeA == null || nodeB == null) {
            return nodeA == nodeB;
        }
        //compareTo  a>b  양수 / a==b 0 / a<b 음수
        if (nodeA.getItem().compareTo(nodeB.getItem()) != 0) {
            return false;
        }
        return isEqual(nodeA.getLeft(), nodeB.getLeft()) &&  isEqual(nodeA.getRight(), nodeB.getRight());
    }

    public Node copy(Node node) {
        Node left;
        Node right;
        if (node == null) {
            return null;
        }
        left = copy(node.getLeft());
        right = copy(node.getRight());
        return new Node<>(node.getItem(), left, right);
    }
}
