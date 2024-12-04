package simpleArr;

import java.util.NoSuchElementException;

public class ArrList<E>{
    private E a[]; //리스트의 항목들을 저장할 배열
    private int size; //리스트 항목 수

    public ArrList() {
        a = (E[]) new Object[1]; //최초로 1개의 원소를 가진 배열 생성
        size = 0; //항목 수를 0으로 초기화
    }

    //탐색,삽입,삭제
    //k번째 항목 반환
    public E peek(int k) {
        if (size == 0) {
            throw new NoSuchElementException();
        }
        return a[k];
    }

    //마지막원소에 추가
    public void insertLast(E newItem) {
        if (size == a.length) {
            resize(2 * a.length);
        }
        a[size++] = newItem;
        //a[size] = newItem;
        //size++;
    }

    public void insert(E newItem, int k) {
        if (size == a.length) {
            resize(2 * a.length);
        }
        for (int i = size - 1; i >= k; i--) {
            a[i + 1] = a[i]; //한칸씩 뒤로 이동
        }
        //해당 k위치에 삽입
        a[k] = newItem;
        size++;
    }

    private void resize(int newSize) {
        Object[] t = new Object[newSize]; //newSize 배열 생성
        for (int i = 0; i < size; i++) {
            t[i] = a[i]; //배열복사
        }
        a = (E[]) t;
    }

    public E delete(int k) {
        if(isEmpty()) throw new NoSuchElementException();
        E item = a[k];
        //k번째 삭제했으니 k번째 뒤원소를 한칸씩 땡김
        for (int i = k; i < size; i++) {
            a[i] = a[i + 1];
        }
        size--;
        //사이즈가 3/4가 비어있으면 리사이즈
        if (size > 0 && size == a.length / 4) {
            resize(a.length / 2);
        }
        return item;
    }
    public boolean isEmpty() {
        if (size == 0) {
            return true;
        }else {
            return false;
        }
    }

    public void print() {
        if (isEmpty()) {
            System.out.println("배열비어있음");
        }else{
            for (int i = 0; i < size; i++) {
                System.out.print(a[i]+"\n");
            }
            System.out.println();
        }
    }
}
