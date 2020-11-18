package util.common;

import java.io.InputStream;
import java.io.Serializable;
import java.net.URL;

import javax.enterprise.context.Dependent;
import javax.json.Json;
import javax.json.JsonObject;
import javax.json.JsonReader;


@Dependent
public class IpInfoUtil implements Serializable {

	private static final long serialVersionUID = 1L;

	
	//  https://geoipify.whoisxmlapi.com | admin@asterisk360.com | p4ssw0rd
	public GeoInfo getInfoByGeoipify(String ip) {
		GeoInfo result = null;
		try {
			String IP = ip;
			String API_KEY = "at_Y9VPZUuwRkB60TzuCxdNJUlYIiwtl";
	        String API_URL = "https://geoipify.whoisxmlapi.com/api/v1?";
	        String url = API_URL + "&apiKey=" + API_KEY + "&ipAddress=" + IP;
	        
	        URL endpoint = new URL(url);
	        
	        InputStream is = endpoint.openStream();
	        JsonReader rdr = Json.createReader(is);
	        JsonObject obj = rdr.readObject();
	        
	        result = new GeoInfo();
	        result.setIp(obj.getString("ip"));
	        result.setCountry_code(obj.getString("country"));
	        result.setRegion_name(obj.getString("region"));
	        result.setCity(obj.getString("city"));
		}   
		catch (Exception e) {
			e.printStackTrace();
		}		
		return result;		
	}
	
	//  https://ipstack.com/ | admin@asterisk360.com | p4ssw0rd
	public GeoInfo getInfoByIpstack(String ip) {
		GeoInfo result = null;
		try {
			String IP = ip;
			String API_KEY = "a97b1cc9aa5c760996585cb833176a85";
	        String API_URL = "http://api.ipstack.com";
	        String url = API_URL + "/" + IP + "?access_key=" + API_KEY ;        
	        URL endpoint = new URL(url);
	        
	        InputStream is = endpoint.openStream();
	        JsonReader rdr = Json.createReader(is);
	        JsonObject obj = rdr.readObject();
	        
	        result = new GeoInfo();
	        result.setIp(obj.getString("ip"));
	        result.setCountry_code(obj.getString("country_code"));
	        result.setCountry_name(obj.getString("country_name"));
	        result.setRegion_code(obj.getString("region_code"));
	        result.setRegion_name(obj.getString("region_name"));	
	        result.setCity(obj.getString("city"));
		}   
		catch (Exception e) {
			e.printStackTrace();
		}		
		return result;		
	}	
}


class GeoInfo {
	
	private String ip;
	private String country_code;
	private String country_name;
	private String region_code;
	private String region_name;
	private String city;
	
	public String getIp() {
		return ip;
	}
	public void setIp(String ip) {
		this.ip = ip;
	}
	public String getCountry_code() {
		return country_code;
	}
	public void setCountry_code(String country_code) {
		this.country_code = country_code;
	}
	public String getCountry_name() {
		return country_name;
	}
	public void setCountry_name(String country_name) {
		this.country_name = country_name;
	}
	public String getRegion_code() {
		return region_code;
	}
	public void setRegion_code(String region_code) {
		this.region_code = region_code;
	}
	public String getRegion_name() {
		return region_name;
	}
	public void setRegion_name(String region_name) {
		this.region_name = region_name;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}

	
	
}

