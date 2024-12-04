package linkedList;

public class SListMain {
    public static void main(String[] args) {
        SList<String> s = new SList<>();
        s.insertFront("orange");
        s.insertFront("apple");
        s.insertAfter("cherry", s.head.getNext());
        s.insertFront("pear");
        s.print();
        System.out.println(": s의길이="+s.size());
        System.out.println("체리가 \t"+ s.search("cherry") +"번째");
        System.out.println("키위 \t"+ s.search("kiwi") +"번째");
        s.deleteAfter(s.head);
        s.print();
        System.out.println("s.size() = " + s.size());
        System.out.println();
        s.deleteFront();
        s.print();
        System.out.println("s.size() = " + s.size());
        System.out.println();

        SList<Integer> t = new SList<>();
        t.insertFront(500);
        t.insertFront(200);
        t.insertAfter(400, t.head);
        t.insertFront(100);
        t.insertAfter(300, t.head.getNext());
        t.print();
        System.out.println("t.size() = " + t.size());
    }
}
