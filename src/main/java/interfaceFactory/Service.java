package interfaceFactory;

/**
 * @author wangzhen
 * @creatTime 2021/10/4 3:26 下午
 * @description 接口是实现多重继承的途径，生成某个接口对象的方式是工厂设计模式。工厂对象调用创建方法，生成某个接口的实现对象。
 * 该接口是期望生成对象的类定义
 */
public interface Service {
    void method1();
    void method2();
}
