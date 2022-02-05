package Wildcard;

/**
 * @author wangzhen
 * @creatTime 2022/2/4 11:49 上午
 * @description 使用带有泛型类型参数的转型或者使用instanceof不会有任何效果。
 * 下面的容器在内部将各个值存储为Object，获取时在转型为T
 */
public class FixedSizeStack<T> {
    private int index = 0;
    private Object[] storage;
    public FixedSizeStack(int size) {
        storage = new Object[size];
    }

    public void push(T item) {
        storage[index++] = item;
    }

    /**
     * warning是因为无法知道转型是否安全，T被擦除到第一个边界，默认情况下是Object，pop()只是把
     * Object转型为Object，并未执行转型
     */
    @SuppressWarnings("unchecked")
    public T pop() {
        return (T)storage[--index];
    }

    public static void main(String[] args) {
        int size = 3;
        FixedSizeStack<String> stringFixedSizeStack = new FixedSizeStack<String>(size);
        for (String s : "A B C".split(" ")) {
            stringFixedSizeStack.push(s);
        }
        for (int i = 0; i < size; i++) {
            String s = stringFixedSizeStack.pop();
            System.out.println(s);
        }

    }
}
