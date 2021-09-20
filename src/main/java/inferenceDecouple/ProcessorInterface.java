package inferenceDecouple;

/**
 * @author wangzhen
 * @creatTime 2021/9/20 9:57 上午
 * @description Processor改为接口形式，会解耦，可以复用UserClassApply.process()
 * Processor和ProcessorInterface有相同的接口
 */
public interface ProcessorInterface {
    String name();
    Object process(Object input);
}
