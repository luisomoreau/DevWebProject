<%@ page pageEncoding="utf-8" %>
	<nav class="navbar navbar-inverse navbar-static-top">
		<div class="navbar-header">
			<a class="navbar-brand" href="accueil">JavaEECiné</a>
		</div>
		<div class="collapse navbar-collapse" id="bs-example-navbar-collapse-9">
			<ul class="nav navbar-nav">
				<li class="${param.pageSelectionnee == 'accueil' ? 'active' : ''}"><a href="accueil">Accueil</a></li>
				<li class="${param.pageSelectionnee == 'film' ? 'active' : ''}"><a href="listefilms">Liste des films</a></li>
				<li class="${param.pageSelectionnee == 'ajouter' ? 'active' : ''}"><a href="ajouterfilm">Ajouter un film</a></li>
				<li class="${param.pageSelectionnee == 'genre' ? 'active' : ''}"><a href="listegenres">Liste des genres</a></li>
			</ul>
		</div> 
	</nav>