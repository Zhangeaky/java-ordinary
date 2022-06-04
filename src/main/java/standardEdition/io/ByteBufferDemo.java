package standardEdition.io;

import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.StandardCharsets;

/**
 * JAVA ByteBuffer
 *
 *
 *
 *
 *
 */
public class ByteBufferDemo {

    public static void testRandomAccessFileWrite() throws  Exception {

        java.io.RandomAccessFile raf = new RandomAccessFile("/Users/kimchang/file.txt", "rw");

        raf.write("hello ant\n".getBytes());
        raf.write("hello zhangyikai\n".getBytes());
        System.out.println("write------------");
        System.in.read();

        raf.seek(4);
        raf.write("rocket".getBytes());

        System.out.println("seek---------");
        System.in.read();

        FileChannel rafchannel = raf.getChannel();
        //mmap  堆外  和文件映射的   byte  not  objtect
        MappedByteBuffer map = rafchannel.map(FileChannel.MapMode.READ_WRITE, 0, 4096);

        map.put("@@@".getBytes());  //不是系统调用  但是数据会到达 内核的pagecache
        //曾经我们是需要out.write()  这样的系统调用，才能让程序的data 进入内核的pagecache
        //曾经必须有用户态-->内核态切换。
        //mmap的内存映射，依然是内核的pagecache体系所约束的！！！
        //换言之，丢数据。
        //你可以去github上找一些 其他C程序员写的jni扩展库，使用linux内核的Direct IO
        //直接IO是忽略linux的pagecache
        //是把pagecache  交给了程序自己开辟一个字节数组当作pagecache，动用代码逻辑来维护一致性/dirty。。。一系列复杂问题。
        //相当于开辟数组，自己管理pagecache, 可以更细力度控制pagecache
        //lsof $$ 看文件的内存映射

        System.out.println("map--put--------");
        System.in.read();

//        map.force(); //  flush

        raf.seek(0);

        ByteBuffer buffer = ByteBuffer.allocate(8192);
//        ByteBuffer buffer = ByteBuffer.allocateDirect(1024);

        int read = rafchannel.read(buffer);   //buffer.put()
        System.out.println(buffer);
        buffer.flip();
        System.out.println(buffer);

        for (int i = 0; i < buffer.limit(); i++) {
            Thread.sleep(200);
            System.out.print(((char)buffer.get(i)));
        }


    }



    public static void main(String[] args) {

        ByteBuffer buffer = ByteBuffer.allocate(1024);

        MappedByteBuffer mappedByteBuffer = (MappedByteBuffer) MappedByteBuffer.allocate(1024);

        buffer.put("zhangyikai".getBytes(StandardCharsets.UTF_8));

        System.out.println("1234".getBytes(StandardCharsets.UTF_8));

    }

}
