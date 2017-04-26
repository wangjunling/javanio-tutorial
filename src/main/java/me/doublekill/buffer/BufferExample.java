package me.doublekill.buffer;

import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * Created by wangjunling on 2017/4/26.
 */
public class BufferExample
{
    public static void main(String[] args) throws Exception
    {

        RandomAccessFile accessFile = new RandomAccessFile(BufferExample.class.getResource("/data.txt")
                .getPath(), "rw");
        FileChannel inChannel = accessFile.getChannel();
        ByteBuffer byteBuffer = ByteBuffer.allocate(48);// 创建一个容量为48的buffer

        int read = inChannel.read(byteBuffer);
        while (read != -1)
        {
            System.out.println("Read " + read);
            byteBuffer.flip();// 将Buffer从写模式切换到读模式
                              // 将position设回0，并将limit设置成之前position的值。

            while (byteBuffer.hasRemaining())
            {
                System.out.println((char) byteBuffer.get());// 从buffer中读数据
            }
            byteBuffer.clear();
            read = inChannel.read(byteBuffer);
        }
        accessFile.close();
    }
}
