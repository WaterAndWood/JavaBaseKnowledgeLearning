package inferenceDecouple;

import java.util.Arrays;

/**
 * @author wangzhen
 * @creatTime 2021/9/19 8:00 下午
 * @description 方法操作的是类而非接口。
 */
public class UseClassApply {
    public static void process(Processor p, Object obj) {
        System.out.println("Using Processor " + p.name());
        System.out.println(p.process(obj));
    }

    public static String s = "Disagreement with beliefs is by definition incorrect";
    public static void main(String[] args) {
        process(new Upcase(), s);
        process(new Splitter(), s);
        // 如果WaveformFilter继承Processor，可以应用于UseClassApply.process()
//        Waveform waveform = new Waveform();
//        process(new WaveformFilter(), waveform);
    }
}

/**
 * 策略的基类，继承它的是具体的策略
 */
class Processor {
    public String name() {
        return getClass().getSimpleName();
    }
    Object process(Object input) {
        return input;
    }
}

class Upcase extends Processor {
    @Override
    String process(Object input) {
        return ((String)input).toUpperCase();
    }
}

class Splitter extends Processor {
    @Override
    String process(Object input) {
        return Arrays.toString(((String) input).split(" "));
    }
}

/**
 * output:
 * Using Processor Upcase
 * DISAGREEMENT WITH BELIEFS IS BY DEFINITION INCORRECT
 * Using Processor Splitter
 * [Disagreement, with, beliefs, is, by, definition, incorrect]
 *
 * UseClassApply.process()可以接受任意类型的processor，并应用到Object。创建一个根据所传递的参数对象的不同而具有的不同的行为的方法，
 * 被称为策略模式。这类方法所包含的要执行的算法中固定不变的部分如打印Processor的name，而策略包含变化的部分如Processor导出类中的方法实现。
 * 在这里，策略是传递进去的对象Processor，然后不同的策略应用到obj上
 */
