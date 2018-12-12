package helgalis.selfreview.dao;

import java.util.List;

import helgalis.selfreview.model.Director;
import helgalis.selfreview.model.Film;
import helgalis.selfreview.model.Review;



public interface FilmDao {
public int insertFilm(Film film);
public boolean updateFilm(Film film);
public List<Film> getFilmById(int id);
public List<Film> getAllFilms();
public List<Director> getAllDirector();
public void inserReview(Review review);
}
