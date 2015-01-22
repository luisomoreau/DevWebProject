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
	    <c:param name="pageSelectionnee" value="genre"/>
	</c:import>  
	
	<div class="container">
		<div class="row">
			<div class="col-md-8">
				<h3>Les Genres</h3>
				<form method="post">
					<table class="table table-hover">
						<thead>
							<tr>
								<th>#</th>
								<th>Nom</th>
							</tr>
						</thead>
						<tbody>
						<c:forEach var="genre" items="${listeGenres}">
							<tr>
								<td>${genre.id}</td>
								<td>${genre.nom}</td>
							</tr>
						</c:forEach>
							<tr>
								<td></td>
								<td>
									<div class=" col-md-6">
										<input class="form-control" type="text" name="nom" placeholder="Nouveau genre" />
									</div>
									<input class="btn btn-primary" type="submit" value="Enregistrer" />
								</td>
							</tr>
						</tbody>
					</table>
				</form>
			</div>
			<div class="col-md-4">
				<%@include file="filmAleatoire.jsp" %>
			</div>
    	</div>
	</div>
  </body>
</html>