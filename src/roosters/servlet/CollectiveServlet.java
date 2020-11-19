package roosters.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONObject;

import roosters.service.CollectiveService;
import roosters.service.McsService;

public class CollectiveServlet extends HttpServlet{

	private static final long serialVersionUID = 1L;
	
	   @Override
	    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	  
	        response.setContentType("text/html");
	        String accion = request.getParameter("accion");
	        if (accion != null) {
	            switch (accion) {
	                case "save":
	                    save(request, response);
	                    break;
	                case "delete":
	                	delete(request, response);
	                	break;
	                case "list":
	                	list(request, response);
	                	break;
	                case "update":
	                	update(request, response);
	                	break;
	                default:
	                    break;
	            }
	        }
	    }

		private void update(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		
	}

		private void list(HttpServletRequest request, HttpServletResponse response) throws IOException {
			response.setContentType("application/json");
	        PrintWriter pw = response.getWriter();
	        JSONObject jsonObj = new JSONObject();
	        CollectiveService service = new CollectiveService();

	        jsonObj = service.list();
	        pw.print(jsonObj);
		
		}

		private void delete(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		
		}

		private void save(HttpServletRequest request, HttpServletResponse response) {
			
			
		}

}
