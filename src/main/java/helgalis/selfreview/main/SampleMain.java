package helgalis.selfreview.main;

import java.util.List;
import java.util.Set;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import helgalis.selfreview.dao.FilmDao;
import helgalis.selfreview.model.Director;
import helgalis.selfreview.model.Film;
import helgalis.selfreview.model.Review;

public class SampleMain {

	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext(
				"app-context.xml");
		FilmDao fDao = context.getBean("hibernateFilmDaoImpl", FilmDao.class);
		Film filmIn = new Film();
		filmIn.setTitle("First man on world4");
		

		Review rev1 = new Review();
		rev1.setLink("www.ya.ru");
		rev1.setText("something");
		Review rev2 = new Review();
		rev1.setFilm(filmIn);
		rev1.setLink("www.gr.ru");
		rev1.setText("someth");
		filmIn.addReview(rev1);
		filmIn.addReview(rev2);

		fDao.updateFilm(filmIn);
		//List<Film> f = fDao.getAllFilms();
		//for (Film film : f) {
		//	System.out.println(film);
		//}
		printFilmWithDetails(fDao.getAllFilms());

	}
	private static void printFilmWithDetails(List<Film> films) {
		for (Film film : films) {
			System.out.println(film);
			if(film.getReviews()!=null) {
				for(Review review: film.getReviews()) {
					System.out.println(review);
				}
			}
		}
	}

}
