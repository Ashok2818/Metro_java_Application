<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="com.daolayer.*"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Metro Articles Records</title>
<style>

          .add {
	
	border-radius : 5px;
    background    : #E6E6FA;
    padding       : 20px; 
    width         : 160px;
    height        : 180px;
	margin-top    :20px;
    font-size     :18px;
	color         :black;
}	
</style>
</head>
<body>



<form method="get">

 <% HttpSession sess =request.getSession(false); 
  String user =(String) sess.getAttribute("user_id");
  sess.setAttribute("user", user);%>

 
<div class="add">
<a href='#' onclick='javascript:window.open("Add_articles.jsp", "_blank", "scrollbars=1,resizable=1,location=center,height=350,width=450");' title='Pop Up'>Add Articles</a><br><br>
<!-- <a href='#' onclick='javascript:window.open("Delete_articles.jsp", "_blank", "scrollbars=1,resizable=1,location=center,height=300,width=400");' title='Pop Up'>Delete Articles</a><br><br> -->
 <button type="submit" formaction="/MetroProjectExample/refresh"  value="login">Refresh</button> <br><br>
 <button type="submit" formaction="/MetroProjectExample/logout" value="login">Logout</button><br>
 </div>
 
  
 
    <div align="center">
    
        <table border="1" cellpadding="5">
            <caption><h2>List of articles</h2></caption>
            <tr>
                <th>ArticleID</th>
                <th>Name</th>
                <th>STORE</th>
                <th>COLOR</th>
                <th>Edit</th>
                <th>Delete</th>
            </tr>
            <c:forEach items="${list}" var="ArticlesDisplayBean"> 
                <tr>
                    <td>${ArticlesDisplayBean.getArticle_id()}</td>
                    <td>${ArticlesDisplayBean.getArticle_name()}</td>
                    <td>${ArticlesDisplayBean.getStore_name()}</td>
                    <td>${ArticlesDisplayBean.getArticle_color()}</td>
                    <td><a href="/MetroProjectExample/editpanel?action=edit&userId=<c:out value="${ArticlesDisplayBean.getArticle_id()}"/>">Edit</a></td>
                    <td><a href="/MetroProjectExample/delete_articles?action=delete&Id=<c:out value="${ArticlesDisplayBean.getArticle_id()}"/>">Delete</a></td>
                </tr>
            </c:forEach>
        </table>
    </div>
    </form>
 
</body>
</html>