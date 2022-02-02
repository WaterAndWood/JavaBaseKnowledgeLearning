package ClassTypeCapture;

/**
 * @author wangzhen
 * @creatTime 2022/2/2 8:47 下午
 * @description 类型标签使用newInstance()来创建新的对象（相当于工厂），解决泛型中new T()问题
 */
public class ClassAsFactory<T> {
    T x;
    public ClassAsFactory(Class<T> kind) {
        try {
            /**
             * 工厂方法
             */
            x = kind.newInstance();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}

class Employee {}
