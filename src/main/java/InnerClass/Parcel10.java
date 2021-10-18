package InnerClass;

/**
 * @author wangzhen
 * @creatTime 2021/10/17 6:16 下午
 * @description 
 */
public class Parcel10 {
    public Destination destination(final String dest, float price) {
        return new Destination() {
            private int cost;
            // 实例初始化操作
            {
                cost = Math.round(price);
                if (cost > 100) {
                    System.out.println("over budget!");
                }
            }
            private String label = dest;

            @Override
            public String readLabel() {
                return label;
            }
        };
    }

    public static void main(String[] args) {
        Parcel10 parcel10 = new Parcel10();
        Destination destination = parcel10.destination("Hangzhou", 108.8f);
        System.out.println(destination.readLabel());
    }
}
/**
 * output:
 * over budget!
 * Hangzhou
 * 对于匿名内部类而言，实例初始化的效果就是构造器。你不能重载实例初始化方法，只能实例初始化
 */
