<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<nav class="navbar navbar-dark fixed-top bg-info flex-md-nowrap p-0 shadow">
    <div class="container">
        <a class="navbar-brand col-sm-3 col-md-2 mr-0" href="meals"><spring:message code="app.title"/></a>
        <form class="form-inline my-2">
            <a class="btn btn-info mr-1" href="users"><spring:message code="user.title"/></a>
            <a class="btn btn-primary" type="submit">
                <span class="fa fa-sign-in"></span>
            </a>
        </form>
    </div>
</nav>
