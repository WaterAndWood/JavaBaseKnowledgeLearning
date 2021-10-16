package InnerClass;
/**
 * @author wangzhen
 * @creatTime 2021/10/16 10:24 上午
 * @description 内部类隐藏实现细节。所得到的只是指向基类或者接口的引用，甚至无法得到确切类型
 */
public class Parcel4 {
    /**
     * 只有Parcel4可访问PContents，外部不能访问PContents名字
     * 内部类实现了Contents接口，可以从外部通过外围类Parcel4按照Contents类型访问PContents
     */
    private class PContents implements Contents {
        private int i = 11;
        @Override
        public int value() {
            return i;
        }
    }

    /**
     * 包访问权限，同一包内PDestination名字可访问
     */
    protected class PDestination implements Destination {
        private String label;
        private PDestination(String whereTo) {
            label = whereTo;
        }
        protected PDestination(String whereTo, String date) {
            label = whereTo;
            System.out.println(date);
        }
        @Override
        public String readLabel() {
            return label;
        }
    }

    /**
     * 通过Parcel4类访问PDestination和PContents的方法
     */
    public Destination destination(String s) {
        return new PDestination(s);
    }

    public Contents contents() {
        return new PContents();
    }

}
