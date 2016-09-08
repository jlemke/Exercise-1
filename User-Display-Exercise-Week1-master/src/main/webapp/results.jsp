<%@include file="head.jsp"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html><body>

<%--TODO Pretty up the results!--%>
<div class="container-fluid">
    <h2>Search Results: </h2>

    <table class="table">
    <c:forEach items="${users}" var="user">
        <tr>
            <td>${user.userid}</td>
            <td>${user.firstName}</td>
            <td>${user.lastName}</td>
            <td>${user.dateOfBirth}</td>
        </tr>
    </c:forEach>
    </table>
</div>

</body>
</html>
