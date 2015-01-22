<%@ page pageEncoding="utf-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
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
	    <c:param name="pageSelectionnee" value="film"/>
	</c:import> 
	
	<div class="container">
		<div class="row">
			<div class="col-md-8">
				<h3>Détail du film</h3>

				<div class="row">
					<label class="col-sm-2 control-label">Titre</label>
					<div class="col-sm-10">
						<p>${film.titre}</p>
					</div>
				</div>
				<div class="row">
					<label class="col-sm-2 control-label">Date de sortie</label>
					<div class="col-sm-3">
						<p><fmt:formatDate value="${film.dateDeSortie}" pattern="d MMMM yyyy"/></p>
					</div>
				</div>
				<div class="row">
					<label class="col-sm-2 control-label">Genre</label>
					<div class="col-sm-10">
						<p>${film.genre.nom}</p>
					</div>
				</div>
				<div class="row">
					<label class="col-sm-2 control-label">Durée</label>
					<div class="col-sm-3">
						<div class="input-group">
						  <p>${film.duree} min</p>
						</div>
					</div>
				</div>
				<div class="row">
					<label class="col-sm-2 control-label">Réalisateur</label>
					<div class="col-sm-10">
						<p>${film.realisateur}</p>
					</div>
				</div>
				<div class="row">
					<label class="col-sm-2 control-label">Résumé</label>
					<div class="col-sm-10">
						<p>${film.resume}</p>
					</div>
				</div>
				<div class="row">
					<div class="col-sm-offset-2 col-sm-10">
						<a class="btn btn-default" href="listefilms">Retour à la liste</a>
					</div>
				</div>
			</div>
			<div class="col-md-4">
				<%@include file="filmAleatoire.jsp" %>
			</div>
		</div>
	</div>
  </body>
</html>