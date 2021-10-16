package InnerClass;

/**
 * @author wangzhen
 * @creatTime 2021/10/15 7:50 上午
 * @description Selector迭代器接口
 */
public interface Selector {
    // 检查序列是否到末尾
    boolean end();

    // 访问当前对象
    Object current();

    // 移动到序列中下一个对象
    void next();
}
