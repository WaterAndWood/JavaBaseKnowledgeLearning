package InnerClass;
/**
 * @author wangzhen
 * @creatTime 2021/10/17 5:33 下午
 * @description 匿名类中定义字段初始化，使用其外部定义的对象，编译器要求参数引用是final
 */
public class Parcel9 {
    public Destination destination(final String dest) {
        return new Destination() {
            private String label = dest;
            @Override
            public String readLabel() {
                return label;
            }
        };
    }

    public static void main(String[] args) {
        Parcel9 parcel9 = new Parcel9();
        Destination destination = parcel9.destination("Hangzhou");
        System.out.println(destination.readLabel());
    }
}
