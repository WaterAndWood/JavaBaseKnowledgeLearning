package GenericArray;

/**
 * @author wangzhen
 * @creatTime 2022/2/3 12:30 下午
 * @description 泛型数组包装器
 */
public class GenericArray<T> {
    private T[] array;

    @SuppressWarnings("unchecked")
    public GenericArray(int size) {
        array = (T[])new Object[size];
        // new T[size]无法直接实例化，先创建对象数组再根据参数化转型
        //array = new T[size];
    }

    public void put(int index, T item) {
        array[index] = item;
    }

    public T get(int index) {
        return array[index];
    }

    public T[] rep() {
        return array;
    }

    public static void main(String[] args) {
        GenericArray<Integer> genericArray = new GenericArray<Integer>(5);
        /**
         * 运行时，出现ClassCastException错误，实际是Object[]而无法转型为T[]
         */
        // Integer[] integers = genericArray.rep();
        Object[] objects = genericArray.rep();

        for (int i = 0; i < 5; i++) {
            genericArray.put(i, i);
        }
        for (int i = 0; i < 5; i++) {
            System.out.print(genericArray.get(i) + " ");
        }
    }
}
