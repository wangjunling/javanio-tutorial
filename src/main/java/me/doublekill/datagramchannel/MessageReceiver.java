package me.doublekill.datagramchannel;

import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.DatagramChannel;

/**
 * Created by wangjunling on 2017/5/2.
 */
public class MessageReceiver
{
    public static void main(String[] args) throws Exception
    {
        DatagramChannel open = DatagramChannel.open();
        open.socket().bind(new InetSocketAddress(9999));
        ByteBuffer byteBuffer = ByteBuffer.allocate(48);

        open.receive(byteBuffer);
        byteBuffer.flip();
        while (byteBuffer.hasRemaining())
        {
            System.out.print((char) byteBuffer.get());
        }
        open.close();

    }
}
