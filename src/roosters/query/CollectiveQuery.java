package roosters.query;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.json.JSONArray;
import org.json.JSONObject;

import roosters.dao.CollectiveDAO;

public class CollectiveQuery implements CollectiveDAO{

	@Override
	public JSONObject save(JSONObject json) {
        ResultSet rs = null;
        Connection cn = null;
        PreparedStatement ps = null;
        
        JSONArray data = new JSONArray();
        JSONObject response = new JSONObject();
        JSONObject obj = null;
        
        try {
            cn = MySQLDAOFactory.getConnection();

            String sql = "insert into collective(names, location, organizator) VALUES('"+json.getString("namesR")+"', '"+json.getString("locationR")+"', '"+json.getString("organizatorR")+"')";
            ps = cn.prepareStatement(sql);
            ps.execute();
            
            
        } catch (SQLException ex) {
        	response.put("message", ex.getLocalizedMessage());
            response.put("status", false);
            return response;
        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }
                if (ps != null) {
                    ps.close();
                }
                if (cn != null) {
                    cn.close();
                }
            } catch (SQLException ex) {
                System.out.println("Ha ocurrido el siguiente error: " + ex.getMessage());
            }
        }
        response.put("data", data);
        response.put("message", "Se inserto correctamente.");
        response.put("status", true);
        return response;
	}

	@Override
	public JSONObject update() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public JSONObject delete() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public JSONObject list() {
        ResultSet rs = null;
        Connection cn = null;
        PreparedStatement ps = null;
        
        JSONArray data = new JSONArray();
        JSONObject response = new JSONObject();
        JSONObject obj = null;
        
        try {
            cn = MySQLDAOFactory.getConnection();

            String sql = "select c.id, c.names, c.location, \r\n" + 
            		"c.organizator, (select count(cd.id_mcs) from collective_details cd where cd.id_collective=c.id) as Participators \r\n" + 
            		"from collective c;";
            ps = cn.prepareStatement(sql);
            rs = ps.executeQuery();
            
            while (rs.next()) {
            	obj = new JSONObject();
            	obj.put("id",rs.getInt("id"));
            	obj.put("names",rs.getString("names"));
            	obj.put("location",rs.getString("location"));
            	obj.put("organizator",rs.getString("organizator"));
            	obj.put("participators",rs.getString("Participators"));
                data.put(obj);
            }
            
        } catch (SQLException ex) {
        	response.put("message", ex.getLocalizedMessage());
            response.put("status", false);
            return response;
        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }
                if (ps != null) {
                    ps.close();
                }
                if (cn != null) {
                    cn.close();
                }
            } catch (SQLException ex) {
                System.out.println("Ha ocurrido el siguiente error: " + ex.getMessage());
            }
        }
        response.put("data", data);
        response.put("status", true);
        return response;
	}
	
	@Override
	public JSONObject getDataCollective(JSONObject json) {
        ResultSet rs = null;
        Connection cn = null;
        PreparedStatement ps = null;
        
        JSONArray data = new JSONArray();
        JSONObject response = new JSONObject();
        JSONObject obj = null;
        
        try {
            cn = MySQLDAOFactory.getConnection();

            String sql = "select *from collective where id="+json.getInt("id");
            ps = cn.prepareStatement(sql);
            rs = ps.executeQuery();
            
            while (rs.next()) {
            	obj = new JSONObject();
            	obj.put("id",rs.getInt("id"));
            	obj.put("names",rs.getString("names"));
            	obj.put("location",rs.getString("location"));
            	obj.put("organizator",rs.getString("organizator"));
                data.put(obj);
            }
            
        } catch (SQLException ex) {
        	response.put("message", ex.getLocalizedMessage());
            response.put("status", false);
            return response;
        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }
                if (ps != null) {
                    ps.close();
                }
                if (cn != null) {
                    cn.close();
                }
            } catch (SQLException ex) {
                System.out.println("Ha ocurrido el siguiente error: " + ex.getMessage());
            }
        }
        response.put("data", data);
        response.put("status", true);
        return response;
	}

}
