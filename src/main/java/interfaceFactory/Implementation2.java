package interfaceFactory;

/**
 * @author wangzhen
 * @creatTime 2021/10/4 3:40 下午
 * @description Service接口实现类
 */
public class Implementation2 implements Service{
    Implementation2(){}

    @Override
    public void method1() {
        System.out.println("Implementation2 method1");
    }

    @Override
    public void method2() {
        System.out.println("Implementation2 method2");
    }
}
