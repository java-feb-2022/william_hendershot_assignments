package week2.extra_practice.doubly_linked_list;

public class DLL {
    public Node head;
    public Node tail;
    public int size;
    
    public DLL() {
        this.head = null;
        this.tail = null;
        this.size = 0;
    }
    
    // the push method will add a new node to the end of the list
    public void push(Node newNode) {
        // if there is no head in the list, aka, an empty list, we set the newNode to be the head and tail of the list
        if(this.head == null) {
            this.head = newNode;
            this.tail = newNode;
            this.size++;
            return;
        }
        
        // first find the lastNode in the list
        // then, set the lastNode's next to be the newNode;
        // then, we have to set the previous of the lastNode to the lastNode that we found previously.
        // finally, set the list's tail to be the node that we have added
        Node lastNode = this.tail;
        lastNode.next = newNode;
        newNode.previous = lastNode;
        this.tail = newNode;
        this.size++;
    }
    
    public void printValuesForward() {
        // find the first node, aka head.
        Node current = this.head;
        
        // while the current node exists...
        while(current != null) {
            // print it's value
            System.out.println(current.value);
            // and move on to it's next node.
            current = current.next;
        }
    }

    public void printValuesBackward() {
        Node current = this.tail;
        while (current != null) {
            System.out.println(current.value);
            current = current.previous;
        }
    }

    public Integer pop() {
        if (this.size  > 0){
            Node result = this.tail;
            if (this.head == this.tail) {
                this.head = null;
                this.tail = null;
            } else {
                this.tail.previous.next = null;
                this.tail = this.tail.previous;
            }
            size--;
            return result.value;
        }

        throw new IllegalStateException("Nothing to pop!");
    }

    public int size() {
        return this.size;
    }

    public boolean contains (int value) {
        boolean found = false;
        Node current = this.head;
        while (!found && current != null){
            found = value == current.value;
            current = current.next;
        }
        return found;
    }
}

