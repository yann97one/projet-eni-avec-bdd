package fr.eni.tp.filmotheque.dal;

import fr.eni.tp.filmotheque.bo.Membre;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class MembreDaoImpl implements MembreDAO {

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public MembreDaoImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public Membre read(long id) {
        String sql = "SELECT id,nom,prenom,email,admin FROM MEMBRE WHERE id = ?";
        return jdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper<>(Membre.class), id);
    }

    @Override
    public Membre read(String email) {
        String sql = "SELECT id,nom,prenom,email,admin FROM MEMBRE WHERE email = ?";

        return jdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper<>(Membre.class), email);
    }
}
