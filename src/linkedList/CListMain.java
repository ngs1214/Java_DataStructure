package linkedList;

public class CListMain {
    public static void main(String[] args) {
        CList<String> s = new CList<>();

        s.insert("pear");
        s.insert("cherry");
        s.insert("orange");
        s.insert("apple");
        s.print();
        System.out.println("s.size = " + s.size());
        
        s.delete();
        s.print();
        System.out.println("s.size() = " + s.size());
        
    }
}
