<%@page import="com.entities.Note"%>
<%@page import="java.util.List"%>
<%@page import="org.hibernate.Query"%>
<%@page import="com.helper.FactoryProvider"%>
<%@page import= "org.hibernate.Session" %>
<%@page import= "java.util.Date" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<%@ include file="allLinks.jsp" %>
<title>All Notes : Note Taker</title>
</head>
<body>
<div class="container">
<%@ include file="navbar.jsp" %>
<br>
<h1 class="text-uppercase">All Notes:</h1>
<div class="row">
	<div class="col-12">
	<%
Session session1 = FactoryProvider.getFactory().openSession();
Query query = session1.createQuery("from Note");
List<Note> list = query.list();
for(Note note:list){
	%>
	<div class="card mt-3" >
	<img class="card-img-top m-4 mx-auto" style=" max-width:100px;" src="images/pencil.png" alt="Card image cap">
   
  <div class="card-body px-5">
    <h5 class="card-title"><%= note.getTitle() %></h5>
    <p class="card-text"><%= note.getContent() %></p>
     <p class="card-text"><b><%= note.getCreatedDate() %></b></p>
 <div class="container text-center mt-2">
    <a href="DeleteServelt?noteId=<%= note.getId() %>" class="btn btn-danger">Delete</a>
    <a href="edit.jsp?noteId=<%= note.getId() %>" class="btn btn-primary">Update</a>
 </div>
  
  </div>
</div>

<%
}
session1.close();
%>
	</div>

</div>


</div>


</body>
</html>