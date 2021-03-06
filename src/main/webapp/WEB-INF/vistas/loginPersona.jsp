<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
	<head>
	<!-- Bootstrap core CSS -->
	    <link href="css/bootstrap.min.css" rel="stylesheet" >
	    <!-- Bootstrap theme -->
	    <link href="css/bootstrap-theme.min.css" rel="stylesheet">
	    <title>Login</title>
	    
	    <style>
	    	.inputStyle{
	    		margin-bottom: 20px;
	    	}
	    </style>
	</head>
	<body>
		<div class = "container">
			<div id="loginbox" style="margin-top:50px;" class="mainbox col-md-6 col-md-offset-3 col-sm-8 col-sm-offset-2">
				<form:form action="procesarLogin" method="POST" modelAttribute="persona">      
			    	<h3 class="form-signin-heading">Login</h3>
					<hr class="colorgraph"><br>
					
					<label for="usuario">Usuario</label>
					<form:input path="usuario" id="usuario" type="text" class="form-control inputStyle" />
					
					<label for="password">Password</label>
					<form:input path="password" type="password" id="password" class="form-control inputStyle"/>     		  
					
					<button class="btn btn-lg btn-primary btn-block"  name="Submit" value="Login" type="Submit">Login</button>  			
				</form:form>
<%-- 				<c:if test="${not empty error}"> --%>
<%-- 			        <h4><span>${error}</span></h4> --%>
<!-- 			        <br> -->
<%-- 		        </c:if> --%>
			</div>
		</div>
		
		<!-- Placed at the end of the document so the pages load faster -->
		<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js" ></script>
		<script>window.jQuery || document.write('<script src="../../assets/js/vendor/jquery.min.js"><\/script>')</script>
		<script src="js/bootstrap.min.js" type="text/javascript"></script>
	</body>
</html>
