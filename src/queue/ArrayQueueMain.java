package queue;

public class ArrayQueueMain {
    public static void main(String[] args) {
        ArrayQueue<String> queue = new ArrayQueue<>();

        queue.add("apple");
        queue.add("orange");
        queue.add("cherry");
        queue.add("pear");
        queue.print();

        queue.remove();
        queue.print();

        queue.add("grape");
        queue.print();

        queue.remove();
        queue.print();
    }
}
