package fr.eni.tp.filmotheque.bo;

import java.io.Serializable;
import java.util.Objects;

public class Avis implements Serializable {

    private long id;
    private int note;
    private String commentaire;

    private Membre membre;

    public Avis(int note, Membre membre) {
        this(0, note, null, membre);
    }

    public Avis(int note, String commentaire, Membre membre) {
        this(0, note, commentaire, membre);
    }

    public Avis(long id, int note, String commentaire, Membre membre) {
        this.id = id;
        this.note = note;
        this.commentaire = commentaire;
        this.membre = membre;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public int getNote() {
        return note;
    }

    public void setNote(int note) {
        this.note = note;
    }

    public String getCommentaire() {
        return commentaire;
    }

    public void setCommentaire(String commentaire) {
        this.commentaire = commentaire;
    }

    public Membre getMembre() {
        return membre;
    }

    public void setMembre(Membre membre) {
        this.membre = membre;
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;
        Avis avis = (Avis) object;
        return id == avis.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("\n  📝 Avis de ").append(membre).append(" : \n");
        sb.append("    - ⭐ Note : ").append(note).append("\n");
        sb.append("    - 💬 Commentaire : ").append(commentaire).append("\n");
        return sb.toString();
    }
}
