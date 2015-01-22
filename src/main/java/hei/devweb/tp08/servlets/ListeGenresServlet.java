package hei.devweb.tp08.servlets;

import hei.devweb.tp08.entities.Genre;
import hei.devweb.tp08.managers.Cinematheque;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/listegenres")
public class ListeGenresServlet extends GenericServlet {

	private static final long serialVersionUID = 8762892363953511538L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		super.doGet(request, response);

		List<Genre> genres = Cinematheque.getInstance().listerGenres();
		request.setAttribute("listeGenres", genres);

		RequestDispatcher view = request.getRequestDispatcher("/WEB-INF/listegenres.jsp");
		view.forward(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String nom = request.getParameter("nom");
		if (nom != null && !"".equals(nom)) {
			Cinematheque.getInstance().ajouterGenre(nom);
		}
		response.sendRedirect("listegenres");
	}

}
