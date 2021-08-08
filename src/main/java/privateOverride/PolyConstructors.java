package privateOverride;

class Glyph {
    void draw() {
        System.out.println("Glyph.draw()");
    }
    Glyph() {
        System.out.println("Glyph() before draw()");
        draw();
        System.out.println("Glyph() after draw()");
    }
}

class RoundGlyph extends Glyph {
    private int radius = 1;
    RoundGlyph(int r) {
        System.out.println("RoundGlyph.RoundGlyph(), init radius = " + radius);
        radius = r;
        System.out.println("RoundGlyph.RoundGlyph(), radius = " + radius);
    }
    @Override
    void draw() {
        System.out.println("RoundGlyph.draw(), radius = " + radius);
    }
}
public class PolyConstructors {
    public static void main(String[] args) {
        new RoundGlyph(5);
    }
}

/**
 * output:
 * Glyph() before draw()
 * RoundGlyph.draw(), radius = 0
 * Glyph() after draw()
 * RoundGlyph.RoundGlyph(), init radius = 1
 * RoundGlyph.RoundGlyph(), radius = 5
 *
 * radius首先初始化为0
 * Glyph.draw()方法会被覆盖，调用RoundGlyph中的draw()方法时，radius = 0
 * 然后初始化成员变量，radius = 1
 * 最后执行RoundGlyph构造器使radius = 5
 */
