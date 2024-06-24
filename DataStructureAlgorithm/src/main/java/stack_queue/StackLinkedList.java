package stack_queue;

public class StackLinkedList implements IStack{
    private ListNode head;

    @Override
    public boolean push(int value) {
        if(head == null){
            head = new ListNode(value);
        }else{
            ListNode node = new ListNode(value);
            node.next = head;
            head = node;
        }
        return true;
    }

    @Override
    public int pop() {
        if(isEmpty()){
            return -1;
        }
        int value = head.value;
        head = head.next;
        return value;
    }

    @Override
    public boolean isFull() {
        return false;
    }

    @Override
    public boolean isEmpty() {
        return head == null;
    }

    @Override
    public void show() {
        if(isEmpty()){
            System.out.println("Stack is empty");
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
