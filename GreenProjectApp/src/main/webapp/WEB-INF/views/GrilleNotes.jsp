<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="f"%>

<link rel="stylesheet"
	href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.0/jquery.min.js"></script>
<script
	src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>
<script src="scripts/javascript-traitement.js"></script>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Grille notes</title>
</head>

<body>
	<%@ include file="headerStudent.jsp"%>
	<h2 style="text-align: center; margin-bottom: 30px;">Fiche de note
		de ${utilisateur.nomUtilisateur}</h2>
	<c:forEach items="${listCompetenceParFam}" var="famComp">
		<div class="competence">
			<h4 style="color: #337ab7; font-size: 2em"
				id="${famComp[0].comptence.familleCompetence.nomFamille.replaceAll(' ' , '') }">${famComp[0].comptence.familleCompetence.nomFamille}</h4>

			<table class="table" style="display: none;">
				<tr>
					<th>COMPETENCE</th>
					<th>DESCRIPTION</th>
					<th>NOTE</th>
					<th>COMMENTAIRE</th>
				</tr>
				<c:forEach items="${famComp}" var="competence">
					<tr
						class="${competence.comptence.familleCompetence.nomFamille.replaceAll(' ' , '') }">
						<td style="width: 30%;">${competence.comptence.nomCompetence }</td>
						<td style="width: 40%;">${competence.comptence.descriptionCompetence }</td>
						<td style="width: 10%;">${competence.valeurNote }</td>
						<td style="width: 30%;">${competence.commentaire }</td>
					</tr>
				</c:forEach>
			</table>
		</div>
	</c:forEach>


</body>

<%@ include file="footer.jsp"%>
</html>

<script>
	$(document).ready(function() {
		$("h4").click(function() {
			$(this).next("table").toggle();
		});
	});
</script>
<style>
.container {
	margin: 10px 10px;
}

.competence {
	margin-bottom: 30px;
}
</style>
