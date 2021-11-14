package nestClass;
/**
 * @author wangzhen
 * @creatTime 2021/10/30 3:55 下午
 * @description 嵌套类做测试
 */
public class TestBed {
    public void f() {
        System.out.println("f()");
    }
    public static class Tester {
        public static void main(String[] args) {
            TestBed testBed = new TestBed();
            testBed.f();
        }
    }
}
