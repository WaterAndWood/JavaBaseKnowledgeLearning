package Generator;

import java.util.ArrayList;
import java.util.Collection;

/**
 * @author wangzhen
 * @creatTime 2022/1/31 10:53 下午
 * @description 利用生成器填充Collection
 */
public class Generators {
    public static <T> Collection<T> fill(Collection<T> col, Generator<T> gen, int n) {
        for (int i = 0; i < n; i++) {
            col.add(gen.next());
        }
        return col;
    }

    public static void main(String[] args) {
        Collection<Integer> fNumbers = fill(new ArrayList<Integer>(), new Fibonacci(), 11);
        for (int i : fNumbers) {
            System.out.print(i + " ");
        }
    }
}
/**
 *output:
 *1 1 2 3 5 8 13 21 34 55 89
 *
 */