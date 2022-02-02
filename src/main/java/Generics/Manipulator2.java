package Generics;

/**
 * @author wangzhen
 * @creatTime 2022/2/1 11:31 下午
 * @description 边界<T extends HasF>声明T必须具有类型HasF类型或者从
 * HasF导出类型，因此obj可以调用f()
 */
public class Manipulator2<T extends HasF> {
    private T obj;

    public Manipulator2(T t) {
        obj = t;
    }

    public void manipulate() {
        obj.f();
    }

    /**
     * 返回确切类型
     */
    public T get() {
        return obj;
    }

    public static void main(String[] args) {
        HasF hf = new HasF();
        Manipulator2<HasF> manipulator2 = new Manipulator2<HasF>(hf);
        manipulator2.manipulate();
        /**
         * 返回确切类型
         */
        HasF hasF = manipulator2.get();
        hasF.f();
    }
}
/**
 * output:
 * HasF.f()
 * HasF.f()
 */