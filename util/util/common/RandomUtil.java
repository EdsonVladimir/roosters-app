package util.common;


import java.util.Random;


public class RandomUtil{

	public static Integer numeric(Integer length) {
		Random r = new Random();
		Double DLow = Math.pow(10, length-1);
		Integer Low = DLow.intValue();
		Double DHigh = Math.pow(10, length);
		Integer High = DHigh.intValue();
		Integer R = r.nextInt(High-Low) + Low;
		return R;
	}

	public static String alphanumeric(Integer length) {
		byte random[] = new byte[length];
		Random randomGenerator = new Random();
		StringBuffer buffer = new StringBuffer();
		randomGenerator.nextBytes(random);
		for (int j = 0; j < random.length; j++) {
			byte b1 = (byte) ((random[j] & 0xf0) >> 4);
			byte b2 = (byte) (random[j] & 0x0f);
			if (b1 < 10)
				buffer.append((char) ('0' + b1));
			else
				buffer.append((char) ('A' + (b1 - 10)));
			if (b2 < 10)
				buffer.append((char) ('0' + b2));
			else
				buffer.append((char) ('A' + (b2 - 10)));
		}
		return (buffer.toString());

	}

	
}
