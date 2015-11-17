<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@page session="true"%>
<html>
<body>
<h1>Title : ${title}</h1>
<h1>Message : ${message}</h1>
<form:form>
  <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
  <c:if test="${pageContext.request.userPrincipal.name != null}">
    <h2>Welcome : ${pageContext.request.userPrincipal.name}
      | <a href="<c:url value="/j_spring_security_logout" />" > Logout</a></h2>
  </c:if>
</form:form>
</body>
</html>