package InnerClass;

import interfaceFactory.Service;
import interfaceFactory.ServiceFactory;

/**
 * @author wangzhen
 * @creatTime 2021/10/30 1:43 下午
 * @description 工厂类客户端
 */
public class Factories {
    public static void ServiceConsumer(ServiceFactory factory) {
        Service service = factory.getService();
        service.method1();
        service.method2();
    }

    public static void main(String[] args) {
        ServiceConsumer(InnerImplementation1.factory);
        ServiceConsumer(InnerImplementation2::new);
    }
}
/**
 * output:
 * InnerImplementation1 method1
 * InnerImplementation1 method2
 * InnerImplementation2 method1
 * InnerImplementation2 method2
 */
