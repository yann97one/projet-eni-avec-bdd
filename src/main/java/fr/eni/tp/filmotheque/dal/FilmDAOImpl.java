package fr.eni.tp.filmotheque.dal;

import fr.eni.tp.filmotheque.bo.Film;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class FilmDAOImpl implements FilmDAO{


    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public FilmDAOImpl ( JdbcTemplate jdbcTemplate ) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public int create ( Film film ) {
        String sql = "INSERT INTO [FILM] ([titre],[annee],[id_genre],[id_realisateur],[duree],[synopsis]) VALUES (?,?,?,?,?,?)";
        long idGenre = film.getGenre().getId();

        return jdbcTemplate.update(sql,film.getTitre(),film.getAnnee(),idGenre,film.getRealisateur().getId(),film.getDuree(),film.getSynopsis());
    }

    @Override
    public Film read ( long id ) {
        return jdbcTemplate.queryForObject("SELECT * FROM FILM WHERE id = ?",Film.class,id);
    }

    @Override
    public List<Film> findAll () {
        return jdbcTemplate.queryForList("SELECT * FROM FILM",Film.class);
    }

    @Override
    public String findTitre ( long id ) {
        return jdbcTemplate.queryForObject("SELECT titre FROM FILM WHERE id = ?",String.class,id);
    }
}
