package nestClass;
/**
 * @author wangzhen
 * @creatTime 2021/11/1 12:26 上午
 * @description
 */
public class Callee1 implements Incrementable {
    private int i = 0;
    @Override
    public void increment() {
        i++;
        System.out.println(i);
    }
}

