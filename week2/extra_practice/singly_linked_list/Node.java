package week2.extra_practice.singly_linked_list;

public class Node<E> {
    
    private Object value;
    private Node<E> next;

    public Node(Object value) {
        this.value = value;
    }

    @SuppressWarnings("unchecked")
    public E getValue() {
        return (E) value;
    }

    public void setValue(Object value) {
        this.value = value;
    }

    public Node<E> getNext() {
        return next;
    }

    public void setNext(Node<E> next) {
        this.next = next;
    }
}
