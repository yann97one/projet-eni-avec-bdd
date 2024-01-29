package fr.eni.tp.filmotheque.bll;

import fr.eni.tp.filmotheque.bo.Avis;
import fr.eni.tp.filmotheque.bo.Film;
import fr.eni.tp.filmotheque.bo.Genre;
import fr.eni.tp.filmotheque.bo.Participant;
import fr.eni.tp.filmotheque.dal.FilmDAOImpl;
import fr.eni.tp.filmotheque.dal.GenreDAOImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.List;

@Primary
@Service
public class FilmServiceImpl implements  FilmService{


    private  FilmDAOImpl filmDAO;
    private  GenreDAOImpl genreDAO;


    public FilmServiceImpl(FilmDAOImpl filmDAO,GenreDAOImpl genreDAO){
        this.filmDAO = filmDAO;
        this.genreDAO = genreDAO;
    }
    @Override
    public List<Film> consulterFilms() {
        return filmDAO.findAll();
    }

    @Override
    public Film consulterFilmParId(long id) {
        return filmDAO.read(id);
    }

    @Override
    public List<Genre> consulterGenres() {
        return genreDAO.findAll();
    }

    @Override
    public List<Participant> consulterParticipants() {
        return filmDAO.consulterParticipants();
    }

    @Override
    public Genre consulterGenreParId(long id) {
        return genreDAO.read(id);
    }

    @Override
    public Participant consulterParticipantParId(long id) {
        return filmDAO.consulterParticipantsParId(id);
    }

    @Override
    public void creerFilm(Film film) {

    }

    @Override
    public String consulterTitreFilm(long id) {
        return filmDAO.findTitre(id);
    }

    @Override
    public void publierAvis(Avis avis, long idFilm) {

    }

    @Override
    public List<Avis> consulterAvis(long idFilm) {
        return null;
    }
}

