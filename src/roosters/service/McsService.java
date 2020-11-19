package roosters.service;

import org.json.JSONObject;

import roosters.dao.DAOFactory;
import roosters.dao.McsDAO;

public class McsService {
	
    DAOFactory factory = DAOFactory.getDAOFactory(DAOFactory.MYSQL);
    McsDAO dao = factory.getMcsDAO();

    public JSONObject save(JSONObject json) {
        JSONObject response = null;
        try {
        	response = dao.save();
        } catch (Exception e) {
          e.printStackTrace();
        }
        return response;
    }
    
    public JSONObject list() {
        JSONObject response = null;
        try {
        	response = dao.list();
        } catch (Exception e) {
          e.printStackTrace();
        }
        return response;
    }
    
    public JSONObject update(JSONObject json) {
        JSONObject response = null;
        try {
        	response = dao.update();
        } catch (Exception e) {
          e.printStackTrace();
        }
        return response;
    }
    
    public JSONObject delete(JSONObject json) {
        JSONObject response = null;
        try {
        	response = dao.delete();
        } catch (Exception e) {
          e.printStackTrace();
        }
        return response;
    }

}
