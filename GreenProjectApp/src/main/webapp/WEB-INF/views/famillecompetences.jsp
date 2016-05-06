<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="f" %>
<div>
	${exception}
</div>
<div id="formFamiComp">
	<f:form modelAttribute="famillecompetence" action="saveFamiComp" method="post" enctype="multipart/form-data">
		<table>
			<tr>
				<td>ID FamiComp</td>
				<td><f:input path="idFamille"/></td>
				<td><f:errors path="idFamille" cssClass="errors"></f:errors></td>			
			</tr>
			<tr>
				<td>Nom FamiComp</td>
				<td><f:input path="nomFamille"/></td>
				<td><f:errors path="nomFamille" cssClass="errors"></f:errors></td>							
			</tr>
			<tr>
				<td>ID SessionApp</td>
				<td><f:select path="sessionApp.idApp" items="${sessionapps}" itemValue="idApp" itemsLabel="nomSessionApp"></f:select></td>
				<td><f:errors path="nomFamille" cssClass="errors"></f:errors></td>	
						
			</tr>
			<tr>
				<td><input type="submit" value="Save"></td>
			</tr>
		</table>	
	</f:form>
</div>
<div id="">
	<table>
		<tr>
			<th>ID</th><th>NOM FAMILLE</th>
		</tr>
		<c:forEach items="${famillecompetences}" var="fc">
			<tr>
				<td>${fc.idFamille }</td>
				<td>${fc.nomFamille }</td>
				<td>${fc.sessionApp.nomSessionApp }</td>
				<td><a href="suppFam?idFamille=${fc.idFamille }">Supp</a></td>
				<td><a href="editFam?idFamille=${fc.idFamille }">Edit</a></td>
			
			</tr>
		
		</c:forEach>
	</table>

</div>
