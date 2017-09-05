<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

<c:set var="code" value="代码" scope="request" />
<c:out value="${code }" default="当要输出的内容为null时会输出default指定的值" escapeXml="true" />
<c:remove var="code" scope="request" />
<c:out value="${code }" default="当要输出的内容为null时会输出default指定的值" escapeXml="true" />
<br/>

<c:url value="/AServlet" />
<a href="<c:url value="/AServlet" />">点击这里</a>
<br/>

<c:url value="/AServlet">
	<c:param name="name" value="张三" />
</c:url>
<br/>	

<c:if test="${empty param.name }">
	没有name
</c:if>
<c:if test="${not empty param.name }">
	有name值为<c:out value="${param.name }" />
</c:if>
<br/>

<c:choose>
	<c:when test="${empty param.name }">
		没有name
	</c:when>
	<c:otherwise>
		有name值为<c:out value="${param.name }" />
	</c:otherwise>
</c:choose>
<br/>

<c:forEach var="i" begin="1" end="10" step="2">
	${i }
</c:forEach>
<br/>

<%
	String[] strs = {"one","two"};
	request.setAttribute("strs", strs);
%>
<c:forEach items="${requestScope.strs }" var="str">
	${str }
</c:forEach>
<br/>

<%
	ArrayList<String> list = new ArrayList<String>();
	list.add("一");
	list.add("二");
	list.add("三");
	pageContext.setAttribute("list", list);
%>
<c:forEach items="${pageScope.list }" var="ele" varStatus="vs">
	${vs.index }${vs.count }${vs.first }${vs.last }${vs.current }${ele }
</c:forEach>

</body>
</html>