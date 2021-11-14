package InnerClass;

import interfaceFactory.Service;
import interfaceFactory.ServiceFactory;

/**
 * @author wangzhen
 * @creatTime 2021/10/30 10:38 上午
 * @description 匿名内部类实现工厂模式。不需要创建工厂的具名类。通常只需要的单一的工厂对象，被创建为Service实现中的一个static域
 */
public class InnerImplementation1 implements Service {
    private InnerImplementation1() {}
    @Override
    public void method1() {
        System.out.println("InnerImplementation1 method1");
    }

    @Override
    public void method2() {
        System.out.println("InnerImplementation1 method2");
    }

    public static ServiceFactory factory = new ServiceFactory() {
        @Override
        public Service getService() {
            return new InnerImplementation1();
        }
    };
}
