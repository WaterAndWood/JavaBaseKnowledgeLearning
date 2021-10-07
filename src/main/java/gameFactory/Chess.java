package gameFactory;

/**
 * @author wangzhen
 * @creatTime 2021/10/5 10:18 上午
 * @description 具体的Game对象
 */
public class Chess implements Game {
    private int moves = 0;
    private static final int MOVES = 4;

    @Override
    public boolean move() {
        System.out.println("Chess move " + moves);
        return ++moves != MOVES;
    }
}
