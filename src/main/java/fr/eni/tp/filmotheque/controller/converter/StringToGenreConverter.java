package fr.eni.tp.filmotheque.controller.converter;

import fr.eni.tp.filmotheque.bll.FilmService;
import fr.eni.tp.filmotheque.bo.Genre;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class StringToGenreConverter implements Converter<String, Genre> {

    private final FilmService service;

    @Autowired
    public StringToGenreConverter(FilmService service) {
        this.service = service;
    }

    @Override
    public Genre convert(String idGenre) {
        return service.consulterGenreParId(Long.parseLong(idGenre));
    }
}
