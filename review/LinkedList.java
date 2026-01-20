class Node{
    int data;
    Node next;
    Node(int data){
        this.data=data;
        this.next=null;
    }
}
class LinkedList{
    Node head;
    void insertAtHead(int data){
        Node newNode =new Node(data);
        if(head==null){
            head=newNode;
        }
        else{
            newNode.next=head;
            head=newNode;
        }
    }
    void insertAtLast(int data){
        Node newNode=new Node(data);
        if(head==null){
            head=newNode;
        }
        else{
            Node temp=head;
            while(temp.next!=null){
                temp=temp.next;
            }
            temp.next=newNode;
        }
    }
    void insertAtPosition(int data,int position){
        Node newNode=new Node(data);
        if(position==0){
            insertAtHead(data);
        }
        else{
            Node temp=head;
            for(int x=0;x<position-1;x++){
                temp=temp.next;
            }
            newNode.next=temp.next;
            temp.next=newNode;
        }
    }
    void  deleteAtPosition(int position){
        if(head==null){
            System.out.println("List is empty");
            return;
        }
        if(position==0){
            head=head.next;
        }
        else{
            Node temp=head;
            for(int x=0;x<position-1;x++){
                temp=temp.next;
            }
            temp.next=temp.next.next;
        }
    }
    public static void main(String args[]){
        LinkedList list=new LinkedList();
        list.insertAtHead(10);
        list.insertAtLast(20);
        list.insertAtPosition(15,1);
        list.deleteAtPosition(1);
        Node temp=list.head;
        while(temp!=null){
            System.out.print(temp.data+" ");
            temp=temp.next;
        }
    }
}