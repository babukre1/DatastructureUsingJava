import java.util.Arrays;
import java.util.EmptyStackException;

public class ArrayStack<T> {
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

    public T peek() {
        return stack[top];
    }

    public boolean isEmpty() {
        return top == 0;
    }

    public void push(T element) {
        if (isFull()) {
            stack = Arrays.copyOf(stack, stack.length * 2); // expanding Capacity
            System.out.println("Array was full and got expanded by 2");
        }
        stack[top] = element;
        top++;
    }

    public boolean isFull() {
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

//    private T getElementByIndex(int i) {
//        return stack[i];
//    }

    boolean isDuplicated(ArrayStack<T> array, T element) {
        if (array.getLength() == 0) {
            return false;
        }
        for (int i = 0; i < array.size(); i++) {
            if (array.stack[i] == element) {
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
        int mergedArraySize = arr1.size() + arr2.size();

        if (stack.length < mergedArraySize) {
            stack = Arrays.copyOf(stack, mergedArraySize);
        }

        for (int i = 0; i < arr1.size(); i++) {
            boolean duplicated = isDuplicated(this, arr1.stack[i]);
            if (!duplicated)
                this.push(arr1.stack[i]);
        }

        for (int i = 0; i < arr2.size(); i++) {
            boolean duplicated;
            duplicated = isDuplicated(this, arr2.stack[i]);
            if (!duplicated)
                this.push(arr2.stack[i]);
        }
    }
}
