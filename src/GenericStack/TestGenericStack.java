package GenericStack;

public class TestGenericStack {

    public static void main(String[] args) {

        GenericStack<Object> stack = new GenericStack<Object>();
        GenericStack<Integer> IStack = new GenericStack<Integer>();

        System.out.println(stack.isEmpty());
        stack.push("One");
        stack.push(2);
        stack.push("Three");
        stack.push("fire");
        System.out.println(stack.isEmpty());
        System.out.println(stack.getSize());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.getSize());
        System.out.println(stack.isEmpty());
        System.out.println(stack.pop());
        System.out.println(stack.pop());

    }
}
