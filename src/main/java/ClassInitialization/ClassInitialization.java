package ClassInitialization;

import java.util.Random;

public class ClassInitialization {
    public static Random rand = new Random(47);

    public static void main(String[] args) throws Exception {
        /**
         * 使用.class获得对类的引用不会触发初始化，初始化尽可能惰性。
         * 没有触发Initable的static块
         */
        Class initable = Initable.class;
        System.out.println("After creating Initable ref");
        /**
         * staticFinal1是常数静态域，是final的，也不触发类初始化
         */
        System.out.println(Initable.staticFinal1);
        /**
         * staticFinal2引用触发Initable初始化
         */
        System.out.println(Initable.staticFinal2);
        /**
         * 对静态域的引用，触发类初始化
         */
        System.out.println(Initable2.staticNoFinal);
        /**
         * Class.forName触发类初始化
         */
        Class initable3 = Class.forName("ClassInitialization.Initable3");

        System.out.println("After creating Initable3 ref");

        System.out.println(Initable3.staticNoFinal);
    }
}

/**
 * output:
 * After creating Initable ref
 * 47
 * Intializing Initable
 * 258
 * Initializing Initable2
 * 147
 * Initializing Initable3
 * After creating Initable3 ref
 * 74
 */
