package linkedlist;

public class MyLinkedList {
    public static class Node{
        int value;
        Node next;
        Node(int value){
            this.value = value;
        }
    }

    public static void printLinkedList(Node head){
        if(head == null){
            System.out.println("List is empty!");
        }else{
            Node temp = head;
            while(temp != null){
                System.out.print(temp.value);
                temp = temp.next;
                if(temp != null){
                    System.out.print("->");
                }else{
                    System.out.println();
                }
            }
        }
    }

    public static Node addToHead(Node headNode, int value){
        Node newNode = new Node(value);
        if(headNode != null){
            newNode.next = headNode;
        }
        return newNode;
    }

    public static Node addToTail(Node head, int value){
        Node newNode = new Node(value);

        if(head == null)
            return newNode;
        Node last = head;
        while(last.next != null){
            last = last.next;
        }
        last.next = newNode;
        return head;
    }

    public static Node addToIndex(Node head, int value, int index){
        if(index == 0){
            return addToHead(head, value);
        }
        Node curNode = head;
        int count = 0;
        while(curNode != null){
            count++;
            if(count == index){
                Node newNode = new Node(value);
                newNode.next = curNode.next;
                curNode.next = newNode;
                break;
            }
            curNode = curNode.next;
        }
        return head;
    }

    public static Node removeHeadNode(Node head){
        if(head != null){
            return head.next;
        }
        return null;
    }

    public static Node removeTailNode(Node head){
        if(head != null){
            Node tail = head;
            Node tmp = null;
            while(tail.next != null){
                tmp = tail;
                tail = tail.next;
            }
            if(tmp == null){
                return null;
            }else{
                tmp.next = null;
            }
        }
        return head;
    }

    public static Node removeNode(Node head, int index){
        if(index < 0){
            return head;
        }
        if(head == null){
            return null;
        }
        if(index == 0)
            return removeHeadNode(head);

        Node current = head;
        Node previous = null;
        int count = 0;
        boolean bIsFound = false;
        while(current != null){
            if(count == index){
                bIsFound = true;
                break;
            }
            previous = current;
            current = current.next;
            count++;
        }
        if(bIsFound){
            if(previous == null){
                return null;
            }else{
                if(current != null){
                    previous.next = current.next;

                }
            }
        }

        return head;
    }


    public static void main(String[] args) {
        Node n1 = new Node(1);
        Node n2 = new Node(2);
        Node n3 = new Node(3);
        n1.next = n2;
        n2.next = n3;
        printLinkedList(n1);
        n1 = addToHead(n1, 0);
        printLinkedList(n1);
        n1 = addToTail(n1, 4);
        printLinkedList(n1);
        n1 = addToIndex(n1, 10, 1);
        printLinkedList(n1);
        n1 = removeHeadNode(n1);
        printLinkedList(n1);
        n1 = removeTailNode(n1);
        printLinkedList(n1);
        n1 = removeNode(n1, 0);
        printLinkedList(n1);
        n1 = removeNode(n1, 2);
        printLinkedList(n1);

    }
}
