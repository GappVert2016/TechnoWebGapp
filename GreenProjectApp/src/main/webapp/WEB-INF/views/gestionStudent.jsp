<%@ taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>

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

	<h2 style="text-align: center; margin-bottom: 30px;">Fiche de Note
		de ${nom}</h2>

	<div class="container">

		<c:forEach items="${listCompetenceParFam}" var="famComp">
			<div class="">
				<h4 style="color: #337ab7; font-size: 2em;"
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
							<td style="">${competence.comptence.nomCompetence }</td>
							<td style="">${competence.comptence.descriptionCompetence }</td>
							<td style="">${competence.valeurNote }</td>
							<td style="">${competence.commentaire }</td>
						</tr>
					</c:forEach>
				</table>
			</div>
		</c:forEach>
	</div>
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
	margin: 0 10px;
}

.competence {
	margin-bottom: 30px;
}
</style>
