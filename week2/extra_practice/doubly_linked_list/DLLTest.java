package week2.extra_practice.doubly_linked_list;

public class DLLTest {
    public static void main(String[] args) {
        DLL dll = new DLL();
        Node n1 = new Node(10);
        Node n2 = new Node(20);
        Node n3 = new Node(50);
        Node n4 = new Node(60);
        Node n5 = new Node(80);
        Node n6 = new Node(100);
        
        dll.push(n1);
        dll.push(n2);
        dll.push(n3);
        dll.push(n4);
        dll.push(n5);
        dll.push(n6);
        
        dll.printValuesForward();
        System.out.println();
        dll.printValuesBackward();
        System.out.println();
        System.out.println(dll.pop());
        System.out.println();
        dll.printValuesBackward();
        dll.printValuesForward();

        System.out.println();
        System.out.println(dll.size());

        System.out.println();
        System.out.println("Does 10 exist within the list?");
        System.out.println(dll.contains(10));
        System.out.println();
        System.out.println("Does 110 exist within the list?");
        System.out.println(dll.contains(110));
    }
}