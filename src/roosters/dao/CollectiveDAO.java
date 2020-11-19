package roosters.dao;

import org.json.JSONObject;

public interface CollectiveDAO {

	public JSONObject save(JSONObject json);
	public JSONObject update();
	public JSONObject delete();
	public JSONObject list();

}
