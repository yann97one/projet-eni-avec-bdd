package fr.eni.tp.filmotheque.dal;

import fr.eni.tp.filmotheque.bo.Avis;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class AvisDAOImpl implements AvisDAO{

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public AvisDAOImpl(JdbcTemplate jdbcTemplate){
        this.jdbcTemplate = jdbcTemplate;
    }
    @Override
    public void create(Avis avis, long idFilm) {
        String sql = "INSERT INTO AVIS ([note],[commentaire],[id_film]) VALUES(?,?,?)";

        jdbcTemplate.update(sql,avis.getNote(),avis.getCommentaire(),idFilm);
    }

    @Override
    public List<Avis> findByFilm(long idFilm) {
        return jdbcTemplate.query("SELECT * FROM AVIS WHERE id_film = ?",new BeanPropertyRowMapper<>(Avis.class),idFilm);
    }
}
