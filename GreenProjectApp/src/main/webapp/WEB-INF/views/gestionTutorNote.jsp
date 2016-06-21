<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Gestion Tuteur | Noter</title>
</head>

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
      width: 100%; 
      margin: auto;
      min-height:750px;
  }
  .cache{display: none;}

  /* Hide the carousel text when the screen is less than 600 pixels wide */
  @media (max-width: 600px) {
    .carousel-caption {
      display: none; 
    }
  }
  </style>
</head>
<body>

<%@ include file="headerRespo.jsp" %>

<div class="container text-center"> 
<div class="container text-center">    
  <div class="col-xs-20 col-md-12">
			<ul class="nav nav-justified">						
				<li><h4 class="lead"><a href="selectToNote">GESTION DE NOTES</a></h4></li>
				<li><h1><strong class="glyphicon glyphicon-education"></strong></h1></li>
				<li><h4 class="lead"><a href="listeEquipe">EQUIPES</a></h4></li>
			</ul>
		</div>	
</div><br>

<h2>Gestion des notes</h2>
  <form:form class="form-horizontal" role="form" modelAttribute="noteForm" method="POST" action="saveNote">
    
    <div  class="form-group cache">
      <label class="control-label col-sm-2" >Id:</label>
      <div class="col-sm-10">
        <form:input class="form-control" path="idNote" ></form:input>
      </div>
    </div>
    <div class="form-group">
      <label class="control-label col-sm-2" >Valeur de la note:</label>
      <div class="col-sm-10">          
        <form:input type="number" min="0" max="5" class="form-control" path="valeurNote" ></form:input>
      </div>
    </div>
    <div class="form-group">
      <label class="control-label col-sm-2" >Commentaire de la note:</label>
      <div class="col-sm-10">          
        <form:input class="form-control" path="commentaire" ></form:input>
      </div>
    </div>
    <div class="form-group">
      <label class="control-label col-sm-2" >Competence:</label>
      <div class="col-sm-10">          
        <form:select class="form-control" path="comptence.idCompetence" items="${listComps}" itemValue="idCompetence" itemLabel="nomCompetence"></form:select>
      </div>
    </div>
    <div class="form-group">
      <label class="control-label col-sm-2" >Equipe:</label>
      <div class="col-sm-10">          
        <form:input class="form-control" path="equipe.idEquipe" value ="${idEquipe }"></form:input>
      </div>
    </div>
    <div class="form-group">
      <label class="control-label col-sm-2" >Utilisateur:</label>
      <div class="col-sm-10">          
        <form:input class="form-control" path="utilisateur.idUtilisateur" value="${id }"></form:input>
      </div>
    </div>
    

    <div class="form-group">        
      <div class="col-sm-offset-2 col-sm-10">
        <button type="submit" class="btn btn-default">Sauvegarder</button>
      </div>
    </div>
  </form:form>
</div><br>
  

<%@ include file="footer.jsp" %>


</body>
</html>