package concurrency.threading;

public class NewThread extends Thread{
    @Override
    public void run() {
        long startTime = System.currentTimeMillis();
        int i = 0;
        while(true){
            System.out.println(this.getName() + " :New thread is running..." + i++);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
