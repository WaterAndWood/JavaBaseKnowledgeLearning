package ClassInitialization;

/**
 * @author wangzhen
 * @creatTime 2022/1/23 10:29 下午
 * @description 初始化类
 */
public class Initable {
    static final int staticFinal1 = 47;
    static final int staticFinal2 = ClassInitialization.rand.nextInt(1000);

    static {
        System.out.println("Intializing Initable");
    }

}
