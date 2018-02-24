package helgalis.selfreview.main;

import java.util.List;
import java.util.Set;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import helgalis.selfreview.dao.FilmDao;
import helgalis.selfreview.model.Director;
import helgalis.selfreview.model.Film;

public class SampleMain {

	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext(
				"app-context.xml");
		FilmDao fDao = context.getBean("hibernateFilmDaoImpl", FilmDao.class);
		@SuppressWarnings("unchecked")
		List<Director> dirs =  fDao.getAllDirector();
		Film filmIn = new Film();
		Set<Director> d = filmIn.getDirectors();
		for (Director director : dirs) {
			director.getFilms().add(filmIn);
			d.add(director);
		}
		filmIn.setTitle("First man on world2");
		
		fDao.updateFilm(filmIn);
		//List<Film> f = fDao.getAllFilms();
		//for (Film film : f) {
		//	System.out.println(film);
		//}

	}

}
