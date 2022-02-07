package InputOutputExample;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.StringReader;

/**
 * @author wangzhen
 * @creatTime 2022/2/5 4:46 下午
 * @description 从内存输入
 */
public class MemoryInput {
    public static void main(String[] args) throws IOException {
        StringReader in = new StringReader(BufferedInputFile.read("MemoryInput.java"));
        int c;
        while ((c = in.read()) != -1) {
            System.out.println(c);
        }
    }
}
