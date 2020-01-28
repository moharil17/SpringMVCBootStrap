<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<div class="col-sm-5">
		<form class="form-signin" action="addBook" method="post">

			<h1 class="h3 mb-3 font-weight-normal">Add Book Here</h1>
			<div class="form-group row">
				<label for="inputBookName" class="sr-only">Book Name</label>
				<div class="col-sm-10">
					<input type="text" name="bookName" id="bookName"
						class="form-control" placeholder="Book name" required autofocus>
				</div>
			</div>
			<div class="form-group row">
				<label for="authorName" class="sr-only">Author Name</label>
				<div class="col-sm-10">
					<input type="text" name="authorName" id="authorName"
						class="form-control" placeholder="authorName" required>
				</div>
			</div>

			<div class="form-group row">
				<label for="inputPassword" class="sr-only">Year Publication</label>
				<div class="col-sm-10">
					<input type="text" name="date" id="date" class="form-control"
						placeholder="date" required>
				</div>
			</div>


			<div class="col-sm-2" class="text-align-center">
				<button class="btn btn-lg btn-primary btn-block" type="submit">Add</button>
			</div>


		</form>
	</div>
</body>
</html>