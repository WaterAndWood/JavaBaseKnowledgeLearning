package gameFactory;

/**
 * @author wangzhen
 * @creatTime 2021/10/4 5:07 下午
 * @description 具体Game对象
 */
public class Checkers implements Game {
    private int moves = 0;
    private static final int MOVES = 3;

    @Override
    public boolean move() {
        System.out.println("Checkers move " + moves);
        return ++moves != MOVES;
    }
}
