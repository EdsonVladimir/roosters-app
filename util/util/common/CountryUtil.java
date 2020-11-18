package util.common;


import java.io.Serializable;
import java.util.LinkedHashMap;
import java.util.Locale;
import javax.enterprise.context.Dependent;


@Dependent
public class CountryUtil implements Serializable {

	private static final long serialVersionUID = 1L;
	
	public LinkedHashMap<String,String> getCountryMap(String languageISO639) {
		LinkedHashMap<String,String> result = new LinkedHashMap<String,String>();
		String[] countryCodeList = Locale.getISOCountries();
		for (String countryCode : countryCodeList) {
			Locale locale = new Locale("", countryCode);
			if (languageISO639 == null) {
				languageISO639 = "";	
			}
			result.put(locale.getCountry() , locale.getDisplayCountry(new Locale(languageISO639)));
		}
		return result;        
    }
	
	public String getCountryName(String languageISO639, String countryCode) {
		String result = null;
		
		if (countryCode != null) {
		
			countryCode = countryCode.toUpperCase();
			
			String[] countryCodeList = Locale.getISOCountries();
			for (String countryCodeL : countryCodeList) {
				if (countryCode.equals(countryCodeL)) {
					Locale locale = new Locale("", countryCode);
					if (languageISO639 == null) {
						languageISO639 = "";	
					}
					result = locale.getDisplayCountry(new Locale(languageISO639));	
				}			
			}
			
		}
		return result;
    }
	
}
