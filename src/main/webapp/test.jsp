<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<c:foreach var="boardItem" items="{boardItems}">
${boardItem.name}
</c:foreach>
