package Wildcard;

/**
 * @author wangzhen
 * @creatTime 2022/2/4 11:21 上午
 * @description 捕获转换，未指定的通配符类型被捕获，并被转换为确切类型
 * 一种需要使用<?>而不是原生类型的情况，向<?>中传递原生类型，编译器会推断出实际类型，方法会
 * 回转并调用另一个使用确切类型的方法
 */
public class CaptureConversion {
    /**
     * 类型是确切的，没有通配符或者边界
     * @param holder
     * @param <T>
     */
    static <T> void f1(Holder<T> holder) {
        T t = holder.get();
        System.out.println(t.getClass().getSimpleName());
    }

    /**
     * Holder是一个无界通配符，看起来未知。f2()中调用f1()，而f1()需要一个已知参数。
     * 参数类型在调用f2()的过程中被捕获，因此它可以在f1()的调用中使用。
     * 不能从f2()中返回T，T对f2()是未知的。
     * @param holder
     */
    static void f2(Holder<?> holder) {
        f1(holder);
    }

    @SuppressWarnings("unchecked")
    public static void main(String[] args) {
        Holder raw = new Holder<Integer>(1);
//        f1(raw); // 产生告警
        f2(raw);
        Holder rawBasic = new Holder();
        rawBasic.set(new Object());
        f2(rawBasic);
        Holder<?> wildHolder = new Holder<Double>(1.0);
        f2(wildHolder);
    }
}

/**
 * output:
 * Integer
 * Object
 * Double
 */
