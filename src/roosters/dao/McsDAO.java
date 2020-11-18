package roosters.dao;

import org.json.JSONObject;

public interface McsDAO {
	
	public JSONObject save();
	public JSONObject update();
	public JSONObject delete();
	public JSONObject list();
}
