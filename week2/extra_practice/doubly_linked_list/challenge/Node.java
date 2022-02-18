package week2.extra_practice.doubly_linked_list.challenge;

public class Node {
    public Integer value;
    public Node next;
    public Node previous;

    public Node(Integer val) {
        this.value = val;
        this.previous = null;
        this.next = null;
    }
}
