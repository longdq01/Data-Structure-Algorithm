package concurrency.threading;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService executor = Executors.newFixedThreadPool(1);
        RunnableThread runnableThread = new RunnableThread();
        executor.submit(runnableThread);
        executor.shutdown();
    }
}
