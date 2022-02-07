package InputOutputExample;

import java.io.*;

/**
 * @author wangzhen
 * @creatTime 2022/2/5 8:22 下午
 * @description
 */
public class BasicFileOutput {
    static String file = "BasicFileOutput.java";
    static String outFile = "BasicFileOutput.out";

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(
                new StringReader(
                        BufferedInputFile.read(file)));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(outFile)));
        int lineCount = 1;
        String s;
        while ((s = in.readLine()) != null) {
            out.println(lineCount++ + ": " + s);
        }
        out.close();

        /**
         * 标准输入中一次一行读取输入，System.in包装成BufferedReader，需要使用InputStreamReader转换
         * System.in通常进行缓冲
         */
        BufferedReader stdin = new BufferedReader(new InputStreamReader(System.in));
        String sin;
        while ((sin = stdin.readLine()) != null && sin.length()!= 0) {
            System.out.println(sin);
        }
    }
}
