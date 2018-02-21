package helgalis.selfreview.dao;

import java.util.List;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import helgalis.selfreview.model.Film;

@Repository
public class HibernateFilmDaoImpl implements FilmDao {
	@Autowired
	@Qualifier("sessionFactory")
	private SessionFactory sessionFactory;
	@Transactional(readOnly=false)
	@Override
	public int insertFilm(Film film) {
		Session session = sessionFactory.openSession();
		session.save(film);
		return 0;
	}
	@Transactional(readOnly=false)
	@Override
	public boolean updateFilm(Film film) {
		Session session = sessionFactory.openSession();
		session.save(film);
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
		String hql = "FROM films";
		Query query = session.createQuery(hql);
		List<Film> films = query.list();
		return films;
	}

}
