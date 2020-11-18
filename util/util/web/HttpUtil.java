package util.web;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class HttpUtil {

		
	public static String getCookieValue(HttpServletRequest req, String name) {
        for (Cookie cookie : req.getCookies()) {
            if (cookie.getName().equalsIgnoreCase(name)) {
                return cookie.getValue();
            }
        }
        return null;
    }
    
    public static void setCookie(HttpServletResponse response, String name, String value) {
    	setCookie(response, name, value, null, null, null);
    }
	
    public static void setCookie(HttpServletResponse response, String name, String value, String domain, String path, Integer maxage) {
    	Cookie cookie = new Cookie(name, value);
    	if (domain != null) {
    		cookie.setDomain(domain);
		}
    	if (path != null) {
    		cookie.setPath(path);
		}
    	if (maxage != null) {
    		cookie.setMaxAge(maxage);
		}
        response.addCookie(cookie);
    }
    
    public static void setCookie(HttpServletResponse response, Cookie cookie) {
        response.addCookie(cookie);
    }
    
    
    public static void removeCookie(HttpServletResponse res, String name) {
        Cookie cookie = new Cookie(name, "");
        cookie.setMaxAge(0);
        cookie.setPath("/");
        res.addCookie(cookie);
    }
	
	
}
