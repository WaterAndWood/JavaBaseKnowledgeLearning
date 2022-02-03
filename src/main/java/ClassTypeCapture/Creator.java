package ClassTypeCapture;

public class Creator extends GenericWithCreate<X> {
    /**
     * 产生不同的子类型对象
     */
    @Override
    X create() {
        return new X();
    }

    /**
     * 模板方法
     */
    void f() {
        System.out.println(element.getClass().getSimpleName());
    }

    public static void main(String[] args) {
        Creator creator = new Creator();
        creator.f();
    }
}
/**
 * output:
 * X
 */
