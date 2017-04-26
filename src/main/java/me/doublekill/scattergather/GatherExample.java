package me.doublekill.scattergather;

import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * Created by wangjunling on 2017/4/26.
 */
public class GatherExample
{
    public static void main(String[] args) throws Exception
    {
        ByteBuffer header = ByteBuffer.allocate(128);
        ByteBuffer body = ByteBuffer.allocate(1024);
        header.put("header".getBytes());
        body.put("body".getBytes());
        ByteBuffer[] buffers = {header, body};
        RandomAccessFile accessFile = new RandomAccessFile("data1.txt", "rw");
        FileChannel channel = accessFile.getChannel();
        channel.write(buffers);// 写到channel中
        accessFile.close();
    }
}
