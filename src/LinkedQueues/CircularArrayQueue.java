package LinkedQueues;

import java.util.EmptyStackException;

public class CircularArrayQueue<T> {
    private final static int DEFAULT_CAPACITY = 3;
    private int front, rear, count;
    private T[] queue;

    public CircularArrayQueue(int initialCapacity) {
        front = rear = count = 0;
        queue = (T[]) new Object[initialCapacity];
    }

    public CircularArrayQueue() {
        this(DEFAULT_CAPACITY);
    }

    // enqueue

    void enqueue(T element) {
        if (queue.length == count) {
            expandCapacity();
        }
        queue[rear] = element;
        rear = (rear + 1) % queue.length;
        count++;
    }

    // dequeue
    T dequeue() {
        if (isEmpty()) {
            throw new EmptyStackException();
        }
        T result = queue[front];
        queue[front] = null;
        front = (front + 1) % queue.length;
        count--;
        return result;
    }

    // size
    int size() {
        return count;
    }

    //isEmpty
    boolean isEmpty() {
        return count == 0;
    }
    // printQueue

    void printqueue() {
        if (isEmpty()) {
            throw new EmptyStackException();
        }
        int index = front;

        for (int i = 0; i < count; i++) {
            System.out.println(queue[index] + " ");
            index = (index + 1) % queue.length;
        }

    }

    void expandCapacity() {
        T[] expandedArray = (T[]) new Object[queue.length * 2];

        for (int i = 0; i < count; i++) {
            expandedArray[i] = queue[front];
            front = (front + 1) % queue.length;
        }
        front = 0;
        rear = count;
        queue = expandedArray;
    }

    void searchElements(T element) {
        int index = front;
        int elementsFound = 0;
        StringBuffer result = new StringBuffer();
        for (int i = 0; i < count; i++) {
            if (queue[index] == element) {
                elementsFound++;
                if (elementsFound > 1) result.append(", ");
                result.append(index);

            }
            index = (index + 1) % queue.length;
        }
        System.out.println("element " + element + " found " + elementsFound + " times at indexe " + result);
    }

    public static void main(String[] args) {
        CircularArrayQueue<String> names = new CircularArrayQueue<>(5);
        names.enqueue("Cristiano");
        names.enqueue("Ramos");
        names.enqueue("Palmer");
        names.enqueue("Dialo");
        names.enqueue("Ramos");
        names.enqueue("Salah");

        names.searchElements("Ramos");
    }
}