package hei.devweb.tp08.servlets;

import hei.devweb.tp08.entities.Film;
import hei.devweb.tp08.managers.Cinematheque;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public abstract class GenericServlet extends HttpServlet {

	private static final long serialVersionUID = -3237151023361632888L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Film filmAleatoire = Cinematheque.getInstance().getFilmAleatoire();
		req.setAttribute("filmAleatoire", filmAleatoire);
	}

}
