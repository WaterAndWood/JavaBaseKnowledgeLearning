package dynamicProxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * @author wangzhen
 * @creatTime 2022/1/24 10:27 下午
 * @description Java动态代理，动态创建代理并动态处理所代理的方法的调用，实现InvocationHandler
 */
public class DynamicProxyHandler implements InvocationHandler {
    private Object proxied;

    public DynamicProxyHandler(Object proxied) {
        this.proxied = proxied;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Exception{
        System.out.println("**** proxy: " + proxy.getClass() + ", method: " + method
        + ", args: "+ args);
        if (args != null) {
            for(Object arg : args) {
                System.out.println(" " + arg);
            }
        }
        return method.invoke(proxied, args);
    }

}
