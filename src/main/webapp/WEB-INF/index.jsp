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
	    <c:param name="pageSelectionnee" value="accueil"/>
	</c:import>    

	<div class="container">
		<div class="row">
			<div class="col-md-8">
				<p>Bonjour et bienvenue sur ce magnifique site.</p>
				<p>Vous allez pouvoir accéder à une liste de film et en ajouter de nouveaux.</p>
			</div>
			<div class="col-md-4">
				<%@include file="filmAleatoire.jsp" %>
			</div>
    	</div>
	</div>
  </body>
</html>