package roosters.service;

import org.json.JSONObject;

import roosters.dao.CollectiveDAO;
import roosters.dao.DAOFactory;

public class CollectiveService {
	
    DAOFactory factory = DAOFactory.getDAOFactory(DAOFactory.MYSQL);
    CollectiveDAO dao = factory.getCollectiveDAO();

    public JSONObject save(JSONObject json) {
        JSONObject response = null;
        try {
        	response = dao.save(json);
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
