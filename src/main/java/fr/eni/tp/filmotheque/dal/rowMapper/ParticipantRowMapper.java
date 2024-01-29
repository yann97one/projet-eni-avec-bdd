package fr.eni.tp.filmotheque.dal.rowMapper;

import fr.eni.tp.filmotheque.bo.Participant;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ParticipantRowMapper implements RowMapper<Participant> {
    @Override
    public Participant mapRow(ResultSet rs, int rowNum) throws SQLException {
        Participant participant = new Participant();
        participant.setId(rs.getLong("id"));
        participant.setNom(rs.getString("nom"));
        participant.setPrenom(rs.getString("prenom"));
        return participant;
    }
}
