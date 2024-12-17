package LinkedQueues;

public class LinkedQueue<T>{
    private int counter;
    private Node<T> head ;
    private Node<T>  tail;
    //Constructor
    LinkedQueue(){
        head = null;
        tail = null;
        counter = 0;
    }
    //operations
    //size
    int size(){
        return counter;
    }
    //is-empty
    boolean isEmpty(){
        return counter == 0;
    }
    //enqueue -- add element to the tail
    void enqueue(T element){
        Node<T> temp = new Node<>(element);
        if(isEmpty())
            head = temp;
        else
            tail.setNext(temp);
        tail = temp;
        counter++;
    }
    //dequeue -- remove element from the front (head)
    T dequeue() {
        if(isEmpty()){
            System.out.println("the queue is Empty!");
            return null;
        }
        T removedElement = head.getElement();
        head = head.getNext();
        counter--;
        if(isEmpty())
            tail = null;
        return removedElement;
    }
    //first
    T first(){
        if(isEmpty()){
            System.out.println("the queue is Empty!");
            return null;
        }
        return head.getElement();
    }

    //print queue elements
    void display(){
        if(isEmpty())
            System.out.println("the queue is Empty!");
        else {
            Node<T> current = head;
            while(current != null){
                System.out.println(current.getElement());
                current = current.getNext();
            }
        }
    }


    //main method
    public static void main(String[] args) {
        LinkedQueue<String> names = new LinkedQueue<>();
        names.enqueue("ali");
        names.enqueue("mohamed");
        names.enqueue("mucaad");
        names.display();
        System.out.println("size: "  + names.size());
        System.out.println("isempty: "  + names.isEmpty());
        System.out.println("removed: "  + names.dequeue());

        System.out.println("first: "  + names.first());
    }
}
