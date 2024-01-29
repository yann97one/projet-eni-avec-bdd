package fr.eni.tp.filmotheque.dal;

import fr.eni.tp.filmotheque.bo.Film;
import fr.eni.tp.filmotheque.bo.Genre;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class GenreDAOImpl implements GenreDAO{

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public GenreDAOImpl ( JdbcTemplate jdbcTemplate ) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public Genre read ( long id ) {
        String sql = "SELECT * FROM GENRE WHERE id = ?";
        return jdbcTemplate.queryForObject(sql,new BeanPropertyRowMapper<>(Genre.class), id);
    }

    @Override
    public List<Genre> findAll () {
       return jdbcTemplate.query("SELECT * FROM GENRE",new BeanPropertyRowMapper<>(Genre.class));
    }
}
