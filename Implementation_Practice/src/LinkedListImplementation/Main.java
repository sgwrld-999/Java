package LinkedListImplementation;

public class Main {
    public static void main(String[] args) {
//        DLL dll = new DLL() ;
//        for(int i = 0 ; i < 10 ; i++){
//            dll.inertFirst(i);
//        }
//        dll.display();
////        dll.displayInReverse();
////        dll.insetATEnd(10);
////        dll.display();
////        dll.insertAtPosition(11, 5);
//        dll.findNode(5);
//        dll.insertAfterNode(6, 3);
//        dll.display();
        CLL cll = new CLL() ;
        for(int i = 0 ; i < 10 ; i++){
            cll.insertAtFirst(i);
        }
        cll.display();
        cll.insertAtPos(10, 5);
        cll.display();
        cll.delete(5);
        cll.display();

    }

}
