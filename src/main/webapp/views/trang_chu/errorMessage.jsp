<%--
  Created by IntelliJ IDEA.
  User: thuct
  Date: 4/7/2023
  Time: 1:36 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" session="true" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ taglib prefix="f" uri="jakarta.tags.functions" %>
<body>
<c:forEach items="${ listError }" var="nv" varStatus="loop">
    <p>${nv}</p>
</c:forEach>
</body>

