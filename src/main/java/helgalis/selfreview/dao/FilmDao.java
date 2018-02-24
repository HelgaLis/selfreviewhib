package helgalis.selfreview.dao;

import java.util.List;

import helgalis.selfreview.model.Director;
import helgalis.selfreview.model.Film;



public interface FilmDao {
public int insertFilm(Film film);
public boolean updateFilm(Film film);
public List<Film> getFilmById(int id);
public List<Film> getAllFilms();
public List<Director> getAllDirector();
}
