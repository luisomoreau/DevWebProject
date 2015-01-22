package hei.devweb.tp08.servlets;

import hei.devweb.tp08.entities.Film;
import hei.devweb.tp08.entities.Genre;
import hei.devweb.tp08.managers.Cinematheque;

import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/ajouterfilm")
public class AjouterFilmServlet extends GenericServlet {

	private static final long serialVersionUID = 8558122731317034877L;

	private static DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		super.doGet(request, response);

		List<Genre> listeGenres = Cinematheque.getInstance().listerGenres();
		request.setAttribute("genres", listeGenres);

		String messageErreur = (String) request.getSession().getAttribute("messageErreur");
		if (messageErreur != null && !"".equals(messageErreur)) {
			request.setAttribute("messageErreur", messageErreur);
			request.getSession().removeAttribute("messageErreur");
		}

		RequestDispatcher view = request.getRequestDispatcher("/WEB-INF/ajouter.jsp");
		view.forward(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");

		String titre = request.getParameter("titre");
		String realisateur = request.getParameter("realisateur");
		String resume = request.getParameter("resume");
		Integer duree = null;
		Integer idGenre = null;
		try {
			duree = Integer.parseInt(request.getParameter("duree"));
			idGenre = Integer.parseInt(request.getParameter("genre"));
		} catch (NumberFormatException e) {

		}
		Date dateDeSortie = null;
		try {
			dateDeSortie = dateFormat.parse(request.getParameter("dateSortie"));
		} catch (ParseException e) {
		}

		if (this.isNullOrEmpty(titre) || this.isNullOrEmpty(realisateur) || duree == null || idGenre == null || dateDeSortie == null) {
			request.getSession().setAttribute("messageErreur", "Un des champs du formulaire n'a pas été bien renseigné");
			response.sendRedirect("ajouterfilm");
		} else {
			Genre genre = Cinematheque.getInstance().getGenre(idGenre);
			Film nouveauFilm = new Film(null, titre, dateDeSortie, genre, duree, realisateur, resume);
			Film filmAjoute = Cinematheque.getInstance().ajouterFilm(nouveauFilm);

			response.sendRedirect("film?id=" + filmAjoute.getId());
		}
	}

	private boolean isNullOrEmpty(String chaine) {
		return chaine == null || "".equals(chaine);
	}

}
