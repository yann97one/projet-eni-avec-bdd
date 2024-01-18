package fr.eni.tp.filmotheque.bo;

import java.io.Serializable;
import java.util.Objects;

public class Genre implements Serializable {

    private long id;
    private String titre;

    public Genre() {}

    public Genre(String titre) {
        this.titre = titre;
    }

    public Genre(long id, String titre) {
        this.id = id;
        this.titre = titre;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;
        Genre genre = (Genre) object;
        return id == genre.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder().append(titre).append(" (").append(id).append(")");
        return sb.toString();
    }
}
