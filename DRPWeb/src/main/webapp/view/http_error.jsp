<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>Insert title here</title>
	</head>

	<body>
		<%
    Integer errorCode = (Integer) request.getAttribute("javax.servlet.error.status_code");
    //System.out.println("http_error=========" + errorCode);
    if (errorCode == 404) {
        response.sendRedirect(request.getContextPath() + "/404.html");
    } else if (errorCode == 500) {
        response.sendRedirect(request.getContextPath() + "/500.html");
    }
%>
	</body>

</html>