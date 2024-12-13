package stack;

public class ListStackMain {
    public static void main(String[] args) {
        ListStack<String> stack = new ListStack<>();
        stack.push("apple");
        stack.push("orange");
        stack.push("cherry");
        System.out.println(stack.peek());
        stack.push("peer");
        stack.print();
        stack.pop();
        System.out.println(stack.peek());
        stack.push("grape");
        stack.print();

    }
}
