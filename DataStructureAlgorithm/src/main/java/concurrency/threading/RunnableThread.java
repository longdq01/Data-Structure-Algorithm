package concurrency.threading;

public class RunnableThread implements Runnable{
    @Override
    public void run() {
        long startTime = System.currentTimeMillis();
        int i = 0;
        while(true){
            System.out.println(":New thread is running..." + i++);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
