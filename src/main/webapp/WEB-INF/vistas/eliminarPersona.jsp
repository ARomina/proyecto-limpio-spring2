<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
	<head>
	<!-- Bootstrap core CSS -->
	    <link href="css/bootstrap.min.css" rel="stylesheet" >
	    <!-- Bootstrap theme -->
	    <link href="css/bootstrap-theme.min.css" rel="stylesheet">
	    <title>Home</title>
	    
	    <style>
	    	.inputStyle{
	    		margin-bottom: 20px;
	    	}
	    </style>
	</head>
	<body>
		
		<c:if test="${not empty usuarioLogueado}">
		   <div class="navbar-wrapper">
			    <div class="container-fluid">
			        <nav class="navbar navbar-default navbar-fixed-top">
			            <div class="container">
			                <div class="navbar-header">
			                    <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar" aria-expanded="false" aria-controls="navbar">
			                    <span class="sr-only">Toggle navigation</span>
			                    <span class="icon-bar"></span>
			                    <span class="icon-bar"></span>
			                    <span class="icon-bar"></span>
			                    </button>
			                </div>
			                <div id="navbar" class="navbar-collapse collapse">
			                    <ul class="nav navbar-nav pull-right">
			                        <li class=" dropdown"><a href="#" class="dropdown-toggle active" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">${usuarioLogueado.usuario}  <span class="caret"></span></a>
			                            <ul class="dropdown-menu">
			                                <li><a href="#">Editar mis datos</a></li>
			                                <li><a href="verDatosUsuarioSesion?id=${usuarioLogueado.id}">Ver mis datos</a></li>
			                            </ul>
			                        </li>
			                        <li class=""><a href="salir">Salir</a></li>
			                    </ul>
			                </div>
			            </div>
			        </nav>
			    </div>
			</div>
			<div id="loginbox" style="margin-top:50px;" class="mainbox col-md-6 col-md-offset-3 col-sm-8 col-sm-offset-2">
				<h2 style="margin-bottom: 20px;">¿Estás seguro que deseas eliminar tu usuario?</h2>
				<a href="procesaEliminar" class="btn btn-warning">Sí, eliminar mi cuenta</a>
				<a href="homePersona" class="btn btn-default">Cancelar</a>
			</div>
		</c:if>
		
		<c:if test="${empty usuarioLogueado}">
			<div class = "container">
				<div id="loginbox" style="margin-top:50px;" class="mainbox col-md-6 col-md-offset-3 col-sm-8 col-sm-offset-2">
					<h2>Necesitas estar logueado para acceder a este contenido</h2>
					<a href="loginPersona" class="btn btn-default" style="margin-top: 20px;">Login</a>
					<a href="registro" class="btn btn-default" style="margin-top: 20px;">Registro</a>
				</div>
			</div>
		</c:if>
		
		<!-- Placed at the end of the document so the pages load faster -->
		<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js" ></script>
		<script>window.jQuery || document.write('<script src="../../assets/js/vendor/jquery.min.js"><\/script>')</script>
		<script src="js/bootstrap.min.js" type="text/javascript"></script>
	</body>
</html>