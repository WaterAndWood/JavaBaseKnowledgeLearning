package nestClass;
/**
 * @author wangzhen
 * @creatTime 2021/11/1 12:22 上午
 * @description Callee2继承了MyIncrement，无法为了Incrementable覆盖increment()方法，使用内部类实现Incrementable
 */
public class Callee2 extends MyIncrement{
    private int i = 0;
    @Override
    public void increment() {
        super.increment();
        i++;
        System.out.println(i);
    }

    /**
     * Closure实现了Incrementable，以提供返回Callee2的钩子hook，而且是安全的钩子，获得Incrementable引用，
     * 只能调用increment()
     */
    private class Closure implements Incrementable {
        @Override
        public void increment() {
            Callee2.this.increment();
        }
    }
    Incrementable getCallbackReference() {
        return new Closure();
    }
}

/**
 * Caller构造器需要Incrementable的引用做参数（虽然可以捕获回调引用），Caller对象使用此引用回调Callee类
 */
class Caller {
    private Incrementable callbackReference;

    Caller(Incrementable cbh) {
        callbackReference = cbh;
    }
    void go() {
        callbackReference.increment();
    }
}
