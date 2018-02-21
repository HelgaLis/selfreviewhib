package helgalis.selfreview.main;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import helgalis.selfreview.dao.FilmDao;
import helgalis.selfreview.model.Film;

public class SampleMain {

	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext(
				"app-context.xml");
		FilmDao fDao = context.getBean("hibernateFilmDaoImpl", FilmDao.class);
		List<Film> f = fDao.getAllFilms();
		for (Film film : f) {
			System.out.println(f);
		}

	}

}
