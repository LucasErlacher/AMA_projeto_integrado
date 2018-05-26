<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set var="cp" value="${pageContext.request.servletContext.contextPath}" scope="request" />
 
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Spring 4 Web MVC via Annotations</title>
    </head>
    <body>
        <h4>Spring 4 Web MVC via Annotations</h4>
        Spring says: <span class="blue">${msg}</span>
    </body>
</html>