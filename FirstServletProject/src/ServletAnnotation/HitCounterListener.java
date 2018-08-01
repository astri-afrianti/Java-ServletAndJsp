package ServletAnnotation;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

/**
 * Application Lifecycle Listener implementation class HitCounterListener
 *
 */
@WebListener
public class HitCounterListener implements ServletContextListener {

    /**
     * Default constructor. 
     */
    public HitCounterListener() {
        // TODO Auto-generated constructor stub
    }

	/**
     * @see ServletContextListener#contextDestroyed(ServletContextEvent)
     */
    public void contextDestroyed(ServletContextEvent sce)  { 
         // TODO Auto-generated method stub
    }

	/**
     * @see ServletContextListener#contextInitialized(ServletContextEvent)
     */
    @Override
    public void contextInitialized(ServletContextEvent sce)  { 
         ServletContext ctx = sce.getServletContext();
         ctx.setAttribute("hitCount", 0);
    }
	
}
