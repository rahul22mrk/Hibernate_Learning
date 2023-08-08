<%@page import="com.entities.Note"%>
<%@page import="com.helper.FactoryProvider"%>
<%@page import="org.hibernate.Session"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Edit Notes</title>
<%@ include file="allLinks.jsp" %>
</head>
<body>
 <div class="container">
   	<%@ include file="navbar.jsp" %>
   	<h1>Edit Your Note</h1>
   	<br>
   	<%
   	 int noteId = Integer.parseInt(request.getParameter("noteId").trim());
   	Session session2 = FactoryProvider.getFactory().openSession();
   	
   	Note note = (Note)session2.get(Note.class, noteId);
   	%>
   	<br>
   	<!-- This is add forms -->
   	<form action="UpdateServelt" method="post">
  <input  name="hiddenNoteId"  id="hiddenNoteId" type="hidden" value="<%= note.getId() %>">
    
  <div class="form-group">
    <label for="title">Note Title</label>
    <input type="text" name="title" class="form-control" id="title" placeholder="Enter here" required value="<%= note.getTitle() %>">
      </div>
  <div class="form-group">
    <label for="content">Note Content</label>
   <textarea  id="content" name="content" required placeholder="Enter Your Content Here" class="form-control" style="height:300px"
     > <%= note.getContent() %></textarea>
   </div>
  <div class="container text-center">
  <button type="submit" class="btn btn-success">Update Your Note</button>
  
  </div>
 </form>
   </div>
</body>
</html>