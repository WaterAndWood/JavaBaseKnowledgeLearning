package interfaceFactory;

/**
 * @author wangzhen
 * @creatTime 2021/10/4 3:59 下午
 * @description 生成Implementation1对象的工厂
 */
public class Implementation1Factory implements ServiceFactory {
    @Override
    public Service getService() {
        return new Implementation1();
    }
}
