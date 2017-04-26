package me.doublekill.channel;

import java.io.RandomAccessFile;
import java.nio.channels.FileChannel;

/**
 * Created by wangjunling on 2017/4/26.
 */
public class TransferExample
{
    public static void main(String[] args) throws Exception
    {
        RandomAccessFile fromFile = new RandomAccessFile("fromFile.txt", "rw");
        FileChannel fromFileChannel = fromFile.getChannel();
        RandomAccessFile toFile = new RandomAccessFile("toFile.txt", "rw");
        FileChannel toFileChannel = toFile.getChannel();
        long position = 0;
        long count = fromFileChannel.size();
        toFileChannel.transferFrom(fromFileChannel, position, count);

        // fromFileChannel.transferTo(position,count,toFileChannel);

    }
}
