<%@ page pageEncoding="utf-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
				<h4>Un film au hasard :</h4>
				<div class="well">
					<h4>${filmAleatoire.titre} <small>(${filmAleatoire.realisateur})</small></h4>
					<p>Sorti le <fmt:formatDate value="${filmAleatoire.dateDeSortie}" pattern="d MMMM yyyy"/></p>
					<p>
						<span class="glyphicon glyphicon-search"></span>
						<a href="film?id=${filmAleatoire.id}" title="Détails ${filmAleatoire.titre}">Voir la fiche détaillée</a>
					</p>
				</div>