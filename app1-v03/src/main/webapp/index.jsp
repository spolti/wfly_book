<%@ page import="javax.management.MBeanServer,java.lang.management.ManagementFactory,javax.management.ObjectName" %>
<html>
<body>
<h2>Hello there, here is our second web app running on the new WildFly Server <br>
Using a context root configuration to change the Application URI, see below some configurations!</h2>

<%
	MBeanServer mBeanServer = ManagementFactory.getPlatformMBeanServer();
	ObjectName http = new ObjectName("jboss.as:socket-binding-group=standard-sockets,socket-binding=http");

	String wfly_home = (System.getProperty("jboss.home.dir"));
	String wfly_server = (System.getProperty("jboss.server.base.dir"));
	String wfly_log_dir = (System.getProperty("jboss.server.log.dir"));
	int wfly_http_port = (Integer) mBeanServer.getAttribute(http, "boundPort");
	
	out.println("<b>WildFly home: </b>" + wfly_home);
	out.println("<br><b>WildFly Server base directory: </b>" + wfly_server);
	out.println("<br><b>WildFly Logs Directory: </b>" + wfly_log_dir);
	out.println("<br><b>WildFly HTTP port: </b>" + wfly_http_port);
	out.println("<br><b>WildFly Context Root: app1-v02</b>");
 %>

</body>
</html>
