package GenericArray;

import java.lang.reflect.Array;

/**
 * @author wangzhen
 * @creatTime 2022/2/3 1:22 下午
 * @description 传递一个类型标记Class<T>到构造器，使得可以创建需要的实际类型的数组
 * 在Java源码中存在Object数组到参数化类型的转型
 */
public class GenericArrayWithTypeToken<T> {
    private T[] array;

    @SuppressWarnings("unchecked")
    public GenericArrayWithTypeToken(Class<T> type, int size) {
        // 转型还是有警告
        array = (T[])Array.newInstance(type, size);
    }

    public void put(int index, T item) {
        array[index] = item;
    }

    public T get(int index) {
        return array[index];
    }

    /**
     * 该数组的运行时类型是确切类型T[]
     */
    public T[] rep() {
        return array;
    }

    public static void main(String[] args) {
        GenericArrayWithTypeToken<Integer> genericArrayWithTypeToken = new GenericArrayWithTypeToken<Integer>(Integer.class, 5);
        for (int i = 0; i < 5; i++) {
            genericArrayWithTypeToken.put(i, i);
        }
        for (int i = 0; i < 5; i++) {
            System.out.println(genericArrayWithTypeToken.get(i) + " ");
        }
        Integer[] ia = genericArrayWithTypeToken.rep();
    }
}
