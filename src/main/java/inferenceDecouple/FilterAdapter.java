package inferenceDecouple;

/**
 * @author wangzhen
 * @creatTime 2021/9/20 2:03 下午
 * @description WaveformFilter可以使用适配器模式进行对接，适配器将接受你拥有的接口，并产生你所需要的接口
 */
public class FilterAdapter implements ProcessorInterface {
    WaveformFilter waveformFilter;
    public FilterAdapter(WaveformFilter waveformFilter) {
        this.waveformFilter = waveformFilter;
    }

    @Override
    public String name() {
        return waveformFilter.name();
    }

    /**
     * 实现接口时协变返回，Waveform是Object子类
     * @param input
     * @return Waveform
     */
    @Override
    public Waveform process(Object input) {
        return waveformFilter.process((Waveform) input);
    }

    public static void main(String[] args) {
        Waveform waveform = new Waveform();
        Apply.process(new FilterAdapter(new LowPass(1.0)), waveform);
        Apply.process(new FilterAdapter(new HighPass(2.0)), waveform);
    }
}

/**
 * output:
 * Using ProcessInterface LowPass
 * LowPass
 * Waveform 0
 * Using ProcessInterface HighPass
 * HighPass
 * Waveform 0
 *
 * 适配器方式FilterAdapter的构造器接受了接口WaveformFilter，然后生成所需要的ProcessorInterface接口对象，在适配器中使用了代理。
 * 适配器FilterAdapter作为中间类，实现了ProcessInterface，使得Apply.process()接收了FilterAdapter作为参数。
 *
 * FilterAdapter中代理了WaveformFilter，FilterAdapter中的process()使用了WaveformFilter中的方法process()，相当于Apply.process()方法
 * 接受了WaveformFilter中的策略，并且对Waveform进行了处理。实现了WaveformFilter不继承ProcessorInterface的情况下，Apply使用了WaveformFilter的代码。
 * 与UserClassApply.process()中传Processor类相比，可以复用WaveformFilter代码。
 */
