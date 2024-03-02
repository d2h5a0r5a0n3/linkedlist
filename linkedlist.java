class Node {
    int data;
    Node next;

    Node(int data) {
        this.data = data;
        this.next = null;
    }
}

class linkedlist {
    static void PrintList(Node head) {
        Node current = head;
        for (; current.next != null; current = current.next) {
            System.out.printf("[" + current.data + "," + current.next + "]" + "->");
        }
        System.out.printf("[" + current.data + "," + current.next + "]");
        System.out.println();
    }

    static Node InsertatFirst(int data, Node head) {
        Node newNode = new Node(data);

        newNode.next = head;
        head = newNode;
        return head;
    }

    static Node InsertatLast(int data, Node head) {
        Node newNode = new Node(data);
        Node current = head;
        if(current==null){
            head=newNode;
        }
        else{
            for (; current.next != null; current = current.next);
            current.next = newNode;
        }
        return head;
    }

    static Node InsertatMid(int data, Node head, int pos) {
        if (pos == 0) {
            head = InsertatFirst(data, head);
        } else {
            try {
                Node newNode = new Node(data);

                Node current = head;
                for (int i = 1; i < pos; i++) {
                    current = current.next;
                }
                newNode.next = current.next;
                current.next = newNode;
            } catch (Exception e) {
                System.out.println("List Out of bounds");
            }
        }
        return head;
    }

    static Node DeleteatEnd(Node head) {
        Node current = head;
        for (; current.next.next != null; current = current.next)
            ;
        current.next = null;
        return head;
    }

    static Node DeleteatFirst(Node head) {
        head = head.next;
        return head;
    }

    static Node DeleteatMid(Node head, int pos) {
        Node current = head;
        if (pos == 1) {
            head = DeleteatFirst(head);
        } else {
            try {
                for (int i = 1; i < pos - 1; i++) {
                    current = current.next;
                }
                current.next = current.next.next;
            } catch (Exception e) {
                System.out.println("List Out of bounds");
            }
        }
        return head;
    }

    static Node Reverse(Node head) {
        Node prev = null;
        Node current = head;
        Node nextt = null;
        while (current != null) {
            nextt = current.next;
            current.next = prev;
            prev=current;
            current=nextt;
        }
        return prev;
    }

    public static void main(String[] args) {
        Node head = null;
        head = InsertatFirst(40, head);
        head = InsertatFirst(46, head);
        head = InsertatFirst(69, head);

        PrintList(head);

        head = InsertatLast(30, head);
        head = InsertatLast(20, head);

        PrintList(head);

        head = InsertatMid(10, head, 0);

        PrintList(head);

        head = DeleteatEnd(head);

        PrintList(head);

        head = DeleteatFirst(head);

        PrintList(head);

        head = DeleteatMid(head, 3);

        PrintList(head);

        head = Reverse(head);

        PrintList(head);
    }
}
