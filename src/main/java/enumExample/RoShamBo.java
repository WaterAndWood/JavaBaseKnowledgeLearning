package enumExample;

import static enumExample.Outcome.*;

public class RoShamBo {
    public static void main(String[] args) {
        Rock r = new Rock();
        Scissors s = new Scissors();
        Paper p = new Paper();
        /**
         * 剪子和石头比，Lose
         */
        System.out.println(r.compete(s));

        /**
         * 布和石头比
         */
        System.out.println(r.compete(p));
    }
}

/**
 * @author wangzhen
 * @creatTime 2022/2/11 9:44 上午
 * @description this是第一个确定的参数类型。第二个参数类型确定的Item，通过compete调用eval实现
 */
class Paper implements Item {
    @Override
    public Outcome compete(Item it) {
        return it.eval(this);
    }
    @Override
    public Outcome eval(Paper p) {
        return DRAW;
    }
    @Override
    public Outcome eval(Scissors s) {
        return LOSE;
    }
    @Override
    public Outcome eval(Rock r) {
        return WIN;
    }
}

class Rock implements Item {
    @Override
    public Outcome compete(Item it) {
        return it.eval(this);
    }
    @Override
    public Outcome eval(Paper p) {
        return LOSE;
    }
    @Override
    public Outcome eval(Scissors s) {
        return WIN;
    }
    @Override
    public Outcome eval(Rock r) {
        return DRAW;
    }
}

class Scissors implements Item {
    @Override
    public Outcome compete(Item it) {
        return it.eval(this);
    }
    @Override
    public Outcome eval(Paper p) {
        return WIN;
    }
    @Override
    public Outcome eval(Scissors s) {
        return DRAW;
    }
    @Override
    public Outcome eval(Rock r) {
        return LOSE;
    }
}
