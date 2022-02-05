package Wildcard;

/**
 * @author wangzhen
 * @creatTime 2022/2/4 4:57 下午
 * @description 在使用自限定类型时，在导出类中只有一个方法，并且这个方法接受导出类型而不是基类型为参数
 * 如果不使用自限定，将重载参数类型；如果使用自限定，只能获得某个方法的一个版本，它接受确切的参数类型
 */
public class SelfBoundingAndCovariantArguments {
    void testA(Setter s1, Setter s2, SelfBoundSetter sbs) {
        s1.set(s2);
//        s1.set(sbs);
    }
}
