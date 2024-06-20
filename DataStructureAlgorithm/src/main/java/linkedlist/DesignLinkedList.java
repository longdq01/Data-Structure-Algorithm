package linkedlist;

public class DesignLinkedList {
    static class Node{
        int val;
        Node next;

        public Node(int val) {
            this.val = val;
        }
    }

    static class MyLinkedList {
        private Node headNode;

        public MyLinkedList() {
            this.headNode = null;
        }

        public int get(int index) {
            if(headNode == null)
                return -1;
            int count = 0;
            Node currentNode = headNode;
            while(currentNode != null){
                if(index == count){
                    return currentNode.val;
                }
                currentNode = currentNode.next;
                count++;
            }
            return -1;
        }

        public void addAtHead(int val) {
            Node node = new Node(val);
            node.next = headNode;
            headNode = node;
        }

        public void addAtTail(int val) {
            Node node = new Node(val);
            if(headNode == null)
                headNode = node;
            else{
                Node lastNode = headNode;
                while(lastNode.next != null)
                    lastNode = lastNode.next;
                lastNode.next = node;
            }
        }

        public void addAtIndex(int index, int val) {
            if(index == 0){
                addAtHead(val);
                return;
            }
            int count = 0;
            Node currentNode = headNode;
            while(currentNode != null){
                count++;
                if(index == count){
                    Node node = new Node(val);
                    node.next = currentNode.next;
                    currentNode.next = node;
                    return;
                }
                currentNode = currentNode.next;
            }
        }

        public void deleteAtIndex(int index) {
            if(headNode == null)
                return;

            if(index == 0){
                headNode = headNode.next;
                return;
            }

            Node currentNode = headNode.next;
            Node previousNode = headNode;
            int idx = 1;
            while(currentNode != null){
                if(idx == index){
                    previousNode.next = currentNode.next;
                    return;
                }
                previousNode = currentNode;
                currentNode = currentNode.next;
                idx++;
            }

        }
    }

    public static void main(String[] args) {
        MyLinkedList myLinkedList = new MyLinkedList();
        myLinkedList.addAtHead(1);
        myLinkedList.addAtTail(3);
        myLinkedList.addAtIndex(1, 2);    // linked list becomes 1->2->3
        myLinkedList.get(1);              // return 2
        myLinkedList.deleteAtIndex(1);    // now the linked list is 1->3
        myLinkedList.get(1);
    }
}
