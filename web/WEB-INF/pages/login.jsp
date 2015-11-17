<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Login Page</title>
    <link rel="stylesheet" type="text/css" href="../../resources/login.css">
</head>
<body onload='document.loginForm.username.focus();'>

<h1>Spring Security Custom Login Form (XML)</h1>

<div id="login-box">

    <h2>Login with Username and Password</h2>

    <c:if test="${not empty error}">
        <div class="error">${error}</div>
    </c:if>
    <c:if test="${not empty msg}">
        <div class="msg">${msg}</div>
    </c:if>

    <form name='loginForm' action="<c:url value='/auth/login_check?targetUrl=${targetUrl}' />" method='POST'>
        <table>
            <tr>
                <td>User:</td>
                <td><input type='text' name='username'></td>
            </tr>
            <tr>
                <td>Password:</td>
                <td><input type='password' name='password'/></td>
            </tr>

            <!-- if this is login for update, ignore remember me check -->
            <%--<c:if test="${empty loginUpdate}">
                <tr>
                    <td></td>
                    <td>Remember Me: <input type="checkbox" name="remember-me"/></td>
                </tr>
            </c:if>--%>

            <tr>
                <td colspan='2'><input name="submit" type="submit" value="submit"/></td>
            </tr>

        </table>

        <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
    </form>

</div>

</body>
</html>