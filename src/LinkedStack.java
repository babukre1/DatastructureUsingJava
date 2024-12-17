public class LinkedStack<T> {
    // top
    // count
    // constructor count:0 and top:null

    private int count;
    private Node<T> top;

    public LinkedStack() {
        count = 0;
        top = null;
    }

    // size
    public int size() {
        return count;
    }

    // push
    public void push(T element) {
        // create new node.
        Node<T> temp = new Node<>(element);
        // set next to the current top element.
        temp.setNext(top);
        // set your top to the element you pushed to your linked stack....
        top = temp;
        count++;
    }

    // pop
    public T pop() {
        if (isEmpty()) {
            System.out.println("empty stack");
            return null;
        }
        T removed = top.getElement();
        top = top.getNext();
        count--;
        return removed;
    }

    // peek
    public T peek() {
        if (isEmpty()) {
            System.out.println("stack ois empty");
            return null;
        }
        return top.getElement();
    }

    // isEmpty
    public boolean isEmpty() {
        return top == null;
    }

    // print stack elements
    void display() {
        if (!isEmpty()) {
            Node<T> currentAddress = top;
            while (currentAddress != null) {
                System.out.println(currentAddress.getElement());
                currentAddress = currentAddress.getNext();
            }
        } else System.out.println("Empty stack");
    }

    void search(T element) {
        int counter = 0;


    }

    public static void main(String[] args) {
        LinkedStack<String> linkedStack = new LinkedStack<>();
        linkedStack.push("abubakr");
        linkedStack.push("ahmed");
        linkedStack.push("yasir");
        linkedStack.display();
    }

}
