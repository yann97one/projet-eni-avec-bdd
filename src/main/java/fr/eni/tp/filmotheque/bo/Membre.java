package fr.eni.tp.filmotheque.bo;

public class Membre extends Personne {

    private String pseudo;
    private String motDePasse;
    private boolean admin;

    public Membre(String nom, String prenom, String pseudo, String motDePasse, boolean admin) {
        this(0, nom, prenom, pseudo, motDePasse, admin);
    }

    public Membre(long id, String nom, String prenom, String pseudo, String motDePasse) {
       this(id, nom, prenom, pseudo, motDePasse, false);
    }

    public Membre(long id, String nom, String prenom, String pseudo, String motDePasse, boolean admin) {
        super(id, nom, prenom);
        this.pseudo = pseudo;
        this.motDePasse = motDePasse;
        this.admin = admin;
    }

    public String getPseudo() {
        return pseudo;
    }

    public void setPseudo(String pseudo) {
        this.pseudo = pseudo;
    }

    public String getMotDePasse() {
        return motDePasse;
    }

    public void setMotDePasse(String motDePasse) {
        this.motDePasse = motDePasse;
    }

    public boolean isAdmin() {
        return admin;
    }

    public void setAdmin(boolean admin) {
        this.admin = admin;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder();
        sb.append(super.toString()).append(" Membre (pseudo =").append(pseudo).append(", admin=").append(admin).append(") ");
        return sb.toString();
    }
}
