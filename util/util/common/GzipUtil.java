package util.common;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.Serializable;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;
import javax.enterprise.context.Dependent;


@Dependent
public class GzipUtil implements Serializable {

	private static final long serialVersionUID = 1L;
	
	public byte[] compressByte2Byte(byte[] byteData) {
		try {
			ByteArrayOutputStream byteStream = new ByteArrayOutputStream(byteData.length);
	        GZIPOutputStream zipStream = new GZIPOutputStream(byteStream);
	        zipStream.write(byteData);
	        zipStream.close();
	        byte[] compressed = byteStream.toByteArray();
	        byteStream.close();
	        return compressed;
		}
		catch (Exception e) {
			return null;
		}
        
    }
	
	public byte[] compressString2Byte(String stringData) {
		try {
			return compressByte2Byte(stringData.getBytes("UTF-8"));
		}
		catch (Exception e) {
			return null;
		}
    }
	
	public String compressByte2String(byte[] byteData) throws IOException {
		try {
			ByteArrayOutputStream byteStream = new ByteArrayOutputStream(byteData.length);
	        GZIPOutputStream zipStream = new GZIPOutputStream(byteStream);
	        zipStream.write(byteData);
	        zipStream.close();
	        byte[] compressed = byteStream.toByteArray();
	        byteStream.close();
	        return new String(compressed, "UTF-8");
		}
		catch (Exception e) {
			return null;
		}        
    }
	
	public String compressString2String(String stringData) throws IOException {
		try {
			return compressByte2String(stringData.getBytes("UTF-8"));
		}
		catch (Exception e) {
			return null;
		}        
    }

	//----------------------------------------------------------------------------------------------
	
    public byte[] decompressByte2Byte(byte[] byteData){
    	try {
    		Integer BUFFER_SIZE = 32;
            ByteArrayInputStream is = new ByteArrayInputStream(byteData);
            GZIPInputStream gis = new GZIPInputStream(is, BUFFER_SIZE);
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            byte[] data = new byte[BUFFER_SIZE];
            Integer bytesRead;
            while ((bytesRead = gis.read(data)) != -1) {
                baos.write(data, 0, bytesRead);
            }
            gis.close();
            return baos.toByteArray();
    		
		}
    	catch (Exception e) {
			return null;
		}
    }
    
    public byte[] decompressString2Byte(String stringData){
    	try {
    		return decompressByte2Byte(stringData.getBytes("UTF-8"));
		}
    	catch (Exception e) {
    		e.printStackTrace();
			return null;
		}
    }
    
    public String decompressByte2String(byte[] byteData){
    	try {
        	byte[] decompressByte = decompressByte2Byte(byteData);
        	return new String(decompressByte, "UTF-8");
		}
    	catch (Exception e) {
    		e.printStackTrace();
			return null;
		}
    }
    
    public String decompressString2String(String stringData){
    	try {
        	byte[] decompressByte = decompressString2Byte(stringData);
        	return new String(decompressByte, "UTF-8");
		}
    	catch (Exception e) {
    		e.printStackTrace();
			return null;
		}
    }

	
	
}
