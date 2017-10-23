<%-- 
    Document   : login
    Created on : Oct 16, 2017, 12:35:53 PM
    Author     : 679918
--%>

<%@tag description="login" pageEncoding="UTF-8"%>

<%-- The list of normal or fragment attributes can be specified here: --%>
<%@attribute name="username"%>
<%@attribute name="password"%>
<%@attribute name="checked"%>
<%@attribute name="errorMessage"%>



<%-- any content can be specified here e.g.: --%>

        <h1>Login</h1>
        <form action="login" method="POST">
            <p>Username:<input type="text" name="username" value="${username}"></p>
            <p>Password:<input type="password" name="password" value="${password}"></p>
            <br><input type="submit" value="Login">
            <p><input type="checkbox" name="remember" value="remember" ${checked}>Remember Me</p>
        </form>
        ${errorMessage}
