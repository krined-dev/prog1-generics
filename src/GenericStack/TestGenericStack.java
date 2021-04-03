package GenericStack;

public class TestGenericStack {

    public static void main(String[] args) {

        GenericStack<String> stack = new GenericStack<String>();
        GenericStack<Integer> IStack = new GenericStack<Integer>();

        System.out.println(stack.isEmpty());
        stack.push("Hello");
        System.out.println(stack.isEmpty());
        System.out.println(stack.getSize());
        stack.pop();
        System.out.println(stack.isEmpty());
        System.out.println(stack.pop());
        System.out.println(stack.getSize());

    }
}
