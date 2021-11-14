package InnerClass;

import interfaceFactory.Service;
import interfaceFactory.ServiceFactory;

/**
 * @author wangzhen
 * @creatTime 2021/10/30 11:03 上午
 * @description 匿名内部类实现工厂模式
 */
public class InnerImplementation2 implements Service {
    public InnerImplementation2() {}

    @Override
    public void method1() {
        System.out.println("InnerImplementation2 method1");
    }

    @Override
    public void method2() {
        System.out.println("InnerImplementation2 method2");
    }

    public static ServiceFactory factory = new ServiceFactory() {
        @Override
        public Service getService() {
            return new InnerImplementation2();
        }
    };
}
