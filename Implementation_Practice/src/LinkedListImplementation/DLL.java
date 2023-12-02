package LinkedListImplementation;

public class DLL {
    private Node head ;
    //Finding a node index in the DLL
    public int findNode(int val){
        Node temp = head ;
        int index = 0 ;
        while(temp != null){
            if(temp.val == val){
                return index ;
            }
            temp = temp.next ;
            index++ ;
        }
        //If value is not found then return -1
        return -1 ;
    }
    //Insertion first
    public void inertFirst(int val){
        Node node = new Node(val) ;//Crating a new node
        node.next = head ; // Assigning the next of the new node to the head
        node.prev = null ; // Assigning the prev of the new node to null
        if(head != null){ // If the head is not null then assign the prev of the head to the new node
            head.prev = node ; // Assigning the prev of the head to the new node
        }
        head = node ;// Assigning the head to the new node
    }
    //Inserting at a particular index
    public void insertAtPosition(int val,int position){
        Node node = new Node(val);
        Node temp = head ;

        for(int i = 0 ; i < position ; i++){
            temp = temp.next ;
        }
        node.next = temp.next ;
        temp.next.prev = node ;
        temp.next = node ;
        node.prev = temp ;
    }
    //Insertion at the end
    public void insetATEnd(int val){
        Node node = new Node(val);
        Node last = head ;
        node.next = null ; // As the new node will be the last node so its next will be null
        //Means the list is empty
        if(head == null){
            node.prev = null ;
            head = node ;
            return ;
        }
        //Taking the last pointer to the last node
        while(last.next != null){
            last = last.next ;
        }
        last.next = node ; // Assigning the next of the last node to the new node
        node.prev = last ; // Assigning the prev of the new node to the last node

    }
    //Insertion after a particular node
    public void insertAfterNode(int nodeVal,int val){
        int idx = findNode(nodeVal) ;
        if(idx == -1){
            System.out.println("Node not found");
            return ;
        }
        Node node = new Node(val);
        Node temp = head ;
        for(int i = 0 ; i < idx ; i++){
            temp = temp.next ;
        }
        node.next = temp.next ;
        temp.next.prev = node ;
        temp.next = node ;
        node.prev = temp ;
    }
    //Printing the DLL
    public void display(){
        Node temp = head ;
        while(temp != null){
            System.out.print(temp.val + "-->");
            temp = temp.next ;
        }
        System.out.println("END");
    }
    //Printing in reverse order
    public void displayInReverse(){
        Node temp = head ;
        Node curr = null ;
        while(temp != null){
            curr = temp ;
            temp = temp.next ;
        }
        System.out.print("START");
        while(curr != null){
            System.out.print("<--" + curr.val);
            curr = curr.prev ;
        }

    }
    //Properties of the DLL
    private class Node{
        int val ;
        Node next ;
        Node prev ;

        Node(int val){
            this.val = val ;
        }
        Node(int val,Node next, Node prev){
            this.val  = val ;
            this.next = next ;
            this.prev = prev ;
        }
    }
}
