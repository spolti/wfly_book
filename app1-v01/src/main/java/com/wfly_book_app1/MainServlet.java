package com.wfly_book_app1;

import java.io.IOException;
import java.io.PrintWriter;
import java.lang.management.ManagementFactory;

import javax.management.AttributeNotFoundException;
import javax.management.InstanceNotFoundException;
import javax.management.MBeanException;
import javax.management.MBeanServer;
import javax.management.MalformedObjectNameException;
import javax.management.ObjectName;
import javax.management.ReflectionException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MainServlet extends HttpServlet{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public MainServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
	throws ServletException, IOException{
		
		MBeanServer mBeanServer = ManagementFactory.getPlatformMBeanServer();
		ObjectName http = null;
		try {
			http = new ObjectName("jboss.as:socket-binding-group=standard-sockets,socket-binding=http");
		} catch (MalformedObjectNameException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NullPointerException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		String wfly_home = (System.getProperty("jboss.home.dir"));
		String wfly_server = (System.getProperty("jboss.server.base.dir"));
		String wfly_log_dir = (System.getProperty("jboss.server.log.dir"));
		int wfly_http_port = 0;
		try {
			wfly_http_port = (Integer) mBeanServer.getAttribute(http, "boundPort");
		} catch (AttributeNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InstanceNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (MBeanException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ReflectionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		PrintWriter out = response.getWriter();
		out.println("<html>");
		out.println("<body>");
		out.println("<h2>Hello there, here is our first web app running on the new WildFly Server, see below some configurations!</h2>");
		out.println("<b>WildFly home: </b>" + wfly_home);
		out.println("<br><b>WildFly Server base directory: </b>" + wfly_server);
		out.println("<br><b>WildFly Logs Directory: </b>" + wfly_log_dir);
		out.println("<br><b>WildFly HTTP port: </b>" + wfly_http_port);
		out.println("</body>");
		out.println("</html>");	
	}
	
}
