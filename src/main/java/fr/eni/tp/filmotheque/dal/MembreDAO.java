package fr.eni.tp.filmotheque.dal;

import fr.eni.tp.filmotheque.bo.Membre;

import java.util.List;

public interface MembreDAO {
    public Membre read( long id);
    public Membre read( String email);




}
