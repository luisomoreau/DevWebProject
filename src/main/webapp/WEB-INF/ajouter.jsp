<%@ page pageEncoding="utf-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
  <head>
    <title>JavaEECiné</title>
	<meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <!-- Bootstrap -->
    <link href="css/bootstrap.min.css" rel="stylesheet">
  </head>
  <body>
	<!-- Menu de navigation -->
    <c:import url="menu.jsp">
	    <c:param name="pageSelectionnee" value="ajouter"/>
	</c:import>  
	
	<div class="container">
		<div class="row">
			<div class="col-md-8">
				<h3>Ajouter un film</h3>
				<c:if test="${messageErreur != null}">
					<div class="alert alert-danger">${messageErreur}</div>
				</c:if>
				<form method="post" class="form-horizontal">
					<div class="form-group">
						<label for="titre" class="col-sm-2 control-label">Titre</label>
						<div class="col-sm-10">
							<input type="text" class="form-control" name="titre" id="titre">
						</div>
					</div>
					<div class="form-group">
						<label for="dateSortie" class="col-sm-2 control-label">Date de sortie</label>
						<div class="col-sm-3">
							<input type="date" class="form-control" name="dateSortie" id="dateSortie">
						</div>
					</div>
					<div class="form-group">
						<label for="genre" class="col-sm-2 control-label">Genre</label>
						<div class="col-sm-10">
							<select class="form-control" name="genre" id="genre">
								<c:forEach var="genre" items="${genres}">
									<option value="${genre.id}">${genre.nom}</option>
								</c:forEach>
							</select>
						</div>
					</div>
					<div class="form-group">
						<label for="duree" class="col-sm-2 control-label">Durée</label>
						<div class="col-sm-3">
							<div class="input-group">
							  <input type="number" class="form-control" name="duree" id="duree">
							  <span class="input-group-addon">min</span>
							</div>
						</div>
					</div>
					<div class="form-group">
						<label for="realisateur" class="col-sm-2 control-label">Réalisateur</label>
						<div class="col-sm-10">
							<input type="text" class="form-control" name="realisateur" id="realisateur">
						</div>
					</div>
					<div class="form-group">
						<label for="resume" class="col-sm-2 control-label">Résumé</label>
						<div class="col-sm-10">
							<textarea class="form-control" rows="5" name="resume" id="resume"></textarea>
						</div>
					</div>
					<div class="form-group">
						<div class="col-sm-offset-2 col-sm-10">
							<input class="btn btn-primary" type="submit" value="Enregistrer">
						</div>
					</div>
				</form>
			</div>
			<div class="col-md-4">
				<%@include file="filmAleatoire.jsp" %>
			</div>
		</div>
	</div>
  </body>
</html>