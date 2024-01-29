package fr.eni.tp.filmotheque.dal;

import fr.eni.tp.filmotheque.bo.Participant;
import fr.eni.tp.filmotheque.dal.rowMapper.ParticipantRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ParticipantDAOImpl implements ParticipantDAO{

    private final JdbcTemplate jdbcTemplate;

    public ParticipantDAOImpl ( JdbcTemplate jdbcTemplate ) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public Participant read ( long id ) {
        String sql = "SELECT * FROM PARTICIPANT WHERE id = ?";
        return jdbcTemplate.queryForObject(sql,new ParticipantRowMapper(), id);
    }

    @Override
    public List<Participant> findAll () {
        String sql = "SELECT * FROM PARTICIPANT";
        return jdbcTemplate.query(sql,new ParticipantRowMapper());
    }

    @Override
    public List<Participant> findActeurs ( long idFilm ) {
        String sql = "SELECT * FROM PARTICIPANT INNER JOIN ACTEUR ON PARTICIPANT.id = ACTEUR.id_participant WHERE id_film = ?";
        return jdbcTemplate.query(sql,new ParticipantRowMapper(),idFilm);
    }

    @Override
    public void createActeur ( long idParticipant, long idFilm ) {
        String sql = "INSERT INTO ACTEUR (id_participant,id_film) VALUES (?,?)";
        jdbcTemplate.update(sql,idParticipant,idFilm);
    }
}
