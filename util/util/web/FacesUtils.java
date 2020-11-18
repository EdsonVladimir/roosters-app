package util.web;

import java.io.IOException;
import java.util.Map;
import javax.faces.application.FacesMessage;
import javax.faces.application.FacesMessage.Severity;
import javax.faces.component.UIInput;
import javax.faces.component.UIViewRoot;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.faces.context.Flash;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class FacesUtils{
	
	//------ Context ------
	public static FacesContext getFacesContext() {
	   	return FacesContext.getCurrentInstance();
	}
	public static ExternalContext getExternalContext() {
	   	return getFacesContext().getExternalContext();
	}
	//----- Http -----
	public static HttpServletRequest getHttpServletRequest() {
		return (HttpServletRequest) getExternalContext().getRequest();
	}    
	public static HttpServletResponse getHttpServletResponse() {
		return (HttpServletResponse) getExternalContext().getResponse();
	}
	
	
    //------ Messages ------
	public static void addFatalMessage(String clientId, String summary, String detail) {
    	addMessage(FacesMessage.SEVERITY_FATAL, clientId, summary, detail);
    }
	public static void addErrorMessage(String clientId, String summary, String detail) {
    	addMessage(FacesMessage.SEVERITY_ERROR, clientId, summary, detail);
    }
    public static void addInfoMessage(String clientId, String summary, String detail) {
    	addMessage(FacesMessage.SEVERITY_INFO, clientId, summary, detail);
    }
    public static void addWarnMessage(String clientId, String summary, String detail) {
    	addMessage(FacesMessage.SEVERITY_WARN, clientId, summary, detail);
    }

    public static void addMessage(Severity severity, String clientId, String summary, String detail) {
    	//getExternalContext().getFlash().setKeepMessages(true);
    	//getFacesContext().addMessage(clientId, new FacesMessage(severity, summary, detail));
    	Flash flash = getFacesContext().getExternalContext().getFlash();
    	flash.setKeepMessages(true);
    	flash.setRedirect(true);
    	getFacesContext().addMessage(clientId, new FacesMessage(severity, summary, detail));
    }
    
    public static void invalidateComponent(String clientId) {
    	UIViewRoot root = FacesContext.getCurrentInstance().getViewRoot();
    	UIInput input = (UIInput) root.findComponent(clientId);
    	input.setValid(false);
    }
    
    public static void invalidateSession() {
    	getExternalContext().invalidateSession();
    }
    
    

    
    
    //----- Parameters -----
	public static String getSessionIp() {
    	String ipAddress = getHttpServletRequest().getHeader("X-FORWARDED-FOR");
    	if (ipAddress == null) {
    	    ipAddress = getHttpServletRequest().getRemoteAddr();
    	}
    	return ipAddress;
    }
	public static String getRequestParameter(String parameter) {
        Map<String, String> paramMap = getExternalContext().getRequestParameterMap();
        return paramMap.get(parameter);
    }

	
    //----- Action -----
    public static void redirect(String url) {
    	try {
    		getExternalContext().redirect(url);
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    public static void forward(String url) {
    	try {
    		getExternalContext().dispatch(url);
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }
   
    //----- Cookies -----
    public static void createCookie(String name, String value) {
    	Cookie cookie = new Cookie(name, value);
    	cookie.setMaxAge(7 * 24 * 60 * 60);
		//cookie.setHttpOnly(true);
		cookie.setPath("/");
		getHttpServletResponse().addCookie(cookie);
    }
    
    public static void deleteCookie(String name) {
    	Cookie cookie = new Cookie(name, "");
    	cookie.setPath("/");
        cookie.setMaxAge(0);        
		getHttpServletResponse().addCookie(cookie);
    }
    
    public static String getCookieValue(String name) {
    	String value = null;
    	try {
    		Cookie[] userCookies = getHttpServletRequest().getCookies();
            if (userCookies != null && userCookies.length > 0 ) {
                for (int i = 0; i < userCookies.length; i++) {
                    if (userCookies[i].getName().equals(name)) {
                    	value = userCookies[i].getValue();
                    }
                }
            }
		}
    	catch (Exception e) {
		}
    	return value;
    	
    }

}
