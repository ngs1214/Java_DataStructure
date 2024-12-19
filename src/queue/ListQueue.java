package queue;

import java.util.NoSuchElementException;

public class ListQueue<E> {
    private Node<E> front;
    private Node<E> rear;
    private int size;

    public ListQueue() {
        this.front = null;
        this.rear = null;
        this.size = 0;

    }

    public int size() {
        return size;
    }
    public boolean isEmpty() {
        return size() == 0;
    }

    public void add(E newItem) {
        Node<E> newNode = new Node<>(newItem, null);
//        if (isEmpty()) front = newNode;
//        else rear.setNext(newNode);
//        rear = newNode;
        if (isEmpty()) {
            this.front = newNode;
        } else {
            rear.setNext(newNode);
        }
        rear = newNode;
        size++;
    }

    public E remove() {
        if (isEmpty()){
            throw  new NoSuchElementException();
        }
        E frontItem = front.getItem();
        front = front.getNext();
        if (isEmpty()) rear = null;
        size--;
        return frontItem;

    }

    public void print() {
        if (isEmpty()) {
            System.out.print("큐가 empty임");
        } else {
            for (Node p = front; p != null;  p = p.getNext()) {
                System.out.print(p.getItem() + "\t ");
            }
            System.out.println();
        }

    }
}
