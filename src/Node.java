public class Node<T> {
    private T element;
    private Node<T> next;

    public Node() {
        element = null;
        next = null;
    }

    public Node(T element) {
        this.element = element;
        next = null;
    }

    public void setNext(Node<T> next) {
        this.next = next;
    }

    public Node<T> getNext() {
        return next;
    }

    public T getElement() {
        return element;
    }
    // set element


    public void setElement(T element) {
        this.element = element;
    }

}
