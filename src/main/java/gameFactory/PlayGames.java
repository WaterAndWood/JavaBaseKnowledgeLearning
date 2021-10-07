package gameFactory;

/**
 * @author wangzhen
 * @creatTime 2021/10/5 10:26 上午
 * @description 工厂模式中消费者
 */
public class PlayGames {
    public static void playGames(GameFactory gameFactory) {
        Game game = gameFactory.getGame();
        while(game.move()) {

        };
    }

    public static void main(String[] args) {
        playGames(new CheckersFactory());
        // 与ChessFactory效果相同
        playGames(Chess::new);
    }
}

/**
 * output:
 * Checkers move 0
 * Checkers move 1
 * Checkers move 2
 * Chess move 0
 * Chess move 1
 * Chess move 2
 * Chess move 3
 */
