<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Add Notes</title>
<%@ include file="allLinks.jsp" %>
</head>
<body>
 <div class="container">
   	<%@ include file="navbar.jsp" %>
   	<br>
   	<h1>Please Fill Your Note Detail</h1>
   	<br>
   	<!-- This is add forms -->
   	<form action="SaveNoteServlet" method="post">
  <div class="form-group">
    <label for="title">Note Title</label>
    <input type="text" name="title" class="form-control" id="title" placeholder="Enter here" required>
      </div>
  <div class="form-group">
    <label for="content">Note Content</label>
   <textarea  id="content" name="content" required placeholder="Enter Your Content Here" class="form-control" style="height:300px"></textarea>
   </div>
  <div class="container text-center">
  <button type="submit" class="btn btn-primary">Add</button>
  
  </div>
 </form>
   </div>
</body>
</html>