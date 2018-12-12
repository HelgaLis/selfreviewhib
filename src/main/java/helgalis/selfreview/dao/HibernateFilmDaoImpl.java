package helgalis.selfreview.dao;

import java.util.List;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import helgalis.selfreview.model.Director;
import helgalis.selfreview.model.Film;
import helgalis.selfreview.model.Review;
@Repository
public class HibernateFilmDaoImpl implements FilmDao {
	@Autowired
	@Qualifier("sessionFactory")
	private SessionFactory sessionFactory;
	@Transactional(readOnly=false)
	@Override
	public int insertFilm(Film film) {
		Session session = sessionFactory.openSession();
		session.saveOrUpdate(film);
		return 0;
	}
	@Transactional(readOnly=false)
	@Override
	public boolean updateFilm(Film film) {
		Session session = sessionFactory.openSession();
		Set<Director> dir = film.getDirectors();
		
		session.saveOrUpdate(film);

		
		return false;
	}

	@Override
	public List<Film> getFilmById(int id) {
		Session session = sessionFactory.openSession();
		return null;
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<Film> getAllFilms() {
		Session session = sessionFactory.openSession();
		//String hql = "FROM films";
		Criteria query = session.createCriteria(Film.class);;
		List<Film> films = query.list();
		return films;
	}
	@SuppressWarnings("unchecked")
	public List<Director> getAllDirector(){
		Session session = sessionFactory.openSession();
		Criteria query = session.createCriteria(Director.class);
		List<Director> dir = query.list();
		session.clear();
		return dir;
	}
	public void inserReview(Review review) {
		Session session = sessionFactory.openSession();
		session.saveOrUpdate(review);
	}
}
