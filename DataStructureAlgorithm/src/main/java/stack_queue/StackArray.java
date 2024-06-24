package stack_queue;

public class StackArray implements IStack{
    private int[] array;
    private int size;

    private int topIndex = -1;

    public StackArray(int size) {
        this.size = size;
        array = new int[size];
        topIndex = 0;
    }

    @Override
    public boolean push(int value) {
        if(isFull())
            return false;

        topIndex++;
        array[topIndex] = value;
        return true;
    }

    @Override
    public int pop() {
        if(isEmpty())
            return -1;
        return array[topIndex--];
    }

    @Override
    public boolean isFull() {
        return topIndex == size - 1;
    }

    @Override
    public boolean isEmpty() {
        return topIndex < 0;
    }

    @Override
    public void show() {
        if(isEmpty())
            System.out.println("Stack is empty");
        else{
            for (int i = 0; i <= topIndex; i++) {
                System.out.print(array[i] + " ");
            }
            System.out.println();
        }
    }
}
