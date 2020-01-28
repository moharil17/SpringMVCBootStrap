<!doctype html>
<html lang="en">
<head>
<%@include file="includes/header.jsp"%>
</head>

<body class="text-center">

	<div class="col-sm-5">
		<form class="form-signin" action="login" method="post">

			<h1 class="h3 mb-3 font-weight-normal">Please sign in</h1>
			<div class="form-group row">
				<label for="inputEmail" class="sr-only">Email address</label>
				<div class="col-sm-10">
					<input type="email" name="userEmail" id="inputEmail"
						class="form-control" placeholder="Email address" required
						autofocus>
				</div>
			</div>
			<div class="form-group row">
				<label for="inputPassword" class="sr-only">Password</label>
				<div class="col-sm-10">
					<input type="password" name="userPassword" id="inputPassword"
						class="form-control" placeholder="Password" required>
				</div>
			</div>
			<div class="form-group row">
				<!-- <div class="checkbox mb-2"> -->
				<div class="col-sm-6">
					<label> <input type="checkbox" value="remember-me">
						Remember me
					</label>
				</div>

				<div class="col-sm-5">
					<a href="signUp" class="text-info"> Register here</a>
				</div>


			</div>
	</div>
	<div class="col-sm-2" class="text-align-center">
		<button class="btn btn-lg btn-primary btn-block" type="submit">Sign
			in</button>
	</div>


	</form>

</body>
</html>
