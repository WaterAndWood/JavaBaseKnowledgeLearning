package dynamicProxy;

import java.lang.reflect.Proxy;

/**
 * @author wangzhen
 * @creatTime 2022/1/24 10:55 下午
 * @description 通过调用静态方法Proxy.newProxyInstance()可以创建动态代理，这个方法需要一个类加载器（通常
 * 可以从被加载的对象中获取其类加载器），代理实现的接口列表（不是类或者抽象类），以及InvocationHandler接口的实现。
 * 动态代理可以将所有调用重定向到调用处理器，所以会向调用处理器传入一个实际对象的引用。
 * 可以通过方法签名（方法名、参数）来过滤某些方法的调用
 */
public class SimpleDynamicProxy {
    public static void consumer(Interface iface) {
        iface.doSomething();
        iface.somethingElse("bonobo");
    }

    public static void main(String[] args) {
        RealObject real = new RealObject();
        consumer(real);

        /**
         * 动态代理调用实现Interface的RealObject
         */
        Interface proxy = (Interface) Proxy.newProxyInstance(
                Interface.class.getClassLoader(),
                new Class[]{Interface.class},
                new DynamicProxyHandler(real)
        );
        consumer(proxy);
    }
}

/**
 * output:
 * doSomething
 * somethingElse bonobo
 * **** proxy: class com.sun.proxy.$Proxy0, method: public abstract void dynamicProxy.Interface.doSomething(), args: null
 * doSomething
 * **** proxy: class com.sun.proxy.$Proxy0, method: public abstract void dynamicProxy.Interface.somethingElse(java.lang.String), args: [Ljava.lang.Object;@12a3a380
 *  bonobo
 * somethingElse bonobo
 */
