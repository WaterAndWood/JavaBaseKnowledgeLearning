package Wildcard;

/**
 * @author wangzhen
 * @creatTime 2022/2/4 4:53 下午
 * @description 自限定类型
 */
public interface SelfBoundSetter<T extends SelfBoundSetter<T>> {
    void set(T arg);
}
