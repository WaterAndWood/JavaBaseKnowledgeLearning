package InheritAndInit;

public class Beetle extends Insect{
    private int k = printInit("Beetle.k initialization");

    public Beetle() {
        System.out.println("k = " + k);
        System.out.println("j = " + j);
    }
    private static int x2 = printInit("static Beetle.x2 initialization");

    public static void main(String[] args) {
        System.out.println("Beetle constructor");
        Beetle beetle = new Beetle();
    }
    /** output:
     * --从Beetle main() 方法开始，执行类加载。首先加载基类，执行基类static初始化，再加载导出类，执行导出类static初始化
     * static Insect.x1 initialization
     * static Beetle.x2 initialization
     * --类加载结束，开始创建对象，执行new。导出类和基类对象中设置默认值，i= 0，j = 0, k = 0
     * Beetle constructor
     * --Beetle自动调用基类构造器，Insect没有它的基类构造器可调用，执行实例变量初始化 i = 9，j还是默认值，打印后j = 39
     * i = 9, j = 0
     * --返回Beetle构造器，初始化Beetle对象的实例变量k = 47并打印
     * Beetle.k initialization
     * --执行Beetle构造器的剩余部分打印
     * k = 47
     * j = 39
     */
}
