package me.doublekill.datagramchannel;

import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.DatagramChannel;

/**
 * Created by wangjunling on 2017/5/2.
 */
public class MessageSender
{
    public static void main(String[] args) throws Exception
    {
        DatagramChannel channel = DatagramChannel.open();
        ByteBuffer byteBuffer = ByteBuffer.allocate(48);
        byteBuffer.put("abcdefg".getBytes());
        byteBuffer.flip();
        channel.send(byteBuffer, new InetSocketAddress("localhost",9999));
        channel.close();
    }
}
