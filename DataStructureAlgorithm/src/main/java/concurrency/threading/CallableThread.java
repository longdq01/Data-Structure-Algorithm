package concurrency.threading;

import java.util.concurrent.Callable;

public class CallableThread implements Callable<String> {
    @Override
    public String call() throws Exception {
        return "Callable thread is done";
    }
}
