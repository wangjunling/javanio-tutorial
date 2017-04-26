package me.doublekill.scattergather;

import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * Created by wangjunling on 2017/4/26.
 */
public class ScatterExample
{
    public static void main(String[] args) throws Exception
    {
        ByteBuffer header = ByteBuffer.allocate(128);
        ByteBuffer body = ByteBuffer.allocate(1024);
        ByteBuffer[] buffers = {header, body};
        String path = ScatterExample.class.getResource("/data.txt").getPath();
        RandomAccessFile accessFile = new RandomAccessFile(path, "rw");
        FileChannel channel = accessFile.getChannel();
        long read = channel.read(buffers);
        System.out.println("Read " + read);
        accessFile.close();
    }
}
