package roosters.service;

import org.json.JSONObject;

import roosters.dao.AuthDAO;
import roosters.dao.DAOFactory;

public class AuthService {
	
    DAOFactory factory = DAOFactory.getDAOFactory(DAOFactory.MYSQL);
    AuthDAO dao = factory.getAuthDAO();

    public JSONObject singnIn(JSONObject json) {
        JSONObject response = null;
        try {
        	response = dao.singnIn(json);
        } catch (Exception e) {
          e.printStackTrace();
        }
        return response;
    }

}
