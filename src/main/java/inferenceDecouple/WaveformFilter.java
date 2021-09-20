package inferenceDecouple;

/**
 * @author wangzhen
 * @creatTime 2021/9/20 9:30 上午
 * @description 假定WaveformFilter来自第三方。虽然WaveformFilter和Processor有相同的接口元素，但它不是继承自Processor，因此不能将
 * WaveformFilter用于UseClassApply.process()。这主要是useClassApply.process()和UProcessor之间耦合过紧
 */
public class WaveformFilter {
    public String name() {
        return getClass().getSimpleName();
    }

    public Waveform process(Waveform input) {
        return input;
    }
}

class Waveform {
    private static long counter;

    private final long id = counter++;

    @Override
    public String toString() {
        return "Waveform " + id;
    }
}

class LowPass extends WaveformFilter {
    double cutoff;
    public LowPass(double cutoff) {
        this.cutoff = cutoff;
    }
    @Override
    public Waveform process(Waveform input) {
        System.out.println("LowPass");
        return input;
    }
}

class HighPass extends WaveformFilter {
    double cutoff;
    public HighPass(double cutoff) {
        this.cutoff = cutoff;
    }
    @Override
    public Waveform process(Waveform input) {
        System.out.println("HighPass");
        return input;
    }
}
