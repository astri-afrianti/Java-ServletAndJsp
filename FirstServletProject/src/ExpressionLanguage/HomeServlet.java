package ExpressionLanguage;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class HomeServlet
 */
@WebServlet("/HomeServlet")
public class HomeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public HomeServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ArrayList<Employee> persons = new ArrayList<Employee>();
		
		//Setting some attributes
		Employee person = new Employee();
		person.setName("Ariana Waras");
		person.setId(1);
		person.setRole("Boss");
		
		request.setAttribute("person", person);
		persons.add(person);
		
		Employee employee = new Employee();
		Address address = new Address();
		address.setAddress("Indonesia");
		employee.setAddress(address);
		employee.setId(2);
		employee.setName("Astri Afrianti");		
		employee.setRole("Buruh");
		
		HttpSession session = request.getSession();
		session.setAttribute("employee", employee);
		persons.add(employee);
		
		request.setAttribute("personArray", persons);
		request.setAttribute("htmlTagData", "<br/> creates a new line.");
		request.setAttribute("url", "https://www.journaldev.com");
		
		response.addCookie(new Cookie("UserCookie","TomcatUser"));
		getServletContext().setAttribute("UserCookie","TomcatUser");
		
		RequestDispatcher requestDispather = getServletContext().getRequestDispatcher("/ExpressionLanguage/Home.jsp");
		requestDispather.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
