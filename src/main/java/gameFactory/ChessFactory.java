package gameFactory;

/**
 * @author wangzhen
 * @creatTime 2021/10/5 10:24 上午
 * @description 生产Chess对象
 */
public class ChessFactory implements GameFactory {

    @Override
    public Game getGame() {
        return new Chess();
    }
}
