package Wildcard;


import java.util.ArrayList;
import java.util.List;

/**
 * @author wangzhen
 * @creatTime 2022/2/3 4:51 下午
 * @description 实际数组类型是Apple[]，应该只能放入Apple或者Apple的子类型，编译器和运行时都可以
 * 编译器允许将Fruit放入这个数组，但运行时抛出异常
 */
public class CovariantArrays {
    public static void main(String[] args) {
        // 声明和赋值不相同
        Fruit[] fruit = new Apple[10];
        fruit[0] = new Apple();
        fruit[1] = new Jonathan();

        try {
            fruit[0] = new Fruit();
        } catch (Exception e) {
            System.out.println(e);
        }

        try {
            fruit[0] = new Orange();
        } catch (Exception e) {
            System.out.println(e);
        }

        // List<Fruit> fruitList = new ArrayList<Apple>();
        /**
         * 具有任何从Fruit继承的类型的列表
         * 唯一的限制是这个List持有Fruit或者Fruit的子类，但实际并不关心具体类型，
         * 所以如果不知道List中持有什么类型，便无法向其中添加对象
         */
        List<? extends Fruit> fruits = new ArrayList<Apple>();
//        fruits.add(new Apple());
//        fruits.add(new Fruit());
//        fruits.add(new Object());
        fruits.add(null);

        Fruit f = fruits.get(0);

    }

    /**
     * 参数apples是Apple的某种基类的List，向其中添加Apple和Apple的子类型是安全的。
     * Apple是下界，向其中添加Fruit是不安全的
     * @param apples
     */
    static void writeTo(List<? super Apple> apples) {
        apples.add(new Apple());
        apples.add(new Jonathan());
//        apples.add(new Fruit());
    }
}

/**
 * output:
 * java.lang.ArrayStoreException: Wildcard.Fruit
 * java.lang.ArrayStoreException: Wildcard.Orange
 */

class Fruit {}

class Apple extends Fruit {}

class Jonathan extends Apple {}

class Orange extends Fruit {}
