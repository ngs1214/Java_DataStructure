package linkedList;

public class DList <E>{
    protected DNode head;
    protected DNode tail;
    protected int size;

    public DList() {
        this.head = new DNode(null,null,null);
        this.tail = new DNode(null,head,null);
        head.setNext(tail);
        this.size = 0;
    }

    public void insertBefore(DNode p, E newItem) {
        DNode t = p.getPrevious();
        DNode<E> newNode = new DNode<>(newItem, t, p);
        p.setPrevious(newNode);
        t.setNext(newNode);
        size++;
    }

    public void insertAfter(DNode p, E newItem) {
        DNode t = p.getNext();
        DNode<E> newNode = new DNode<>(newItem, p, t);
        t.setPrevious(newNode);
        p.setNext(newNode);
        size++;
    }

    public void delete(DNode x) {
        DNode f = x.getPrevious();
        DNode r = x.getNext();
        f.setNext(r);
        r.setPrevious(f);
        size--;
    }

    public void print() {
        if (size > 0) {
            for (DNode p = head.getNext(); p != tail; p = p.getNext()) {
                System.out.print(p.getItem()+"\t");
            }
        }else {
            System.out.println("비어있음");
        }
        System.out.println();
    }
}
