<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="f"%>
<html>
<head>
<link rel="stylesheet"
	href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.0/jquery.min.js"></script>
<script
	src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>
<script src="scripts/javascript-traitement.js"></script>
<title>Fiche détaillée des notes</title>
</head>

<body>
	<%@ include file="headerStudent.jsp"%>

	<div class="container text-center">
		<div class="col-xs-20 col-md-12">
			<ul class="nav nav-justified">
				<li><h4 class="lead">
						<a href="selectToNote">GESTION DE NOTES</a>
					</h4></li>
				<li><h1>
						<strong class="glyphicon glyphicon-education"></strong>
					</h1></li>
				<li><h4 class="lead">
						<a href="listeEquipe">EQUIPES</a>
					</h4></li>
			</ul>
		</div>
	</div>
	<br>

	<h2 class="centrer">CHOISIR L'EQUIPE A NOTER</h2>

	<div class="align-select centrer" style="margin: 50px auto;">
		<select id="mySelect">


			<option value=''>------ Choix du groupe -----</option>

			<c:forEach items="${listEquipes}" var="equipe">
				<option value=${equipe }>${equipe }</option>
			</c:forEach>

		</select>
	</div>

	<c:forEach items="${listElevesParGroupe}" var="eleveL">
		<div id="${eleveL[0].equipe.nomEquipe }" class="div-equipe">
			<table class="table" border>
				<tr>
					<th colspan=3 style="text-align: center">${eleveL[0].equipe.nomEquipe }</th>
				</tr>
				<tr>
					<th>Nom</th>
					<th>Prenom</th>
					<th></th>
				</tr>
				<c:forEach items="${eleveL}" var="eleve">


					<tr>
						<td>${eleve.utilisateur.nomUtilisateur }</td>
						<td>${eleve.utilisateur.prenomUtilisateur }</td>
						<td><a
							href="noter?idUtilisateur=${eleve.utilisateur.idUtilisateur }&idEquipe=${eleveL[0].equipe.idEquipe  }">Noter</a>
							| <a
							href="grilleNotes?idUtilisateur=${eleve.utilisateur.idUtilisateur }">Consulter
								Notes</a></td>
					</tr>



				</c:forEach>

			</table>
		</div>

	</c:forEach>



	<%@ include file="footer.jsp"%>
</body>
</html>

<style>
.container {
	margin: 10px auto;
}

.clearfix {
	clear: both;
}

.align-select {
	margin: auto;
	margin-bottom: 50px;
}

.centrer {
	text-align: center;
}

.div-equipe {
	display: none;
}

@media only screen and (max-width: 950px) {
}

@media only screen and (min-width: 950px) {
	.competences {
		width: 70%;
		margin-right: 5%;
		margin-left: 5%;
		margin-top: 50px;
	}
}
</style>


<script type="text/javascript">
	var value = '';
	$('#mySelect').on('change', function() {
		$('#' + value).css("display", "none");
		value = $(this).val();
		$('#' + value).css("display", "block");
	});
</script>