package ServletAnnotation;

import java.io.IOException;

import javax.servlet.DispatcherType;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

/**
 * Servlet Filter implementation class HitCounterFilter
 */
@WebFilter(
	 	urlPatterns = "/processingservlet",
	 	dispatcherTypes = {
	 			DispatcherType.FORWARD,
	 			DispatcherType.REQUEST
	 	})
public class HitCounterFilter implements Filter {

	// reference variable to store the reference of filterconfig object of the filter
	private FilterConfig config;
	
    /**
     * Default constructor. 
     */
    public HitCounterFilter() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		// Reference of ServletContext is obtained
		ServletContext ctx = config.getServletContext();
		// obtaining hit count, incrementing it and resetting.
		
		Integer hitCount = (Integer)ctx.getAttribute("hitCount");
		hitCount++;
		
		ctx.setAttribute("hitCount", hitCount);
		
		// next component is get invoked
		chain.doFilter(request, response);
	}

	@Override
	public void init(FilterConfig fConfig) throws ServletException {
		this.config = fConfig;
	}

}
