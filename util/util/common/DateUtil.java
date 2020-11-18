package util.common;


import java.text.DateFormatSymbols;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;


public class DateUtil {
	    
	public static String getMonthName(String languageISO639, Integer monthNumber) {
		String result = null;
		if (languageISO639 == null) {
			languageISO639 = "";	
		}
		String[] months = new DateFormatSymbols(new Locale(languageISO639)).getMonths();
		if (monthNumber != null) {
			if (monthNumber > 0 && monthNumber < 13) {
				result = months[monthNumber-1].substring(0, 1).toUpperCase() + months[monthNumber-1].substring(1);
			}
		}
		return result;
    }
	
	public static Map<Integer, String> listMonths() {
		Map<Integer, String> result = new HashMap<Integer, String>();
		result.put(1,"January");
		result.put(2,"February");
		result.put(3,"March");
		result.put(4,"April");
		result.put(5,"May");
		result.put(6,"June");
		result.put(7,"July");
		result.put(8,"August");
		result.put(9,"September");
		result.put(10,"October");
		result.put(11,"November");
		result.put(12,"December");
		return result;
    }
	
	
    public static Date asDate(LocalDate localDate) {
        return Date.from(localDate.atStartOfDay().atZone(ZoneId.systemDefault()).toInstant());
    }
 
    public static Date asDate(LocalDateTime localDateTime) {
        return Date.from(localDateTime.atZone(ZoneId.systemDefault()).toInstant());
    }
 
    public static LocalDate asLocalDate(Date date) {
        return Instant.ofEpochMilli(date.getTime()).atZone(ZoneId.systemDefault()).toLocalDate();
    }
 
    public static LocalDateTime asLocalDateTime(Date date) {
        return Instant.ofEpochMilli(date.getTime()).atZone(ZoneId.systemDefault()).toLocalDateTime();
    }
    
    /** @param	String	Format yyyy-MM-dd HH:mm:ss */
    public static LocalDateTime asLocalDateTime(String date) {
        return LocalDateTime.parse(date.replace("T", ""), DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));        
	}
    
	/** @param	String	Format yyyy-MM-dd HH:mm:ss */
	public static String asString(LocalDateTime localDateTime) {
        return localDateTime.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));        
	}
	
	/** @param	String	Format yyyyMMddHHmmss */
	public static String asStringyyyyMMddHHmmss(LocalDateTime dateTime) {
        return dateTime.format(DateTimeFormatter.ofPattern("yyyyMMddHHmmss"));        
	}
    
	
}
