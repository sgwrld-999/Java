package LinkedListImplementation;

public class LL {
    private Node head ; // Reference variable to the head of the list
    private Node tail ;// Reference variable to the tail of the list
    private int size ; // Size of the list
    public LL(){
        this.size = 0;
    }
    public void insertFirstNode(int val){
        Node node = new Node(val);
        node.next = head ; // Assigning the NULL value to the next of the node
        head = node ; // Assigning the head to the node
        //If the list contains only one node
        //then head and tail points to the same node.
        if(tail == null){
            tail = head ;
        }
        size++;
    }
    //Displaying the list
    public void display(){
        Node temp = head ;
        while(temp != null){
            System.out.print(temp.data + "->");
            temp = temp.next ;
        }
        System.out.println("END");
    }
    //Inserting the node at the end of the list
    public void insertNodeAtLast(int val) {
        //If the list is empty then we'll insert the node at the first position
        if(tail == null){
            insertFirstNode(val);
        }
        else{
            //Creating a new node
            Node node = new Node(val);
            tail.next = node ; // Connecting the tail to the node
            tail = node ;// Assigning the tail to the node
            size++;
        }
    }
    public void insertAtAPosition(int val , int pos){
        //If the position is 0 then we'll insert the node at the first or create a list
        if(pos == 0){
            insertFirstNode(val);
            return ;
        }
        //If the position is greater than the size of the list then we'll insert the node at the last
        if(pos >= size){
            insertNodeAtLast(val);
            return ;
        }

        Node temp = head; // Initializing the temp variable to the head of the list
        for(int i = 1 ; i < pos ; i++){ // i = 1 because we've already initialized the temp to the head of the list which is at the 0th position
            temp = temp.next ; // Traversing the list
        }

        Node node = new Node(val,temp.next); // Creating a new node and assigning the next of the temp to the next of the node
        temp.next = node ; // Assigning the next of the temp to the node
    }
    //Deleting the first node
    public int deleteFirstNode(){
        if(head == null){
            return 0;
        }
        int headValue = head.data ; // Storing the value of the head
        head = head.next ; // Assigning the head to the next of the head
        size--;
        return headValue ;
    }
    //Deleting the last node
    public Node get(int index){
        Node temp = head ;
        for(int i = 0 ; i < index ; i++){
            temp = temp.next ;
        }
        return temp ; // It'll return reference pointer to that node
    }

    public int deleteLastNode(){
        if(head == null){
            return 0;
        }
        Node secondLast = get(size - 2); // Getting the reference pointer to the second last node
        int tailValue = tail.data ; // Storing the value of the tail
        tail = secondLast ; // Assigning the tail to the temp
        tail.next = null ; // Assigning the next of the tail to the NULL
        size--;
        return tailValue ;
    }
    //Deleting the node at a particular position
    public int deleteAtPosition(int idx){
        //If the index is 0 then we'll delete the first node
        if(idx == 0){
            return deleteFirstNode();
        }
        //If the index is greater than the size of the list then we'll delete the last node
        if(idx >= size){
            return deleteLastNode();
        }
        Node prevNode = get(idx-1) ;//Getting a reference pointer to the previous node as we've to connect the previous node to the next of the node to be deleted
        int nodeValue = prevNode.next.data ;
        prevNode.next = prevNode.next.next ;// Connecting the previous node to the next of the node to be deleted
        size--;
        return nodeValue ;
    }
    //Finding a node in the list
    public int find(int val){
        Node temp = head ;
        int idx = 0 ;
        while(temp != null){
            if(temp.data == val){
                return idx ;
            }
            idx++;
            temp = temp.next ;
        }
        return -1 ;
    }
    private class Node {
        private int data ;
        private Node next ;
        // Default Constructor
        Node(){}

        // Constructor Overloading : 1st Constructor
        public Node(int value){
            this.data = value ;
        }
        // Constructor Overloading : 2nd Constructor
        public Node(int value , Node next){
            this.data = value ;
            this.next = next ;
        }
    }

}
