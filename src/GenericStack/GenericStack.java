package GenericStack;

public class GenericStack<E> {
    int top = 0;
    int size = 2;
    private E [] elements = (E[]) new Object[size];


    public int getSize(){
        return top;
    }

    public E peek() {
        return elements[top];
    }

    public void push(E o) {
        if (top  == size) {
            E [] tempElements = elements.clone();
            size = size * 2;
            elements = (E[]) new Object[size];
            System.arraycopy(tempElements, 0, elements, 0, tempElements.length);
        }

        elements[top++] = o;

    }

    public E pop() {
        if (top > 0) {
        E pop = elements[--top];
        return pop;}
        else {
            System.out.println("Stack underflow");
            return null;
        }
    }

    public boolean isEmpty() {
        return (top == 0);
    }
    @Override
    public String toString() {
        StringBuilder s = new StringBuilder();
        s.append("Stack: [");
        for (int i = 0; i < top-1; i++) {
            s.append(elements[i].toString()).append(", ");
        }
        s.append(elements[top-1]);
        s.append("]");

        return s.toString();
    }
}
