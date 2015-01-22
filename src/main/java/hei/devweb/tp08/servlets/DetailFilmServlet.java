package hei.devweb.tp08.servlets;

import hei.devweb.tp08.entities.Film;
import hei.devweb.tp08.managers.Cinematheque;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/film")
public class DetailFilmServlet extends GenericServlet {

	private static final long serialVersionUID = 4667046972882137986L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		super.doGet(request, response);

		try {
			Integer id = Integer.parseInt(request.getParameter("id"));
			Film film = Cinematheque.getInstance().getFilm(id);
			request.setAttribute("film", film);

			RequestDispatcher view = request.getRequestDispatcher("/WEB-INF/film.jsp");
			view.forward(request, response);
		} catch (NumberFormatException e) {
			response.sendRedirect("listefilms");
		}
	}

}
