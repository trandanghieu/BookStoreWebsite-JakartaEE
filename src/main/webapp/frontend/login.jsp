<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Login</title>
</head>
<body>

<jsp:directive.include file="header.jsp"/>

<div align="center">
    <h2>Please Login:</h2>
    <form>
        Email: <input type="text" size="10"/> <br/>
        Password: <input type="password" size="10"/>
        <input type="submit" value="Login">
    </form>
</div>

<jsp:directive.include file="footer.jsp"/>


</body>
</html>
