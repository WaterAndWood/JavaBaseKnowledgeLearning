package ClassTypeCapture;

/**
 * @author wangzhen
 * @creatTime 2022/2/2 5:06 下午
 * @description 类型擦除的补偿，传入Class对象
 */
public class ClassTypeCapture<T> {
    Class<T> kind;
    public ClassTypeCapture(Class<T> kind) {
        this.kind = kind;
    }

    public boolean f(Object arg) {
        return kind.isInstance(arg);
    }

    public static void main(String[] args) {
        ClassTypeCapture<Building> typeBuilding = new ClassTypeCapture<Building>(Building.class);
        System.out.println(typeBuilding.f(new Building()));
        System.out.println(typeBuilding.f(new House()));

        ClassTypeCapture<House> typeHouse = new ClassTypeCapture<House>(House.class);
        System.out.println(typeHouse.f(new Building()));
        System.out.println(typeHouse.f(new House()));
    }
}
/**
 * output:
 * true
 * true
 * false
 * true
 */
