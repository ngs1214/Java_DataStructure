package linkedList;

import java.util.NoSuchElementException;

public class SList <E> {
    protected SNode head;
    private int size;

    public SList() {
        this.head = null;
        this.size = 0;
    }
    //인자로 주어지는 타켓을 찾을때까지 차례로 검색
    //탐색 실패시 -1 리턴
    public int search(E target) {
        SNode p = head;
        for (int k = 0; k < size; k++) {
            if (target == p.getItem()) return k;
            p = p.getNext();
        }
        return  -1;
    }
    //맨앞에 넣기
    public void insertFront(E newItem) {
        head = new SNode<>(newItem, head);
        size++;
    }

    public void insertAfter(E newItem, SNode p) {
        p.setNext(new SNode<>(newItem, p.getNext()));
        size++;
    }
    //맨앞에 삭제
    public void deleteFront() {
        if(size==0) throw new NoSuchElementException();
        head = head.getNext();
        size--;
    }
    //p가르키는 다음 노드 삭제
    public void deleteAfter(SNode p) {
        if (p == null) throw new NoSuchElementException();
        SNode t = p.getNext();
        p.setNext(t.getNext());

        t.setNext(null);
        size--;
    }
    public boolean isEmpty() {
        if (size == 0) {
            return true;
        }else {
            return false;
        }
    }

    public void print() {
        for (SNode p = head; p != null; p = p.getNext()) {
            System.out.print(p.getItem() + "\t");
        }
        System.out.println();
    }

    public int size() {
        return size;
    }
}
