package fr.diginamic;

import javax.persistence.*;
import java.time.LocalDateTime;

/**
 * Classe Operation
 * @param id qui est l'identifiant de l'opération
 * @param date qui est la date de l'operation
 * @param montant qui est le montant de l'operation
 * @param motif qui est le motif de l'operation
 */

@Entity
public class Operation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id ;

    @Column
    private LocalDateTime date;

    @Column
    private double montant;

    @Column
    private String motif;

    @ManyToOne
    @JoinColumn(name = "idCompte")
    private Compte compte;

    /**
     * Constructeur par defaut
     */
    public Operation() {
    }

    /**
     * Constructeur avec parametres
     * @param id
     * @param date
     * @param montant
     * @param motif
     * @param compte
     */
    public Operation(int id, LocalDateTime date, double montant, String motif) {
        this.id = id;
        this.date = date;
        this.montant = montant;
        this.motif = motif;

    }

    /**
     * @return l'identifiant de l'operation
     */
    public int getId() {
        return id;
    }

    /**
     * @param id modifie l'identifiant de l'operation
     */
    public void setId(int id) {
        this.id = id;
    }
    /**
     * @return la date de l'operation
     */
    public LocalDateTime getDate() {
        return date;
    }
    /**
     * @param id modifie la date de l'operation
     */
    public void setDate(LocalDateTime date) {
        this.date = date;
    }
    /**
     * @return le montant de l'operation
     */
    public double getMontant() {
        return montant;
    }
    /**
     * @param id modifie le montant de l'operation
     */
    public void setMontant(double montant) {
        this.montant = montant;
    }
    /**
     * @return le motif de l'operation
     */
    public String getMotif() {
        return motif;
    }
    /**
     * @param id modifie le motif de l'operation
     */
    public void setMotif(String motif) {
        this.motif = motif;
    }
    /**
     * @return le compte associé à l'operation
     */
    public Compte getCompte() {
        return compte;
    }
    /**
     * @param id modifie le compte associé à l'operation
     */
    public void setCompte(Compte compte) {
        this.compte = compte;
    }
}
