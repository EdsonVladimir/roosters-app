package util.common;


import java.util.Base64;


public class Base64Util   {

	public static String encode(byte[] data) {
		return Base64.getEncoder().encodeToString(data);	
	}
	
	public static String encode(String data) {
		return Base64.getEncoder().encodeToString(data.getBytes());	
	}
	
	public static byte[] decode(byte[] data) {
		return Base64.getDecoder().decode(data);
	}
	
	public static byte[] decode(String data) {
		return Base64.getDecoder().decode(data.getBytes());
	}
	
	
}
