package ClassTypeCapture;

/**
 * @author wangzhen
 * @creatTime 2022/2/2 9:29 下午
 * @description 传入显式工厂对象解决泛型类创建实例new T()
 */
public class FactoryConstraint {
    public static void main(String[] args) {
        new Foo2<Integer>(new IntegerFactory());
        new Foo2<Widget>(new Widget.Factory());
    }
}
