package mvc.pattern;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ControllerServlet
 */
@WebServlet("/LoginDo")
public class ControllerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ControllerServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher dispatcher = request.getRequestDispatcher("/mvc.pattern/LoginDoView.jsp");
		dispatcher.include(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		String name = request.getParameter("user");
		String password = request.getParameter("password");
		
		LoginBean bean = new LoginBean(name, password);
		request.setAttribute("bean", bean);
		
		RequestDispatcher dispatcher = null;
		if (bean.validate()) {
			dispatcher = request.getRequestDispatcher("/mvc.pattern/LoginSuccessView.jsp");
		} else {			
			dispatcher = request.getRequestDispatcher("/mvc.pattern/LoginDoView.jsp");
			out.println("<font color=red>Either user name or password is wrong.</font>");
		}
		
		dispatcher.include(request, response);		
	}

}
