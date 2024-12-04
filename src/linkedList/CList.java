package linkedList;

import org.w3c.dom.Node;

import java.util.NoSuchElementException;

public class CList <E>{
    private SNode last;
    private int size;

    public CList() {
        this.last = null;
        this.size = 0;
    }
    //last 노드 다음에 newItem 추가
    public void insert(E newItem) {
        SNode newNode = new SNode(newItem, null);
        if (last == null) {
            newNode.setNext(newNode);
            last = newNode;
        }else{
            newNode.setNext(last.getNext());
            last.setNext(newNode);
        }
        size++;
    }
    //last가 가르키는 노드의 다음 노드 삭제
    public SNode delete() {
        if (isEmpty()) throw new NoSuchElementException();
        SNode x = last.getNext();
        if (x == last) {
            last = null;
        } else {
            last.setNext(x.getNext());
            x.setNext(null);
        }
        size--;
        return x;
    }
    private boolean isEmpty() {
        if (size ==0) return true;
        return false;
    }
    public int size() {
        return size;
    }

    public void print() {
        if (size > 0) {
            int i =0;
            for (SNode p = last.getNext(); i < size; p = p.getNext(), i++) {
                System.out.print(p.getItem() +"\t");
            }
        }else {
            System.out.println("비어있음");
        }
    }
}
