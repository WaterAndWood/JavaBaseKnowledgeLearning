package Generics;

/**
 * @author wangzhen
 * @creatTime 2022/2/1 11:18 下午
 * @description 因类型擦除，编译器无法将f()映射到HasF有f()这一事实
 */
public class Manipulator<T> {
    private T obj;
    public Manipulator(T t) {
        obj = t;
    }

    public void manipulate() {
        /**
         * obj上无法调用f()
         */
        //obj.f();
    }

    public static void main(String[] args) {
        HasF hf = new HasF();
        Manipulator<HasF> manipulator = new Manipulator<HasF>(hf);
        manipulator.manipulate();
    }
}
