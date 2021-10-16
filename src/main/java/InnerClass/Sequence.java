package InnerClass;
/**
 * @author wangzhen
 * @creatTime 2021/10/15 8:37 上午
 * @description 迭代器模式，内部类SequenceSelector提供Selector功能，迭代Sequence的private序列
 */
public class Sequence {
    private Object[] items;
    // 外围类指示位置
    private int next = 0;
    public Sequence(int size) {
        items = new Object[size];
    }

    public void add(Object x) {
        if (next < items.length) {
            items[next++] = x;
        }
    }

    // 内部类作为迭代器和Sequence连接，可以使用迭代器访问Sequence
    private class SequenceSelector implements Selector {
        // 内部类指示位置
        private int i = 0;
        @Override
        public boolean end() {
            return i == items.length;
        }

        @Override
        public Object current() {
            return items[i];
        }

        @Override
        public void next() {
            if (i < items.length) {
                i++;
            }
        }
    }

    public Selector selector() {
        return new SequenceSelector();
    }

    public static void main(String[] args) {
        Sequence sequence = new Sequence(10);
        for (int i = 0; i < 10; i++) {
            sequence.add(Integer.toString(i));
        }

        Selector selector = sequence.selector();
        while(!selector.end()) {
            System.out.print(selector.current() + " ");
            selector.next();
        }
    }
}

/**
 * Output:
 * 0 1 2 3 4 5 6 7 8 9
 *
 */
