package fr.eni.tp.filmotheque.dal;

import fr.eni.tp.filmotheque.bo.Genre;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class GenreDAOImpl implements GenreDAO{

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public GenreDAOImpl ( JdbcTemplate jdbcTemplate ) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public Genre read ( long id ) {
        String sql = "SELECT * FROM GENRE WHERE id = ?";
        return jdbcTemplate.queryForObject(sql,Genre.class,id);
    }

    @Override
    public List<Genre> findAll () {
       return jdbcTemplate.queryForList("SELECT * FROM GENRE",Genre.class);
    }
}
