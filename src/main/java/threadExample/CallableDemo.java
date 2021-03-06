package threadExample;

import java.util.*;
import java.util.concurrent.*;

public class CallableDemo {
    public static void main(String[] args) {
        ExecutorService exec = Executors.newCachedThreadPool();
        ArrayList<Future<String>> results = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            results.add(exec.submit(new TaskWithResult(i)));
        }
        for (Future<String> future : results) {
            try {
                System.out.println(future.get());
            } catch (InterruptedException e) {
                System.out.println(e);
            } catch (ExecutionException e) {
                System.out.println(e);
            } finally {
                exec.shutdown();
            }
        }
    }
}

class TaskWithResult implements Callable<String> {
    private int id;
    public TaskWithResult(int id) {
        this.id = id;
    }
    @Override
    public String call() {
        return "result of TaskWithResult " + id;
    }
}

/**
 * output:
 * result of TaskWithResult 0
 * result of TaskWithResult 1
 * result of TaskWithResult 2
 * result of TaskWithResult 3
 * result of TaskWithResult 4
 * result of TaskWithResult 5
 * result of TaskWithResult 6
 * result of TaskWithResult 7
 * result of TaskWithResult 8
 * result of TaskWithResult 9
 */
