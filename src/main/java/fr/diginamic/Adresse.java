package fr.diginamic;

import javax.persistence.*;

/**
 * classe Adresse
 * @param id l'identifiant de l'adresse
 * @param numero le numero de l'adresse
 */
@Embeddable
public class Adresse {


    @Column
    private int numero;

    @Column
    private String rue;

    @Column
    private int codePostal;

    @Column
    private String ville;

    /**
     * Constructeur par défaut
     */
    public Adresse() {
    }

    /**
     * Constructeur avec parametres
     * @param id
     * @param numero
     * @param rue
     * @param codePostal
     * @param ville
     */
    public Adresse(int numero, String rue, int codePostal, String ville) {

        this.numero = numero;
        this.rue = rue;
        this.codePostal = codePostal;
        this.ville = ville;
    }

    /**
     * @return le numero de l'adresse
     */
    public int getNumero() {
        return numero;
    }
    /**
     * @param numero modifie le numero de l'adresse
     */
    public void setNumero(int numero) {
        this.numero = numero;
    }
    /**
     * @return la rue de l'adresse
     */
    public String getRue() {
        return rue;
    }
    /**
     * @param rue modifie la rue de l'adresse
     */
    public void setRue(String rue) {
        this.rue = rue;
    }
    /**
     * @return le code postal de l'adresse
     */
    public int getCodePostal() {
        return codePostal;
    }
    /**
     * @param codepostal modifie le code postal de l'adresse
     */
    public void setCodePostal(int codePostal) {
        this.codePostal = codePostal;
    }
    /**
     * @return la ville de l'adresse
     */
    public String getVille() {
        return ville;
    }
    /**
     * @param ville modifie la ville de l'adresse
     */
    public void setVille(String ville) {
        this.ville = ville;
    }
}
