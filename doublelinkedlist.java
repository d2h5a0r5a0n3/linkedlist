class Node{
    Node prev;
    int data;
    Node next;

    Node(int data){
        this.prev=null;
        this.data=data;
        this.next=null;
    } 
}

class doublelinkedlist{

    static void print(Node head){
        Node curr=head;
        try{
            for(;curr.next!=null;curr=curr.next){
                System.out.print("["+curr.prev+","+curr.data+","+curr.next+"]-->");
            }
            System.out.print("["+curr.prev+","+curr.data+","+curr.next+"]");
            System.out.println("err");
        }
        catch(Exception e){
            System.out.println("linkedlist is empty");
        }
    }

    static Node insertatfirst(int data,Node head){
        Node newNode=new Node(data);
        newNode.next=head;
        newNode.prev=null;
        if(head!=null)     {
            head.prev=newNode;
        }
        head=newNode;
        return head;
    }

    static Node insertatlast(int data,Node head ){
        Node newNode=new Node(data);
        Node curr=head;
        for(;curr.next!=null;curr=curr.next);
        curr.next=newNode;
        newNode.prev=curr;
        return head;
    }

    static Node insertatmid(int data,Node head,int pos){
        Node curr=head;
        try{
            for(int i=1;i<pos;i++){
                curr=curr.next;
            }
            if(curr.next==null){
                head=insertatlast(data,head);
            }
            else if(curr.prev==null){
                head=insertatfirst(data,head);
            }
            else{
                Node newNode=new Node(data);
                newNode.next=curr.next;
                curr.next.prev=newNode;
                newNode.prev=curr;
                curr.next=newNode;
            }
        }
        catch(Exception e){
            System.out.println("list out bounds");
        }
        return head;
    }

    static Node deletefirst(Node head)
    {   
       try{
        Node curr=head;
        head=head.next;
        head.prev=null;
        curr.next=null;
       }
       catch(Exception e){
        System.out.println("linkedlist is empty");
       }
       return head;
    }

    static Node deletelast(Node head){
        try{
            Node curr=head;
            if(curr.next==null){
                head=null;
            }
            else{
                for(;curr.next.next!=null;curr=curr.next);
                curr.next.prev=null;
                curr.next=null;
            }
        }
        catch(Exception e){
            System.out.println("linkedlist is empty");
        }
        return head;
    }

    static Node deletemid(Node head,int pos){
        try{
            Node curr=head;
        for(int i=1;i<pos;i++){
            curr=curr.next;
        }
        if(pos==1){
            head=deletefirst(head);
        }
        else{
            curr.prev.next=curr.next;
        curr.next.prev=curr.prev;
        curr.prev=null;
        curr.next=null; 
        }
        } 
        catch(Exception e){
            System.out.println("linkedlist is out of bounds");
        }
        return head;
    }

    static Node reverse(Node head){
        Node curr=head;
        Node prev=null;
        Node nextt=null;
        for(;curr!=null;){
            nextt=curr.next;
            curr.next=prev;
            curr.prev=nextt;
            prev=curr;
            curr=nextt;
        }
        head=prev;
        return head;
    }

    public static void main(String args[]){
        Node head=null;

        head=insertatfirst(50,head);
        head=insertatfirst(30,head);
        head=insertatfirst(20,head);
        head=insertatfirst(10,head);

        //print(head);

        head=insertatlast(60,head);

        //print(head);

        head=insertatmid(40,head,3);

        // //print(head);

        // head=deletefirst(head);

        // //print(head);

        // head=deletelast(head);

        // print(head);

        // head=deletemid(head,1);

        print(head);

        head=reverse(head);

        print(head);
    }
}
