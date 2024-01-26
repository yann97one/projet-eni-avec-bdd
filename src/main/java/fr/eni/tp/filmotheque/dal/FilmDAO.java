package fr.eni.tp.filmotheque.dal;

import fr.eni.tp.filmotheque.bo.Film;

import java.util.List;

public interface FilmDAO {
    public int create( Film film);

    public Film read( long id);

    public List<Film> findAll();

    public String findTitre( long id);
}
