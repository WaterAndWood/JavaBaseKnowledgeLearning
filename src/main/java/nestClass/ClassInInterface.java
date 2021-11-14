package nestClass;

/**
 * @author wangzhen
 * @creatTime 2021/10/30 3:38 下午
 * @description 接口中的内部类实现接口
 */
public interface ClassInInterface {
    void howdy();

    class Test implements ClassInInterface {
        @Override
        public void howdy() {
            System.out.println("HowDay");
        }

        public static void main(String[] args) {
            new Test().howdy();
        }
    }
}
