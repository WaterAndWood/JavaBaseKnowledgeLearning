package ClassTypeCapture;

public class Foo2<T> {
    private T x;

    /**
     * 传入一个工厂对象
     */
    public <F extends FactoryI<T>> Foo2(F factory) {
        x = factory.create();
    }
}

class Widget {
    public static class Factory implements FactoryI<Widget> {
        @Override
        public Widget create() {
            return new Widget();
        }
    }
}