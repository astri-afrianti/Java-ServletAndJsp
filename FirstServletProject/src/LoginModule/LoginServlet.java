package LoginModule;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet(description = ",",
			urlPatterns = "/LoginServlet",
			initParams = { 
					@WebInitParam(name = "user", value = "Astri"),
					@WebInitParam(name = "password", value = "123")
			})
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }
    
    @Override
    public void init() throws ServletException {
		boolean isDbTypeUrlCorrect = getServletContext().getInitParameter("dbTypeUrl").equals("jdbc:sqlite://");
		boolean isEndPathUrlCorrect = getServletContext().getInitParameter("dbEndPathUrl").equals("\\\\Database\\\\student.db");
		
		if (!isDbTypeUrlCorrect || !isEndPathUrlCorrect) {
			throw new ServletException("DB Connection error");
		}
		
		getServletContext().setAttribute("db_success", "true");		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//get request parameters for userID and password
		String requestUser = request.getParameter("user");
		String requestPassword = request.getParameter("password");
		
		String initUser = getServletConfig().getInitParameter("user");
		String initPassword = getServletConfig().getInitParameter("password");
		
		// logging
		log("User=" + requestUser + "::password=" + requestPassword);
		
		if (!initUser.equals(requestUser) || !initPassword.equals(requestPassword)) {
			RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/Login.html");
			PrintWriter out = response.getWriter();
			out.println("<font color=red>Either user name or password is wrong.</font>");
			dispatcher.include(request, response);
			
			return;
		}
		
		// expiry cookies from web.xml cookieAgeMins
		int cookieExpiresInMinutes = Integer.parseInt(getServletContext().getInitParameter("cookieAgeMins"));
				
		// session
		HttpSession session = request.getSession();
		session.setAttribute("user", requestUser);
		session.setMaxInactiveInterval(cookieExpiresInMinutes * 60);
		
		// check existing cookies
		Cookie loginCookie = null;
		Cookie[] cookies = request.getCookies();
		
		if (cookies != null) {
			for (Cookie cookie : cookies) {
				if (cookie.getName() == "user") loginCookie = cookie;
				break;
			}
		}
		
		if (loginCookie == null) {
			loginCookie = new Cookie("user", requestUser);
		}
			
		loginCookie.setMaxAge(cookieExpiresInMinutes * 60);
		response.addCookie(loginCookie);
		response.sendRedirect("LoginSuccess.jsp");
	}

}
