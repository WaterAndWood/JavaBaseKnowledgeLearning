package Generator;

/**
 * @author wangzhen
 * @creatTime 2022/1/26 8:53 下午
 * @description 泛型接口使用在生成器。生成器是专门负责生成对象的类。
 * 生成器是工厂模式的一种应用，不需要参数创建对象。一般只定义一个方法，用以生成对象
 */
public interface Generator<T> {
    /**
     * 参数化的Generator接口确保next()返回值时参数的类型
     */
    T next();
}
