package InputOutputExample;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 * @author wangzhen
 * @creatTime 2022/2/5 4:26 下午
 * @description 缓冲输入文件。打开文件用于字符输入，为提高速度对文件缓冲，传入BufferedReader构造器，提供readLine()
 */
public class BufferedInputFile {
    public static String read(String fileName) throws IOException {
        BufferedReader in = new BufferedReader(new FileReader(fileName));
        String s;
        StringBuilder sb = new StringBuilder();
        while ((s = in.readLine()) != null) {
            sb.append(s + "\n");
        }
        in.close();
        return sb.toString();
    }

    public static void main(String[] args) throws IOException {
        System.out.print(read("BufferedInputFile.java"));
    }
}
