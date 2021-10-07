package interfaceFactory;

/**
 * @author wangzhen
 * @creatTime 2021/10/4 4:06 下午
 * @description 产生Implementation2对象的接口
 */
public class Implementation2Factory implements ServiceFactory {
    @Override
    public Service getService() {
        return new Implementation2();
    }
}
