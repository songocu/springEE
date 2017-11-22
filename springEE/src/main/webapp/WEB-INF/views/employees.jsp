<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<body>
	aaa
	<table>
		<c:forEach var="item" items="${items}">
			<tr>
				<td><c:out value="${item}" /></td>
			</tr>
		</c:forEach>
		<table>bbb
</body>
</html>