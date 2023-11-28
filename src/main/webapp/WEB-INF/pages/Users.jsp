<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<t:pageTemplate pageTitle="User">
    <h1>User</h1>
    <div class="container text-center">
        <jsp:useBean id="Users" scope="request" type="java.util.List"/>
        <c:forEach var="User" items="${Users}">
            <div class="row">
                <div class="col">
                        ${User.username}
                </div>
                <div class="col">
                        ${User.email}
                </div>
            </div>
        </c:forEach>
    </div>

</t:pageTemplate>