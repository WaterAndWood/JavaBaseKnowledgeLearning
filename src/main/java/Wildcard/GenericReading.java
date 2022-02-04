package Wildcard;

import java.util.ArrayList;
import java.util.List;

public class GenericReading {
    /**
     * 对于返回值，静态的泛型方法适用于每个方法调用
     */
    static <T> T readExact(List<T> list) {
        return list.get(0);
    }
    static List<Apple> apples = new ArrayList<Apple>();
    static List<Fruit> fruits = new ArrayList<Fruit>();

    static void f1() {
        Apple a = readExact(apples);
        Fruit f = readExact(fruits);
        f = readExact(apples);
    }

    /**
     * 泛型类创建时需要确定参数
     */
    static class Reader<T> {
        T readExact(List<T> list) {
            return list.get(0);
        }
    }

    static void f2() {
        Reader<Fruit> fruitReader = new Reader<Fruit>();
        // 可以从List<Fruit>中读取Fruit，但不允许List<Apple>中产生Fruit对象
        Fruit f = fruitReader.readExact(fruits);
//        Fruit a = fruitReader.readExact(apples);
    }

    static class CovariantReader<T> {
        // 从列表中读取一个T是安全的，对象至少是一个T，可能是从T导出的某种对象
        T readCovariant(List<? extends T> list) {
            return list.get(0);
        }
    }

    static void f3() {
        CovariantReader<Fruit> coFruitReader = new CovariantReader<Fruit>();
        Fruit f = coFruitReader.readCovariant(fruits);
        Fruit a = coFruitReader.readCovariant(apples);
    }

    static void f4() {
        CovariantReader<Apple> covariantReader = new CovariantReader<Apple>();
        Apple a = covariantReader.readCovariant(apples);
//        Fruit f = covariantReader.readCovariant(fruits);
    }

    public static void main(String[] args) {
        f1();
        f2();
        f3();
        f4();
    }

}
