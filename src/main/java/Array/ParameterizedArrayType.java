package Array;

import java.util.List;

/**
 * @author wangzhen
 * @creatTime 2022/2/5 10:49 上午
 * @description 参数化数组本身
 * 泛型在类或者方法的边界处有效，在类或者方法内部不适用。可以创建Object[]
 */
public class ParameterizedArrayType {
    public static void main(String[] args) {
        // 无法直接创建泛型数组
//        ClassParameter<String>[] s = new ClassParameter<String>[3];
        Integer[] ints = {1, 2, 3, 4, 5};
        Double[] doubles = {1.1, 2.2, 3.3, 4.4, 5.5};
        Integer[] ints1 = new ClassParameter<Integer>().f(ints);
        Double[] doubles1 = new ClassParameter<Double>().f(doubles);
        Integer[] ints2 = MethodParameter.f(ints);
        Double[] doubles2 = MethodParameter.f(doubles);

        List<String>[] ls;
        List[] la = new List[10];
        ls = (List<String>[]) la; // unchecked warning

    }
}

class ClassParameter<T> {
    public T[] f(T[] arg) {
        return arg;
    }
}

class MethodParameter {
    public static <T> T[] f(T[] arg) {
        return arg;
    }
}
