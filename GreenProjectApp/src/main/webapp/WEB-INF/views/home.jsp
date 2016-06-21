<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Authentification</title>
<link rel="stylesheet" type="text/css"
	href="<%=request.getContextPath()%>/resources/bootstrap/bootstrap-3.3.6-dist/css/bootstrap.min.css">
<link rel="stylesheet" type="text/css"
	href="<%=request.getContextPath()%>/resources/bootstrap/bootstrap-3.3.6-dist/css/bootstrap-theme.min.css">
<script type="text/javascript"
	src="<%=request.getContextPath()%>/resources/js/jquery-1.12.3.min.js">
	
</script>
<script type="text/javascript"
	src="<%=request.getContextPath()%>/resources/bootstrap/bootstrap-3.3.6-dist/js/bootstrap.min.js"></script>
<style>
a:link {
	text-decoration: none;
}

.a {
	display: block;
	margin: 30px;
	width: 344px;
	height: 60px;
	font-size: 2em;
	border-radius: 15px
}

.center-div {
	position: absolute;
	top: 45%;
	left: 40%
}

.jumbotron {
	background-color: #228B22;
	color: #fff;
}
</style>
</head>
<body>
	<div class="jumbotron text-center">
		<h1>GAPP</h1>
		<p>La plateforme qui rend l'apprentissage par projet interactif</p>
	</div>
	<div class="center-div">

		<a href="respoApp/index"><div class="a btn btn-success">RESPONSABLE</div></a>
		<a href="tutorApp/index"><div class="a btn btn-success">TUTEUR</div></a>
		<a href="studentApp/index"><div class="a btn btn-success">ETUDIANT</div></a>

	</div>

</body>
</html>