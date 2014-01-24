<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Logging</title>
</head>
<body>

<h2>Hello there, here is our web app running on the new WildFly Server. <br>
This App Will print in the log file any messages:<br>
Log Levels: <br>

<ul>
<li>ERROR</li>
<li>WARN</li>
<li>INFO</li>
<li>DEBUG</li>
<li>TRACE</li>
</ul>
See in the log file messages like:<br></h2>

11:38:54,728 FATAL [com.wflybook.HomeController] (http--127.0.0.1-8080-1) This is a fatal message, a high level message error.<br>
11:38:54,728 ERROR [com.wflybook.HomeController] (http--127.0.0.1-8080-1) This is a error message.<br>
11:38:54,729 WARN  [com.wflybook.HomeController] (http--127.0.0.1-8080-1) This is a warning message.<br>
11:38:54,729 INFO  [com.wflybook.HomeController] (http--127.0.0.1-8080-1) This is a information message.<br>
11:38:55,730 DEBUG  [com.wflybook.HomeController] (http--127.0.0.1-8080-1) This is a debug message.<br>
11:38:55,730 TRACE  [com.wflybook.HomeController] (http--127.0.0.1-8080-1) This is a trace message, very detailed messages.<br>


</body>
</html>