package stack_queue;

public class QueueLinkedList implements IQueue{
    private ListNode head;
    private ListNode tail;

    @Override
    public boolean push(int value) {
        if(isEmpty()){
            head = tail = new ListNode(value);
        }else{
            ListNode node = new ListNode(value);
            tail.next = node;
            tail = node;
        }
        return true;
    }

    @Override
    public int pop() {
        if(isEmpty()){
            return -1;
        }
        int value = head.value;
        if(head == tail){
            head = tail = null;
        }else{
            head = head.next;
        }
        return value;
    }

    @Override
    public boolean isFull() {
        return false;
    }

    @Override
    public boolean isEmpty() {
        return head == null && tail == null;
    }

    @Override
    public void show() {
        if(isEmpty()){
            System.out.println("Queue is empty");
            return;
        }

        ListNode temp = head;
        while(temp != null){
            System.out.print(temp.value + " ");
            temp = temp.next;
        }
        System.out.println();
    }
}
