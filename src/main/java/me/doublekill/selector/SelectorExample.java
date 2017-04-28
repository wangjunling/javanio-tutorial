package me.doublekill.selector;

import java.net.InetSocketAddress;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.SocketChannel;
import java.util.Iterator;
import java.util.Set;

/**
 * Created by wangjunling on 2017/4/28.
 */
public class SelectorExample
{
    public static void main(String[] args) throws Exception
    {
        Selector selector = Selector.open();
        SocketChannel socketChannel = SocketChannel.open(new InetSocketAddress("localhost", 65535));
        socketChannel.configureBlocking(false);
        SelectionKey key = socketChannel.register(selector, SelectionKey.OP_READ);
        while (true)
        {
            int readyChannel = selector.select();
            if (readyChannel == 0)
            {
                continue;
            }
            Set<SelectionKey> selectionKeys = selector.selectedKeys();
            Iterator<SelectionKey> iterator = selectionKeys.iterator();
            while (iterator.hasNext())
            {
                SelectionKey next = iterator.next();
                // Selector的四种事件（接受，连接，读，写）是否就绪。
                if (next.isAcceptable())
                {
                    System.out.println("acceptable");
                }
                else
                    if (next.isConnectable())
                    {
                        System.out.println("connectable");
                    }
                    else
                        if (next.isReadable())
                        {
                            System.out.println("readable");
                        }
                        else
                            if (next.isWritable())
                            {
                                System.out.println("writable");
                            }
                            iterator.remove();
            }

        }
    }
}
