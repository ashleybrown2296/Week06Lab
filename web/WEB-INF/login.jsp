<%-- 
    Document   : login
    Created on : Oct 2, 2017, 12:09:27 PM
    Author     : 679918
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="sait" uri="/WEB-INF/tlds/sait.tld" %>
<%@taglib prefix="ct" tagdir="/WEB-INF/tags" %>




<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">  
        <title>Login</title>
    </head>
    <body>
    <sait:debug>
        Remote Host: ${pageContext.request.remoteHost}<br/>
        Session ID: ${pageContext.session.id}
    </sait:debug>
        <ct:login username="${username}" password="${password}" checked="${checked}" message="${message}"></ct:login>
</body>
</html>
