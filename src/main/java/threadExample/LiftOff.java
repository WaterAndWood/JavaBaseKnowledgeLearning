package threadExample;

/**
 * @author wangzhen
 * @creatTime 2022/2/12 4:57 下午
 * @description 实现Runnable接口
 */
public class LiftOff implements Runnable {
    protected int countDown = 10;
    private static int taskCount = 0;
    private final int id = taskCount++;
    public LiftOff() {}
    public LiftOff(int countDown) {
        this.countDown = countDown;
    }

    public String status() {
        return "#" + id + "(" + (countDown > 0 ? countDown : "Liftoff!") + "), ";
    }
    @Override
    public void run() {
        while (countDown-- > 0) {
            System.out.print(status());
            Thread.yield();
        }
    }

    public static void main(String[] args) {
        Thread t = new Thread(new LiftOff());
        t.start();
        /**
         * Thread对象的start()在新线程中执行初始化，调用run()方法，迅速返回，执行输出waiting for Liftoff
         * run()方法在不同的进程中执行，main()线程继续执行，程序同时运行两个方法
         */
        System.out.println("waiting for Liftoff");
    }

}

/**
 * 大概率先输出waiting for Liftoff，程序的调度机制非确定性
 * output:
 * waiting for Liftoff
 * #0(9), #0(8), #0(7), #0(6), #0(5), #0(4), #0(3), #0(2), #0(1), #0(Liftoff!),
 */
