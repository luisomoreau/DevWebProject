package hei.devweb.tp08.servlets;

import hei.devweb.tp08.entities.Film;
import hei.devweb.tp08.managers.Cinematheque;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/listefilms")
public class ListeFilmsServlet extends GenericServlet {

	private static final long serialVersionUID = 8762892363953511538L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		super.doGet(request, response);

		List<Film> films = Cinematheque.getInstance().listerFilms();
		request.setAttribute("listeFilms", films);

		RequestDispatcher view = request.getRequestDispatcher("/WEB-INF/listefilms.jsp");
		view.forward(request, response);
	}

}
