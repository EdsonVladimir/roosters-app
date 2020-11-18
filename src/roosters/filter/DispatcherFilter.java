package roosters.filter;

import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpFilter;

@WebFilter(urlPatterns = { "/dispatcher"})
public class DispatcherFilter extends HttpFilter{

	private static final long serialVersionUID = 1L;

}
