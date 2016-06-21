<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="f"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Gapp</title>
<style>
/* Remove the navbar's default margin-bottom and rounded borders */
.navbar {
	margin-bottom: 0;
	border-radius: 0;
}

/* Add a gray background color and some padding to the footer */
footer {
	background-color: #f2f2f2;
	padding: 20px;
}

.carousel-inner img {
	width: 100%; /* Set width to 100% */
	margin: auto;
	min-height: 750px;
}

/* Hide the carousel text when the screen is less than 600 pixels wide */
@media ( max-width : 600px) {
	.carousel-caption {
		display: none;
	}
}

h1 {
	position: absolute;
	top: 20%;
}
</style>
</head>
<body>

	<%@ include file="headerStudent.jsp"%>

	<div class="container text-center">
		<div class="col-xs-20 col-md-12">
			<ul class="nav nav-justified">
				<li><h4 class="lead">
						<a href="indexUtilisateur">UTILISATEURS</a>
					</h4></li>
				<li><h4 class="lead">
						<a href="indexSession">SESSIONS</a>
					</h4></li>
				<li><h4 class="lead">
						<a href="indexComp">COMPETENCES</a>
					</h4></li>
				<li><h1>
						<strong class="glyphicon glyphicon-education"></strong>
					</h1></li>
				<li><h4 class="lead">
						<a href="indexAssign">ASSIGNATIONS</a>
					</h4></li>
				<li><h4 class="lead">
						<a href="indexFamComp">FAMILLES</a>
					</h4></li>
				<li><h4 class="lead">
						<a href="indexEquipe">EQUIPES</a>
					</h4></li>
			</ul>
		</div>
	</div>
	<br>

	<div id="myCarousel" class="carousel slide" data-ride="carousel">
		<!-- Indicators -->
		<ol class="carousel-indicators">
			<li data-target="#myCarousel" data-slide-to="0" class="active"></li>
			<li data-target="#myCarousel" data-slide-to="1"></li>
		</ol>

		<!-- Wrapper for slides -->
		<div class="carousel-inner" role="listbox">
			<div class="item active">
				<img src="<%=request.getContextPath()%>/resources/img/h2.jpg"
					alt="Image">
				<div class="carousel-caption"></div>
			</div>

		</div>
		<div class="container text-center">

			<h1 style="color: white;">Beinvenue sur L'Administration de
				l'Apprentissage Par Projet</h1>
		</div>

	</div>

	<%@ include file="footer.jsp"%>

</body>
</html>