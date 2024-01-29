package fr.eni.tp.filmotheque.dal.rowMapper;

import fr.eni.tp.filmotheque.bo.Film;

import fr.eni.tp.filmotheque.bo.Genre;
import fr.eni.tp.filmotheque.bo.Participant;
import org.springframework.jdbc.core.RowMapper;

import javax.swing.tree.TreePath;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class FilmRowMapper implements RowMapper<Film> {

    @Override
    public Film mapRow(ResultSet rs, int rowNum) throws SQLException {
        Film film = new Film();
        film.setId(rs.getLong("id"));
        film.setTitre(rs.getString("titre"));
        film.setAnnee(rs.getInt("annee"));
        film.setDuree(rs.getInt("duree"));
        film.setSynopsis(rs.getString("synopsis"));

        Genre genre = new Genre();
        genre.setId(rs.getLong("id_genre"));
        film.setGenre(genre);
        Participant realisateur = new Participant();
        realisateur.setId(rs.getLong("id_realisateur"));

        film.setRealisateur(realisateur);
        return film;
    }
}
