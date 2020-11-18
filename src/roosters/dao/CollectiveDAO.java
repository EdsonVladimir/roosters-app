package roosters.dao;

import org.json.JSONObject;

public interface CollectiveDAO {

	public JSONObject save();
	public JSONObject update();
	public JSONObject delete();
	public JSONObject list();

}
