package LinkedListImplementation;

public class Main {
    public static void main(String[] args) {
        LL list = new LL();
        for(int i = 0 ; i < 10 ; i++){
            list.insertFirstNode(i);
        }
        list.display();
        list.insertNodeAtLast(10);
        list.display();
        list.insertAtAPosition(11,1);
        list.insertAtAPosition(12,6);
        list.display();
        System.out.println(list.deleteFirstNode());
        list.display();
        System.out.println(list.deleteLastNode());
        list.display();
        System.out.println(list.deleteAtPosition(2));
        list.display();
        System.out.println("The element is at idx : " + list.find(6));
    }

}
