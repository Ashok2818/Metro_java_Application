<%@page import="com.daolayer.EditPanelBean"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<style>
table {
	width: 550px;
	border-collapse: collapse;
	margin: auto;
	background-color: #FFB6C1;
	border: 2px solid black;
	table-layout: fixed;
}

td {
	text-align: center;
	border: 2px solid green;
	background-color: #E6E6FA;
}

input {
	width: 100%;
	box-sizing: border-box;
	background-color: #E6E6FA;
}
</style>


</head>
<body>
	<form action="" method="get">

		<%
			HttpSession sess = request.getSession(false);
			String user = (String) sess.getAttribute("user");
			/* if(session.getAttribute("user") != null && session != null){ */
			sess.setAttribute("user", user);%>

		<% 	EditPanelBean ep = (EditPanelBean) request.getAttribute("ep");
			String id = ep.getArticle_id();
			String name = ep.getArticle_name();
			String store = ep.getStore_name();
			String color = ep.getArticle_color();
		%>
		
		

		<table>
			<tr>
				<th>ID</th>
				<th>Name</th>
				<th>STORE</th>
				<th>COLOR</th>
				<th>Update</th>
			</tr>
			<tr>
				<td><%=id%></td>
				<td><input type="text"  id="name"  value="<%=name%>" onchange="myFunction()"></td>
				<td><input type="text"  id="store" value="<%=store%>" ></td>
				<td><input type="text" id="color"  value="<%= color %>" ></td>
				 
						
				<td><a href="/MetroProjectExample/update?id=<%=id%>&name=<%=name%>">update</a></td> 
				<%-- <%
			       request.setAttribute("articlname",name);	
				%> --%>
				<%-- <td><a href="/MetroProjectExample/update?action=update&userId=<c:out value="${ArticlesDisplayBean.getArticle_id()}"/>">Update</a></td> --%>
			<%-- 	 <td><a href="/MetroProjectExample/update?id=<c:out value="${id}"/>&name=<c:out value="${articlname}"/>&store=<c:out value="${articlestore}"/>$color=<c:out value="${articlecolor}"/>">update</a></td> --%>
				 
				<!--  <td><a href="/MetroProjectExample/update">update</a></td> -->
			</tr>
			<p id="demo"></p>
			<script>
function myFunction() {
    var x = document.getElementById("name").value
    var y = document.getElementById("store").value
    var z = document.getElementById("color").value
    document.getElementById("demo").innerHTML = "You selected: " + y;
    document.getElementById("demo").innerHTML = "You selected: " + y;
    document.getElementById("demo").innerHTML = "You selected: " + z;
}
        </script> 
        		</table>
        	</form>
        </body>
        </html>
   