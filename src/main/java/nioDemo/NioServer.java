package nioDemo;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Iterator;
import java.util.Set;

/**
 *
 * Nio Server demo
 *
 * @author Richa
 * @date 2022/9/18 17:47
 */
public class NioServer {
    public static void main(String[] args) throws IOException {
        // 创建serversocketchannel
        ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
        // 绑定端口
        serverSocketChannel.socket().bind(new InetSocketAddress(6666));
        // 设置非阻塞
        serverSocketChannel.configureBlocking(false);
        try (Selector selector = Selector.open()) {
            // 把ServerSocketChannel注册到selector，事件为OP_ACCEPT
            serverSocketChannel.register(selector, SelectionKey.OP_ACCEPT);
            // 如果返回>0，表示获取到关注的事件
            while (selector.select() > 0) {
                Set<SelectionKey> selectionKeySet = selector.selectedKeys();
                Iterator<SelectionKey> iterator = selectionKeySet.iterator();
                while (iterator.hasNext()) {
                    // 获得一个时间
                    SelectionKey next = iterator.next();
                    // OP_ACCEPT表示客户端连接
                    if (next.isAcceptable()) {
                        SocketChannel accept = serverSocketChannel.accept();
                        accept.configureBlocking(false);
                        // 当前socketchannel注册到selector，关注事件为读事件，关联一个buffer
                        accept.register(selector, SelectionKey.OP_READ, ByteBuffer.allocate(1024));
                        System.out.println("获得一个客户端连接");
                    } else if (next.isReadable()) {
                        // 通过key反向获取到channel
                        SocketChannel read = (SocketChannel) next.channel();
                        ByteBuffer buffer = (ByteBuffer)next.attachment();
                        while (read.read(buffer) != -1) {
                            buffer.flip();
                            System.out.println(new String(buffer.array(), 0, buffer.limit()));
                            buffer.clear();
                        }
                    }
                    iterator.remove();
                }
            }
        }
    }
}
