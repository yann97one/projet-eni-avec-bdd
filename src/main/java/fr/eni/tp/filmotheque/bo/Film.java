package fr.eni.tp.filmotheque.bo;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Film {

    private long id;
    private String titre;
    private int annee;
    private int duree;
    private String synopsis;
    private Genre genre;

    private List<Avis> avis;
    private List<Participant> acteurs;
    private Participant realisateur;

    {
        avis = new ArrayList<>();
        acteurs = new ArrayList<>();
    }
    public Film(String titre, int annee, int duree, String synopsis) {
        this.titre = titre;
        this.annee = annee;
        this.duree = duree;
        this.synopsis = synopsis;
    }

    public Film(long id, String titre, int annee, int duree, String synopsis) {
        this.id = id;
        this.titre = titre;
        this.annee = annee;
        this.duree = duree;
        this.synopsis = synopsis;
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

    public int getAnnee() {
        return annee;
    }

    public void setAnnee(int annee) {
        this.annee = annee;
    }

    public int getDuree() {
        return duree;
    }

    public void setDuree(int duree) {
        this.duree = duree;
    }

    public String getSynopsis() {
        return synopsis;
    }

    public void setSynopsis(String synopsis) {
        this.synopsis = synopsis;
    }

    public Genre getGenre() {
        return genre;
    }

    public void setGenre(Genre genre) {
        this.genre = genre;
    }

    public List<Avis> getAvis() {
        return avis;
    }

    public void setAvis(List<Avis> avis) {
        this.avis = avis;
    }

    public List<Participant> getActeurs() {
        return acteurs;
    }

    public void setActeurs(List<Participant> acteurs) {
        this.acteurs = acteurs;
    }

    public Participant getRealisateur() {
        return realisateur;
    }

    public void setRealisateur(Participant realisateur) {
        this.realisateur = realisateur;
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;
        Film film = (Film) object;
        return id == film.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("🎬 Film(").append(id).append(")").append("\n");
        sb.append("- 📌 Titre : ").append(titre).append("\n");
        sb.append("- 📖 Synopsis : ").append(synopsis).append("\n");
        sb.append("- 📅 Annee : ").append(annee).append("\n");
        sb.append("- ⏱ Duree : ").append(convertMinutesToHoursAndMinutes(duree)).append("\n");
        sb.append("- 🎥 Realisateur : ").append(realisateur);
        if(this.acteurs.contains(this.realisateur)) sb.append(" (Aussi acteur)");
        sb.append("\n");
        sb.append("- 🌟 Acteurs : ").append(acteurs.toString()).append("\n");
        sb.append("- 📝 Avis : ").append(getNoteByStar(getAverageNote(avis))).append(avis.toString()).append("\n");
        sb.append("- 🎭 Genre : ").append(genre).append("\n");
        return sb.toString();
    }

    private String convertMinutesToHoursAndMinutes(int minutes) {
        int hours = minutes / 60;
        int remainingMinutes = minutes % 60;
        return hours + "h " + remainingMinutes + "m";
    }

    private double getAverageNote(List<Avis> listAvis){
        double total = 0.0;
        for (Avis avis : listAvis) {
            total += avis.getNote();
        }

        return total / listAvis.size();
    }

    private String getNoteByStar(double note){
        int round = (int) note;

        StringBuilder result = new StringBuilder();

        result.append("⭐".repeat(Math.max(0, round)));

        return result.toString();
    }
}
