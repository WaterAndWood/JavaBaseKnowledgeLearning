package Wildcard;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author wangzhen
 * @creatTime 2022/2/3 10:23 下午
 * @description 通配符super写
 */
public class GenericWriting {
    static <T> void writeExact(List<T> list, T item) {
        list.add(item);
    }

    static List<Apple> apples = new ArrayList<Apple>();
    static List<Fruit> fruits = new ArrayList<Fruit>();

    static void f1() {
        writeExact(apples, new Apple());
        // 也可以将Apple放置到fruits，按理来说应该是报错的
        writeExact(fruits, new Apple());
    }

    /**
     * List<? super T>将持有从T导出的某种类型，可以将T类型对象或者从T导出的任何对象传递给List
     * @param list
     * @param item
     * @param <T>
     */
    static <T> void writeWithWildcard(List<? super T> list, T item) {
        list.add(item);
    }

    static void f2() {
        writeWithWildcard(apples, new Apple());
        writeWithWildcard(fruits, new Apple());
//        writeWithWildcard(apples, new Fruit());
    }

    public static void main(String[] args) {
        f1();
        f2();
    }
}
