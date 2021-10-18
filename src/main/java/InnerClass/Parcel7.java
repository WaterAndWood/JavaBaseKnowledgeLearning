package InnerClass;

/**
 * @author wangzhen
 * @creatTime 2021/10/17 3:17 下午
 * @description 匿名内部类自动向上转型。等同于创建一个内部类。匿名内部类采用默认构造器
 */
public class Parcel7 {
    public Contents contents() {
        return new Contents() {
            private int i = 12;
            @Override
            public int value() {
                return i;
            }
        }; // 标记表达式结束
    }

    public static void main(String[] args) {
        Parcel7 p = new Parcel7();
        Contents c = p.contents();
        System.out.println(c.value());
    }
}
/**
 * output:
 * 12
 */
