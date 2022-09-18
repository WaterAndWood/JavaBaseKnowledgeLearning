package nioDemo;

import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 *
 * Bio demo server
 *
 * @author Richa
 * @date 2022/9/18 16:16
 */
public class BioServer {
    public static void main(String[] args) throws IOException  {
        ExecutorService executorService = Executors.newCachedThreadPool();
        // 创建ServerSocket
        ServerSocket serverSocket = new ServerSocket(6666);
        for(;;) {
            System.out.println("等待连接中");
            Socket socket = serverSocket.accept();
            System.out.println("连接到一个客户端");
            executorService.execute(() -> handler(socket));
        }
    }

    // handler方法处理客户端连接
    public static void handler(Socket socket) {
        byte[] bytes = new byte[1024];
        System.out.println("当前线程信息: " + Thread.currentThread().getName());
        try {
            InputStream inputStream = socket.getInputStream();
            while(inputStream.read(bytes) != -1) {
                System.out.println(Thread.currentThread().getName()+ " : 发送信息为 :"+ new String(bytes, 0, bytes.length));
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            System.out.println("关闭连接");
            try {
                socket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
