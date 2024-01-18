package fr.eni.tp.filmotheque.bo;

import java.io.Serializable;
import java.util.Objects;

public abstract class Personne implements Serializable {

    protected long id;
    protected String nom;
    protected String prenom;

    public Personne() {}

    public Personne(String nom, String prenom) {
        this(0, nom, prenom);
    }

    public Personne(long id, String nom, String prenom) {
        this.id = id;
        this.nom = nom;
        this.prenom = prenom;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;
        Personne personne = (Personne) object;
        return id == personne.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder();
        sb.append(prenom).append(' ').append(nom).append(" (").append(id).append(')');;
        return sb.toString();
    }
}
