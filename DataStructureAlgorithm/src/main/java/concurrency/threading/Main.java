package concurrency.threading;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Main {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService executor = Executors.newFixedThreadPool(1);
        CallableThread myCallable = new CallableThread();
        Future<String> future = executor.submit(myCallable);
        System.out.println(future.get());
        executor.shutdown();
    }
}
