package InnerClass;

/**
 * @author wangzhen
 * @creatTime 2021/10/17 3:36 下午
 * @description 带参数的构造器，使用基类
 */
public class Parcel8 {
    public Wrapping wrapping(int x) {
        return new Wrapping(x) {
            @Override
            public int value() {
                return super.value() * 47;
            }
        };
    }

    public static void main(String[] args) {
        Parcel8 parcel8 = new Parcel8();
        Wrapping w = parcel8.wrapping(8);
        System.out.println(w.value());
    }
}

/**
 * output:
 * 376
 */

// 基类
class Wrapping {
    private int i;
    public Wrapping(int x) {
        i = x;
    }
    public int value() {
        return i;
    }
}
