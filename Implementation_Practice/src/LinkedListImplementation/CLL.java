package LinkedListImplementation;

public class CLL {
    private Node head ;
    private Node tail ;
    public CLL(){
        this.head = null ;
        this.tail = null ;
    }
    public void insertAtFirst(int val){
        Node node = new Node(val) ;
        if(head == null){
            head = node;
            tail = node ;
            node.next = head ;
        }
        else{
            node.next = head ;
            head  = node ;
            tail.next = head ;
        }
    }
    public void insertAtPos(int val,int pos){
        Node node = new Node(val) ;
        if(pos == 1 || head == null){
            insertAtFirst(val);
        }
        else{
            Node temp = head ;
            for(int i = 1 ; i < pos - 1 ; i++){
                temp = temp.next ;
            }
            node.next = temp.next ;
            temp.next = node ;
        }
    }
    public void delete(int val){
        Node temp = head ;
        if(head.data == val){
            head = head.next;
            tail.next = head ;
        }
        else{
            while(temp.next.data != val){
                temp = temp.next ;
            }
            temp.next = temp.next.next ;
        }
    }
    public void display(){
        Node temp = head ;
        while(temp.next != head){
            System.out.print(temp.data + "->");
            temp = temp.next ;
        }
        System.out.println(temp.data);
    }
    private class Node{
        int data ;
        Node next ;
        Node(int val){
            this.data = val ;
        }
        public Node(int val,Node next){
            this.data = val ;
            this.next = next ;
        }
    }
}
