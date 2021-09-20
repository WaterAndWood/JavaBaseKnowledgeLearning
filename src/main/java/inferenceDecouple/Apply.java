package inferenceDecouple;

/**
 * @author wangzhen
 * @creatTime 2021/9/20 2:56 下午
 * @description 与UserClassApply相同效果
 */
public class Apply {
    public static void process(ProcessorInterface p, Object s) {
        System.out.println("Using ProcessInterface " + p.name());
        System.out.println(p.process(s));
    }

    public static String s = "If she weighs the same as a duck";

    public static void main(String[] args) {
        process(new UpcaseInterface(), s);
        process(new SplitterInterface(), s);
    }
}

/**
 * output:
 * Using ProcessInterface UpcaseInterface
 * IF SHE WEIGHS THE SAME AS A DUCK
 * Using ProcessInterface SplitterInterface
 * [If, she, weighs, the, same, as, a, duck]
 *
 * 客户端程序员遵循接口写这个类，效果和process()传入对象一样，限制少且解耦
 */
