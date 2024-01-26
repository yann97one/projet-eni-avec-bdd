package fr.eni.tp.filmotheque.bo;

import jakarta.validation.constraints.*;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Film implements Serializable {
	/**
	 * Numéro de sérialisation
	 */
	private static final long serialVersionUID = 1L;

	@NotNull
	private long id;
	@NotBlank(message = "Le titre ne peut pas être vide")
	@Size( max = 250)
	private String titre;
	@NotNull
	@Min(1900)
	private int annee;
	@Positive
	private int duree;
	@Size(min=20,max = 250)
	private String synopsis;
	@NotNull
	private Participant realisateur;
	private List<Participant> acteurs;
	@NotNull
	private Genre genre;
	private List<Avis> avis;

	{
		realisateur = new Participant();
		genre = new Genre();
		acteurs = new ArrayList<>();
		avis = new ArrayList<>();
	}
	public Film() {

	}

	public Film(String titre, int annee, int duree, String synopsis) {
		this.titre = titre;
		this.annee = annee;
		this.duree = duree;
		this.synopsis = synopsis;
		acteurs = new ArrayList<>();
		avis = new ArrayList<>();
	}

	public Film(long id, String titre, int annee, int duree, String synopsis) {
		this(titre, annee, duree, synopsis);
		this.id = id;
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

	public Participant getRealisateur() {
		return realisateur;
	}

	public void setRealisateur(Participant realisateur) {
		this.realisateur = realisateur;
	}

	public List<Participant> getActeurs() {
		return acteurs;
	}

	public void setActeurs(List<Participant> acteurs) {
		this.acteurs = acteurs;
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

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Film (");
		builder.append(id);
		builder.append(")\n\ttitre : ");
		builder.append(titre);
		builder.append("[annee : ");
		builder.append(annee);
		builder.append(", duree : ");
		builder.append(duree);
		builder.append(" minutes]\n\tSynopsis : ");
		builder.append(synopsis);
		builder.append("\n\trealisateur : ");
		builder.append(realisateur);
		builder.append("\n\tacteurs : ");
		builder.append(acteurs);
		builder.append("\n\tgenre : ");
		builder.append(genre);
		builder.append("\n\tAvis : ");
		builder.append(avis);
		return builder.toString();
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Film other = (Film) obj;
		return id == other.id;
	}

}
