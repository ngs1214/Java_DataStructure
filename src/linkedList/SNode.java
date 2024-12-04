package linkedList;//단순연결리스트
//동적 메모리 할당을 이용해 구현 하는 가장 간단한 형태의 자료구조
//순차탐색 찾을때까지 처음부터 방문하는 순차탐색

public class SNode<E>{
    private E item;
    private SNode<E> next;

    public SNode(E newItem, SNode<E> nextNode) {
        this.item = newItem;
        this.next = nextNode;
    }

    public E getItem() {
        return item;
    }

    public void setItem(E item) {
        this.item = item;
    }

    public SNode<E> getNext() {
        return next;
    }

    public void setNext(SNode<E> next) {
        this.next = next;
    }
}
