package inferenceDecouple;

import java.util.Arrays;

/**
 * @author wangzhen
 * @creatTime 2021/9/20 2:34 下午
 * @description 接口实现策略
 */
public abstract class StringProcessor implements ProcessorInterface{
    @Override
    public String name() {
        return getClass().getSimpleName();
    }

    @Override
    public abstract String process(Object input);
}

class UpcaseInterface extends StringProcessor {
    @Override
    public String process(Object input) {
        return ((String)input).toUpperCase();
    }
}


class SplitterInterface extends StringProcessor {
    @Override
    public String process(Object input) {
        return Arrays.toString(((String)input).split(" "));
    }
}