package nestClass;

public class Callbacks {
    public static void main(String[] args) {
        Callee1 callee1 = new Callee1();
        Callee2 callee2 = new Callee2();
        /**
         * callee2实现了MyIncrement，所以可以传入f(),f()修改了callee2。对于Callbacks类，返回MyIncrement
         */
        MyIncrement.f(callee2);
        Caller caller1 = new Caller(callee1);
        // 内部类作为钩子提供调用
        Caller caller2 = new Caller(callee2.getCallbackReference());
        caller1.go();
        caller1.go();
        caller2.go();
        caller2.go();
    }
}
/**
 * output:
 * //MyIncrement.f(callee2);
 * Other operation
 * 1
 * //caller1.go();
 * //caller1.go();
 * 1
 * 2
 * //caller2.go();
 * //caller2.go();
 * Other operation
 * 2
 * Other operation
 * 3
 */
