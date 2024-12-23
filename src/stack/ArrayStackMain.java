package stack;

public class ArrayStackMain {
    public static void main(String[] args) {
        ArrayStack<String> stack = new ArrayStack<String>();
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
