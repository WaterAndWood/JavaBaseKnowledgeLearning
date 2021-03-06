package threadExample;

import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * @author wangzhen
 * @creatTime 2022/2/13 3:18 下午
 * @description TreadLocal
 */
public class ThreadLocalVariableHolder {
    private static ThreadLocal<Integer> value = new ThreadLocal<Integer>() {
        private Random rand = new Random(47);
        @Override
        protected synchronized Integer initialValue() {
            return rand.nextInt(1000);
        }
    };
    public static void increment() {
        value.set(value.get() + 1);
    }
    public static int get() {
        return value.get();
    }

    public static void main(String[] args) throws Exception {
        ExecutorService exec = Executors.newCachedThreadPool();
        for (int i = 0; i < 5; i++) {
            exec.execute(new Accessor(i));
        }
        TimeUnit.SECONDS.sleep(3);
        exec.shutdown();
    }

}
class Accessor implements Runnable {
    private final int id;
    public Accessor(int id) {
        this.id = id;
    }
    @Override
    public void run() {
        while (!Thread.currentThread().isInterrupted()) {
            ThreadLocalVariableHolder.increment();
            System.out.println(this);
            Thread.yield();
        }
    }
    @Override
    public String toString() {
        return "#" + id + ":" + ThreadLocalVariableHolder.get();
    }
}

