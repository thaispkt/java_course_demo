<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%--
    <%! code JAVA %>: khai báo biến
    <% code JAVA %>: thẻ xử lý logic code
    <%= code JAVA %>: Xuất giá trị của biến ra HTML
--%>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<%! int count = 10; %>
<%
    count++;
    String color = (count % 2 == 0) ? "green" : "red";
%>
<body>
    Hello Servlet
    <h1><%= count %></h1>
    <h1 style="color: <%= color %>;"><%= count %></h1>
    <% if(count %2) ==) {%>
     <h1 style="color:blue"><%= count %></h1>
     <% } else { %>
     <h1 style="color:green"><%= count %></h1>
     <% } %>
</body>
</html>