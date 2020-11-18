package util.common;

import java.io.ByteArrayOutputStream;
import java.io.Serializable;
import java.util.Date;
import java.util.zip.Deflater;
import java.util.zip.Inflater;
import javax.enterprise.context.Dependent;


@Dependent
public class DeflateUtil implements Serializable {

	private static final long serialVersionUID = 1L;
	
	public byte[] compress(byte[] data){
		byte[] output = null;
		try {
			Deflater deflater = new Deflater();
			deflater.setInput(data);

			ByteArrayOutputStream outputStream = new ByteArrayOutputStream(data.length);

			deflater.finish();
			byte[] buffer = new byte[1024];
			while (!deflater.finished()) {
				int count = deflater.deflate(buffer); // returns the generated
				outputStream.write(buffer, 0, count);
			}
			outputStream.close();
			output = outputStream.toByteArray();

			System.out.println(new Date() + "  |    Original: " +   data.length / 1024 + " Kb");
			System.out.println(new Date() + "  |  Compressed: " + output.length / 1024 + " Kb");
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return output;
	}

	public byte[] decompress(byte[] data) {
		byte[] output = null;
		try {
			Inflater inflater = new Inflater();
			inflater.setInput(data);

			ByteArrayOutputStream outputStream = new ByteArrayOutputStream(data.length);
			byte[] buffer = new byte[1024];
			while (!inflater.finished()) {
				int count = inflater.inflate(buffer);
				outputStream.write(buffer, 0, count);
			}
			outputStream.close();
			output = outputStream.toByteArray();

			System.out.println("    Original: " + data.length);
			System.out.println("DeCompressed: " + output.length);
		}
		catch (Exception e) {
			e.printStackTrace();
		}		
		return output;
	}

}
