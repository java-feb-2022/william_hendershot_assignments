package week2.extra_practice.singly_linked_list;

public class SinglyLinkedList<E> {
    private Node<E> head;
    public SinglyLinkedList() {
        
    }

    public void add(int value) {
        Node<E> newNode = new Node<E>(value);
        if(head == null) {
            head = newNode;
        } else {
            Node<E> runner = head;
            while(runner.getNext() != null) {
                runner = runner.getNext();
            }
            runner.setNext(newNode);
        }
    }

    public E remove() {
        E value = head.getValue();
        head = head.getNext();
        return value;
    }

    public void printValues() {
        String result = "[";
        Node<E> runner = this.head;
        if (runner != null) {
            result += runner.getValue();
            while (runner.getNext() != null) {
                runner = runner.getNext();
                result += String.format(", %s", runner.getValue());
            }
        }
        result += "]";
        System.out.println(result);
    }
}
