package privateOverride;

public class PrivateOverride {
    private void f() {
        System.out.println("private f()");
    }

    public void g() {
        System.out.println("privateOverride g()");
    }

    public static void main(String[] args) {
        PrivateOverride po = new Derived();
        po.f();
        Derived de = new Derived();
        de.f();

        po.g();

        PrivateOverride privateOverride = new PrivateOverride();
        privateOverride.g();
    }

}

class Derived extends PrivateOverride {
    public void f() {
        System.out.println("public f()");
    }

    @Override
    public void g() {
        System.out.println("derived g()");
    }
}

/**
 * output:
 * --private方法自动被认为是final的，对导出类是屏蔽的。Derived类中f()方法是全新的方法，基类中f()方法在子类Derived中不可见，无法重写，也无法调用，
 * 所以调用的是基类的f()
 * private f()
 * public f()
 * derived g()
 * privateOverride g()
 *
 */
