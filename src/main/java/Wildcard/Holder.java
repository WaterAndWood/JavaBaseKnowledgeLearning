package Wildcard;

/**
 * @author wangzhen
 * @creatTime 2022/2/3 8:09 下午
 * @description Holder<Apple>，不能向上转型为Holder<Fruit>，但能向上转型为Holder<? extends Fruit>
 */
public class Holder<T> {
    private T value;
    public Holder() {}
    public Holder(T val) {
        value = val;
    }

    public void set(T val) {
        value = val;
    }

    public T get() {
        return value;
    }

    @Override
    public boolean equals(Object obj) {
        return value.equals(obj);
    }

    public static void main(String[] args) {
        Holder<Apple> appleHolder = new Holder<Apple>(new Apple());
        Apple a = appleHolder.get();
        appleHolder.set(a);

        // 无法转型
        // Holder<Fruit> fruitHolder = appleHolder;

        Holder<? extends Fruit> fHolder = appleHolder;
        Fruit fruit = fHolder.get();
        a = (Apple)fHolder.get();

        try {
            Orange orange = (Orange)fHolder.get();
        } catch (Exception e) {
            System.out.println(e);
        }
        /**
         * set()参数是"？extends Fruit"意味着是任何类型，编译器无法验证安全性
         */
//        fHolder.set(new Apple());
//        fHolder.set(new Fruit());
//        fHolder.set(new Object());

        /**
         * equals方法参数是Object，所以可以工作
         */
        System.out.println(fruit.equals(a));

    }
}
/**
 * output:
 * java.lang.ClassCastException: Wildcard.Apple cannot be cast to Wildcard.Orange
 * true
 */
