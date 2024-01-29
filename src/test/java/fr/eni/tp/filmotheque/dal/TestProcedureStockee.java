package fr.eni.tp.filmotheque.dal;

import fr.eni.tp.filmotheque.bo.Film;
import fr.eni.tp.filmotheque.bo.Participant;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class TestProcedureStockee {

    @Autowired private final FilmDAOImpl filmDAO;

    public TestProcedureStockee(FilmDAOImpl filmDAO) {
        this.filmDAO = filmDAO;
    }

    @Test
    void TestProcedureStockee() {
        Film film = filmDAO.read(1);
        List<Participant> acteurs = film.getActeurs();
    }
}
