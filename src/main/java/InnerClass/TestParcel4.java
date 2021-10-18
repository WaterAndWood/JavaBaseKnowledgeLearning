package InnerClass;

public class TestParcel4 {
    public static void main(String[] args) {
        Parcel4 parcel4 = new Parcel4();
        // 真实类型是Parcel4.PContents，不可见，无法访问名字。
        // 无法从Contents向下转型到Parcel4.PContents
        Contents contents = parcel4.contents();
        System.out.println(contents.value());
        Destination destination = parcel4.destination("Hangzhou");
        System.out.println(destination.readLabel());
        // PDestination名字可以访问，但构造方法是private，无法调用
        // Parcel4.PDestination pDestination = parcel4.new PDestination("Beijing");
        // PDestination的可以访问的构造方法，Parcel4.PDestination名字可以直接访问
        Parcel4.PDestination pDestination = parcel4.new PDestination("Harbin", "10月1日");
        System.out.println(pDestination.readLabel());
        // 无法访问private PContents
        // Parcel4.PContents pc = parcel4.new PContents();
    }
}
/**
 * output:
 * 11
 * Hangzhou
 * 10月1日
 * Harbin
 */
