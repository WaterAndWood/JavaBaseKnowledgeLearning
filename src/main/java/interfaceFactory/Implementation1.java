package interfaceFactory;

/**
 * @author wangzhen
 * @creatTime 2021/10/4 3:35 下午
 * @description Service接口的实现类
 */
public class Implementation1 implements Service {
    Implementation1(){}

    @Override
    public void method1() {
        System.out.println("Implementation1 method1");
    }

    @Override
    public void method2() {
        System.out.println("Implementation1 method2");
    }
}
