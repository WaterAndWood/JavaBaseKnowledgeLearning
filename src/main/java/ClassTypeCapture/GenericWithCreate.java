package ClassTypeCapture;

/**
 * @author wangzhen
 * @creatTime 2022/2/2 9:45 下午
 * @description 模板方法创建泛型实例
 */
abstract public class GenericWithCreate<T> {
    final T element;
    GenericWithCreate() {
        element = create();
    }

    /**
     * 在子类中定义的用来产生子类类型的对象
     */
    abstract T create();
}

class X {}