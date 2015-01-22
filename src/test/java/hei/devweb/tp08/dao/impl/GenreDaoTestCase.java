package hei.devweb.tp08.dao.impl;

import hei.devweb.tp08.dao.GenreDao;
import hei.devweb.tp08.entities.Genre;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class GenreDaoTestCase {

	private GenreDao genreDao = new GenreDaoMysqlImpl();

	@Before
	public void initDb() throws Exception {
		Connection connection = DataSourceProvider.getDataSource().getConnection();
		Statement stmt = connection.createStatement();
		stmt.executeUpdate("DELETE FROM film");
		stmt.executeUpdate("DELETE FROM genre");
		stmt.executeUpdate("INSERT INTO `genre`(`idgenre`,`nom`) VALUES (1,'Drame')");
		stmt.executeUpdate("INSERT INTO `genre`(`idgenre`,`nom`) VALUES (2,'Comédie')");
		stmt.executeUpdate("INSERT INTO `genre`(`idgenre`,`nom`) VALUES (3,'Action')");
		stmt.close();
		connection.close();
	}

	@Test
	public void testListerGenre() {
		List<Genre> genres = genreDao.listerGenres();
		Assert.assertEquals(3, genres.size());
		Assert.assertEquals(3, genres.get(0).getId().intValue());
		Assert.assertEquals("Action", genres.get(0).getNom());
		Assert.assertEquals(2, genres.get(1).getId().intValue());
		Assert.assertEquals(1, genres.get(2).getId().intValue());
	}

	@Test
	public void testGetGenre() {
		Genre genre = genreDao.getGenre(1);
		Assert.assertNotNull(genre);
		Assert.assertEquals(1, genre.getId().intValue());
		Assert.assertEquals("Drame", genre.getNom());
	}

	@Test
	public void testAjouterGenre() throws Exception {
		Genre genre = genreDao.ajouterGenre("test");
		Assert.assertNotNull(genre.getId());
		Assert.assertEquals("test", genre.getNom());

		Connection connection = DataSourceProvider.getDataSource().getConnection();
		PreparedStatement stmt = connection.prepareStatement("SELECT * FROM genre WHERE idgenre = ?");
		stmt.setInt(1, genre.getId());
		ResultSet rs = stmt.executeQuery();
		Assert.assertTrue(rs.next());
		Assert.assertEquals(genre.getId().intValue(), rs.getInt("idgenre"));
		Assert.assertEquals("test", rs.getString("nom"));
		Assert.assertFalse(rs.next());
		connection.close();
	}

}
