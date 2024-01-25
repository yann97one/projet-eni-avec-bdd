package fr.eni.tp.filmotheque.controller.converter;

import fr.eni.tp.filmotheque.bll.FilmService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import fr.eni.tp.filmotheque.bo.Participant;
import org.springframework.stereotype.Component;

@Component
public class StringToParticipantConverter implements Converter<String, Participant> {

    private final FilmService service;

    @Autowired
    public StringToParticipantConverter(FilmService service) {
        this.service = service;
    }

    @Override
    public Participant convert(String idParticipant) {
        return service.consulterParticipantParId(Long.parseLong(idParticipant));
    }
}
