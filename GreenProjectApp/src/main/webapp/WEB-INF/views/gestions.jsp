<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="f" %>
<div id=formSessionApp>
	<f:form modelAttribute="sessionApp" action="saveSessionApp" method="post" enctype="multipart/form-data">
		<table>
			<tr>
				<td>ID SessionApp</td>
				<td><f:input path="idApp"/></td>
				<td><f:errors path="idApp" cssClass="errors"></f:errors></td>			
			</tr>
			<tr>
				<td>Nom SessionApp</td>
				<td><f:input path="nomSessionApp"/></td>
				<td><f:errors path="nomSessionApp" cssClass="errors"></f:errors></td>			
			</tr>
			<tr>
				<td>Description SessionApp</td>
				<td><f:input path="descriptionApp"/></td>
				<td><f:errors path="descriptionApp" cssClass="errors"></f:errors></td>			
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
			<th>ID</th><th>NOM SESSIONAPP</th><th>DESCRIPTION</th>
		</tr>
		<c:forEach items="${sessionApps}" var="sas">
			<tr>
				<td>${sas.idApp }</td>
				<td>${sas.nomSessionApp }</td>
				<td>${sas.descriptionApp }</td>
			</tr>
		
		</c:forEach>
	</table>

</div>
