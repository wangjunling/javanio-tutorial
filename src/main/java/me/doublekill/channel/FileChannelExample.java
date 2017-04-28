package me.doublekill.channel;

import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * Created by wangjunling on 2017/4/28.
 */
public class FileChannelExample
{

    public static void main(String[] args) throws Exception
    {
        RandomAccessFile accessFile = new RandomAccessFile("e:/data.txt", "rw");
        FileChannel channel = accessFile.getChannel();
        writeFileChannel(channel);
        readFileChannel(channel);

        changePosition(channel,100);
        writeFileChannel(channel);
        accessFile.close();
    }

    private static void readFileChannel(FileChannel channel) throws Exception
    {

        ByteBuffer byteBuffer = ByteBuffer.allocate(48);
        int read = channel.read(byteBuffer);
        while (read != -1)
        {
            System.out.println(read);
            byteBuffer.flip();
            while (byteBuffer.hasRemaining())
            {
                System.out.println((char) byteBuffer.get());
            }
            byteBuffer.clear();
            read = channel.read(byteBuffer);
        }
    }

    private static void writeFileChannel(FileChannel channel) throws Exception
    {
        ByteBuffer byteBuffer = ByteBuffer.allocate(48);
        String data = "abcdefghigklmnopqrstuvwxyz";
        byteBuffer.clear();
        byteBuffer.put(data.getBytes());
        byteBuffer.flip();
        while (byteBuffer.hasRemaining())
        {
            channel.write(byteBuffer);
        }
    }

    private static void changePosition(FileChannel channel, int offset) throws Exception
    {
        long position = channel.position();
        channel.position(position + offset);
    }


}
