package Generator;

/**
 * @author wangzhen
 * @creatTime 2022/1/26 9:49 下午
 * @description 生成器生成Fibonacci数列
 */
public class Fibonacci implements Generator<Integer> {
    private int count = 0;

    private int fib(int n) {
        if (n < 2) {
            return 1;
        }
        return fib(n - 1) + fib(n - 2);
    }

    @Override
    public Integer next() {
        return fib(count++);
    }

    public static void main(String[] args) {
        Fibonacci fibonacci = new Fibonacci();
        for(int i = 0; i < 18; i++) {
            System.out.print(fibonacci.next() + " ");
        }
    }
}
/**
 * output:
 * 1 1 2 3 5 8 13 21 34 55 89 144 233 377 610 987 1597 2584
 */
