package interfaceFactory;

/**
 * @author wangzhen
 * @creatTime 2021/10/4 4:16 下午
 * @description 工厂模式的客户端
 */
public class Factories {
    public static void serviceConsumer(ServiceFactory factory) {
        Service service = factory.getService();
        service.method1();
        service.method2();
    }

    public static void main(String[] args) {
        serviceConsumer(new Implementation1Factory());
        serviceConsumer(Implementation2::new);
    }
}

/**
 * output:
 * Implementation1 method1
 * Implementation1 method2
 * Implementation2 method1
 * Implementation2 method2
 *
 */
