package roosters.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONObject;

import roosters.service.AuthService;

public class AuthServlet extends HttpServlet{

	private static final long serialVersionUID = 1L;

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        response.setContentType("text/html");
        String accion = request.getParameter("accion");
        if (accion != null) {
            switch (accion) {
                case "singnIn":
                	singnIn(request, response);
                    break;
                default:
                    break;
            }
        }
    }

	private void singnIn(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("application/json");
        PrintWriter pw = response.getWriter();
        JSONObject jsonObj = new JSONObject();
        JSONObject envia = new JSONObject(request.getParameter("json"));
        AuthService service = new AuthService();
        jsonObj = service.singnIn(envia);
        pw.print(jsonObj);
		
	}


	

}
