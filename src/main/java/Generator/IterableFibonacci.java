package Generator;

import java.util.Iterator;

/**
 * @author wangzhen
 * @creatTime 2022/1/26 10:33 下午
 * @description 适配器实现Iterable接口
 */
public class IterableFibonacci extends Fibonacci implements Iterable<Integer> {
    private int n;
    public IterableFibonacci(int count) {
        n = count;
    }

    @Override
    public Iterator<Integer> iterator() {
        return new Iterator<Integer>() {
            @Override
            public boolean hasNext() {
                return n > 0;
            }

            @Override
            public Integer next() {
                n--;
                return IterableFibonacci.this.next();
            }
        };
    }

    public static void main(String[] args) {
        for(int i : new IterableFibonacci(18)) {
            System.out.print(i + " ");
        }
    }
}

/**
 * output:
 * 1 1 2 3 5 8 13 21 34 55 89 144 233 377 610 987 1597 2584
 */
