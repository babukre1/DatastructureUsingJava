import javax.naming.InitialContext;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.EmptyStackException;

public class ArrayStack<T> {
    // isEmpty Done.
    // size Done.
    // push  Done.
    // pop Done.
    // peek Done.
    // isFull
    // display - displays elements stack from last to first.
    // getLength - get full length of the ArrayStack including nulls.

    int top;
    private final static int DEFAULT_CAPACITY = 2;
    private T[] stack;

    ArrayStack(int initialCapacity) {
        top = 0;
        stack = (T[]) (new Object[initialCapacity]);
    }

    ArrayStack() {
        this(DEFAULT_CAPACITY);
    }

    public int size() {
        return top;
    }

    public T pop() throws EmptyStackException {
        if (isEmpty()) {
            throw new EmptyStackException();
        }
        top--;
        T result = stack[top];
        stack[top] = null;
        return result;
    }

    public T peek(T element) {
        return stack[top];
    }

    public boolean isEmpty() {
        return top == 0;
    }

    public void push(T element) {
        if (isfull()) {
            stack = Arrays.copyOf(stack, stack.length * 2); // expanding Capacity
            System.out.println("Array was full and got expanded by 2");
        }
        stack[top] = element;
        top++;
    }

    public boolean isfull() {
        return stack.length == top;
    }

    public void display() {
        for (int i = top - 1; i >= 0; i--) {
            System.out.println(stack[i]);
        }
    }

    public int getLength() {
        return stack.length;
    }

    public T getElementByIndex(int i) {
        return stack[i];
    }

    private boolean isDuplicated(ArrayStack array, T element) {
        if (array.size() == 0) {
            return false;
        }
        for (int i = 0; i < array.size(); i++) {
            if (array.getElementByIndex(i) == element) {
                return true;
            }
        }
        return false;
    }

    @Override
    public String toString() {
        return "ArrayStack{" +
                "top=" + top +
                ", stack=" + Arrays.toString(stack) +
                '}';
    }

    public void merge(ArrayStack<T> arr1, ArrayStack<T> arr2) {
        int newSize = arr1.size() + arr2.size();


        if (stack.length < newSize) {
            stack = Arrays.copyOf(stack, newSize);
        }

        for (int i = 0; i < arr1.size(); i++) {
            boolean duplicated = false;
            duplicated = isDuplicated(this, arr1.getElementByIndex(i));
            if (!duplicated)
                this.push(arr1.stack[i]);
        }

        for (int i = 0; i < arr2.size(); i++) {
            boolean duplicated = false;
            duplicated = isDuplicated(this, arr2.getElementByIndex(i));
            if (!duplicated)
                this.push(arr2.stack[i]);
        }
    }
}
