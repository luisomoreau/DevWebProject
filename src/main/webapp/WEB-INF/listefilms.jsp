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
				<h3>Les films</h3>
				<table class="table table-hover">
					<thead>
						<tr>
							<th>#</th>
							<th>Titre</th>
							<th>Genre</th>
							<th>Date de sortie</th>
							<th>Réalisateur</th>
							<th></th>
						</tr>
					</thead>
					<tbody>
					<c:forEach var="film" items="${listeFilms}">
						<tr>
							<td>${film.id}</td>
							<td>${film.titre}</td>
							<td>${film.genre.nom}</td>
							<td><fmt:formatDate value="${film.dateDeSortie}" pattern="d MMMM yyyy"/></td>
							<td>${film.realisateur}</td>
							<td><a href="film?id=${film.id}" title="Détails ${film.titre}"><span class="glyphicon glyphicon-search"></span></a></td>
						</tr>
					</c:forEach>
					</tbody>
				</table>
			</div>
			<div class="col-md-4">
				<%@include file="filmAleatoire.jsp" %>
			</div>
    	</div>
	</div>
  </body>
</html>