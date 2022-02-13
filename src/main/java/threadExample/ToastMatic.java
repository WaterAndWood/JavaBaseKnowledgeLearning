package threadExample;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class ToastMatic {
    public static void main(String[] args) throws InterruptedException {
        ToastQueue dryQueue = new ToastQueue(),
                butteredQueue = new ToastQueue(),
                finishQueue = new ToastQueue();
        ExecutorService exec = Executors.newCachedThreadPool();
        exec.execute(new Toaster(dryQueue));
        exec.execute(new Butterer(dryQueue, butteredQueue));
        exec.execute(new Jammer(butteredQueue, finishQueue));
        exec.execute(new Eater(finishQueue));
        TimeUnit.MILLISECONDS.sleep(500);
        exec.shutdown();
    }
}
/**
 * output:
 * Toast 0: DRY
 * Toast 0: BUTTERED
 * Toast 0: JAMMED
 * Chomp! Toast 0: JAMMED
 * Toast 1: DRY
 * Toast 1: BUTTERED
 * Toast 1: JAMMED
 * Chomp! Toast 1: JAMMED
 * Toast 2: DRY
 * Toast 2: BUTTERED
 * Toast 2: JAMMED
 * Chomp! Toast 2: JAMMED
 */
