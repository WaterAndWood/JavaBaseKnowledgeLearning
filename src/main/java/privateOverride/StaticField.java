package privateOverride;

public class StaticField {
    public int field = 0;
    public int getField() {
        return field;
    }

    public static void main(String[] args) {
        // upcast
        StaticField sup = new SubStaticField();
        System.out.println("sup.field = " + sup.field + ", sup.getField() = " + sup.getField());
        SubStaticField sub = new SubStaticField();
        System.out.println("sub.field = " + sub.field + ", sub.getField() = " + sub.getField()
        + ", sub.getSuperField() = " + sub.getSuperField());
    }

}

class SubStaticField extends StaticField {
    public int field = 1;
    @Override
    public int getField() {
        return field;
    }

    public int getSuperField() {
        return super.field;
    }
}

/**
 * output:
 * --Sub对象转型为Super引用时，任何域的访问操作由编译器解析，不是多态的。Super.field和Sub.field分配了不同的存储空间。Sub实际上包含了两个称为filed
 * 的域，它自己的和它从Super处得到。在引用Sub中的field时为自己的默认域，并非Sup的field域。为了得到Super。field，显式指明super.field
 * sup.field = 0, sup.getField() = 1
 * sub.field = 1, sub.getField() = 1, sub.getSuperField() = 0
 */
