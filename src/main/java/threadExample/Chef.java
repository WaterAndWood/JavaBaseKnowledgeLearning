package threadExample;

import java.util.concurrent.TimeUnit;

/**
 * @author wangzhen
 * @creatTime 2022/2/13 6:28 下午
 * @description 模拟生产者
 */
public class Chef implements Runnable {
    private Restaurant restaurant;
    private int count = 0;
    public Chef(Restaurant r) {
        this.restaurant = r;
    }
    @Override
    public void run() {
        try {
            while (!Thread.interrupted()) {
                synchronized (this) {
                    while (restaurant.meal != null) {
                        wait();
                    }
                }
                if (++count == 10) {
                    System.out.println("Out of food, closing");
                    restaurant.exec.shutdownNow();
                }
                System.out.print("Order up ");
                synchronized (restaurant.waitPerson) {
                    restaurant.meal = new Meal(count);
                    restaurant.waitPerson.notifyAll();
                }
                TimeUnit.MILLISECONDS.sleep(1000);
            }
        } catch (InterruptedException e) {
            System.out.println("Chef interrupted");
        }
    }
}
/**
 * output:
 * Order up WaitPerson got Meal 1
 * Order up WaitPerson got Meal 2
 * Order up WaitPerson got Meal 3
 * Order up WaitPerson got Meal 4
 * Order up WaitPerson got Meal 5
 * Order up WaitPerson got Meal 6
 * Order up WaitPerson got Meal 7
 * Order up WaitPerson got Meal 8
 * Order up WaitPerson got Meal 9
 * Out of food, closing
 * Order up WaitPerson interupted
 * Chef interrupted
 */

