package privateOverride;

class Grain {
    @Override
    public String toString() {
        return "Grain";
    }
}

class Wheat extends Grain {
    @Override
    public String toString() {
        return "wheat";
    }
}

class Mill {
    Grain process() {
        return new Grain();
    }
}

/**
 * 子类中覆盖父类的方法，可以改变父类方法的返回类型，返回父类返回类型的导出类型
 */
class WheatMill extends Mill {
    @Override
    Wheat process() {
        return new Wheat();
    }
}

public class CovariantReturn {
    public static void main(String[] args) {
        Mill m = new Mill();
        Grain g = m.process();
        // 调用g的toString方法
        System.out.println(g);
        m = new WheatMill();
        // 返回父类的返回类型的导出类型
        g = m.process();
        System.out.println(g);
    }
}

/**
 * output：
 * Grain
 * wheat
 */
