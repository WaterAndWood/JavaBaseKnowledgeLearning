package InnerClass;

/**
 * @author wangzhen
 * @creatTime 2021/10/17 2:33 下午
 * @description 方法作用域内创建一个完整类，称为局部内部类
 */
public class Parcel5 {
    /**
     * PDestination在destination内部，方法外无法访问
     * @param s
     * @return
     */
    public Destination destination(String s) {
        class PDestination implements Destination {
            private String label;
            private PDestination (String whereTo) {
                label = whereTo;
            }
            @Override
            public String readLabel() {
                return label;
            }
        }
        return new PDestination(s);
    }
    // 作用域之外不可用
    // PDestination pd = new PDestination("Beijing);
    private void tracking(boolean b) {
        if (b) {
            class TrackingShip {
                private String id;
                TrackingShip(String s) {
                    id = s;
                }
            }
            TrackingShip ts = new TrackingShip("x");
            System.out.println(ts.id);
        }
        // 不在if作用域内，所以不可用
        // TrackingShip ts = new TrackingShip("x");
    }

    public static void main(String[] args) {
        Parcel5 parcel5 = new Parcel5();
        Destination destination = parcel5.destination("Hangzhou");
        System.out.println(destination.readLabel());
    }
}
