import java.io.*;
import java.nio.*;
import java.nio.channels.FileChannel;
public class Nio {
	public static void main(String[] args) {
		try {
			RandomAccessFile raf = new RandomAccessFile("name.txt", "rw");
			FileChannel channel = raf.getChannel();
			ByteBuffer buffer = ByteBuffer.allocate(14);
			int cursor = channel.read(buffer);
			while (cursor != -1) {
				System.out.print("Read :" + cursor + ":");
				buffer.flip();
				while (buffer.hasRemaining()) {
					System.out.print((char)buffer.get());
				}
				buffer.clear();
				cursor = channel.read(buffer);
				System.out.println("");
				System.out.println();
				System.out.println();
			}
			raf.close();
		}catch(Exception e){
			e.printStackTrace();
		}
	}
}