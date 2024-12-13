package stack;
import java.util.EmptyStackException;

public class ArrayStack<E> {
    private E s[];
    private int top;

    public ArrayStack() {
        this.s = (E[]) new Object[1];
        this.top = -1;
    }

    public int size() {
        return this.top +1;
    }

    public boolean isEmpty() {
        return this.top == -1;
    }

    public void resize(int newSize) {
        Object[] t = new Object[newSize];
        for (int i = 0; i < s.length; i++) {
            t[i] = s[i];
        }
        s = (E[]) t;
    }

    //스택 top 항목의 내용만을 리턴
    public E peek() {
        if (isEmpty()) throw new EmptyStackException();
        return s[top];
    }

    public void push(E newItem) {
        if (size() == s.length) {
            resize(2 * s.length);
        }
        //top을 1 증가시킨 후에 newItem 삽입
        s[++top] = newItem;
    }

    //top으 항목을 꺼낸 뒤 삭제
    public E pop() {
        if (isEmpty()) throw new EmptyStackException();
        E item = s[top];
        s[top--] = null;
        if (size() > 0 && size() == s.length / 4) {
            resize(s.length / 2);
        }
        return item;
    }

    public void print() {
        if (isEmpty()) System.out.print("스택이 비어있음");
        else for (int i = 0; i < size(); i++) {
            System.out.print(s[i]+"\t ");
        }
        System.out.println();
    }
}
