package fr.eni.tp.filmotheque.dal;

import fr.eni.tp.filmotheque.bo.Film;
import fr.eni.tp.filmotheque.bo.Genre;
import fr.eni.tp.filmotheque.bo.Participant;
import fr.eni.tp.filmotheque.dal.rowMapper.FilmRowMapper;
import fr.eni.tp.filmotheque.dal.rowMapper.ParticipantRowMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public class FilmDAOImpl implements FilmDAO{


    private  JdbcTemplate jdbcTemplate;
    private  GenreDAOImpl genreDAO;


    public FilmDAOImpl ( JdbcTemplate jdbcTemplate,GenreDAOImpl genreDAO) {
        this.jdbcTemplate = jdbcTemplate;
        this.genreDAO = genreDAO;
    }

    @Override
    public void create ( Film film ) {
        String sql = "INSERT INTO [FILM] ([titre],[annee],[id_genre],[id_realisateur],[duree],[synopsis]) VALUES (?,?,?,?,?,?)";
        long idGenre = film.getGenre().getId();

         jdbcTemplate.update(sql,film.getTitre(),film.getAnnee(),idGenre,film.getRealisateur().getId(),film.getDuree(),film.getSynopsis());
    }

    @Override
    public Film read ( long id ) {
        System.out.println("read");
        Film film = jdbcTemplate.queryForObject("SELECT * FROM FILM WHERE id = ?",new FilmRowMapper(),id);
        if(film != null){
            film.setGenre(genreDAO.read(film.getGenre().getId()));
            film.setRealisateur(consulterParticipantsParId(film.getRealisateur().getId()));
            film.setActeurs(consulterActeursParFilmId(film.getId()));
        }

       return film;
    }

    @Override
    public List<Film> findAll () {
        System.out.println("findAll");
        List<Film> films =  jdbcTemplate.query("SELECT * FROM FILM", new FilmRowMapper());
        for (Film film : films) {
            film.setGenre(genreDAO.read(film.getGenre().getId()));
            film.setRealisateur(consulterParticipantsParId(film.getRealisateur().getId()));

        }

        return films;
    }

    @Override
    public String findTitre ( long id ) {
        System.out.println("findTitre");
        return jdbcTemplate.queryForObject("SELECT titre FROM FILM WHERE id = ?",String.class,id);
    }

    public List<Participant> consulterParticipants(){
        System.out.println("consulterParticipants");
        return jdbcTemplate.query("SELECT * FROM PARTICIPANT",new ParticipantRowMapper());
    }

    public Participant consulterParticipantsParId(long id){
        System.out.println("consulterParticipantsParId");
        String sql = "SELECT * FROM PARTICIPANT WHERE id = ?";
        return jdbcTemplate.queryForObject(sql,new ParticipantRowMapper(),id);
    }

    public List<Participant> consulterActeursParFilmId(long idFilm){
        System.out.println("consulterActeursParId");
        String sql = "SELECT * FROM PARTICIPANT INNER JOIN ACTEURS ON PARTICIPANT.id = ACTEURS.id_participant WHERE ACTEURS.id_film  = ?";
        return jdbcTemplate.query(sql,new ParticipantRowMapper(),idFilm);
    }
}
