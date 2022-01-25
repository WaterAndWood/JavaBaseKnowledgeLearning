package ClassInitialization;

/**
 * @author wangzhen
 * @creatTime 2022/1/24 9:58 上午
 * @description 泛化Class引用
 */
public class GenericClassReferences {
    public static void main(String[] args) {
        /**
         * 平凡类，未使用泛型
         */
        Class intClass = int.class;
        /**
         * 使用泛型
         */
        Class<Integer> genericIntClass = int.class;

        genericIntClass = Integer.class;

        intClass = double.class;

        /**
         * 泛型限制了指向的类
         */
        // genericIntClass = double.class;

        Class<?> c = int.class;
        c = double.class;

        /**
         * 被限定为某种类型或者该类型的子类型，需要使用通配符和extends
         * 与Class<Number>不同
         */
        Class<? extends Number> bounded = int.class;
        bounded = double.class;
        bounded = Number.class;
    }

}
