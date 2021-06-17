package fr.diginamic;

import javax.persistence.*;

/**
 *  Classe Compte
 * @param id qui represente l'identifiant du compte
 * @param numero qui represente le numero du compte
 * @param solde qui represente le solde du compte
 */

@Entity
public class Compte {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column
    private String numero;

    @Column
    private double solde;

    /**
     * Constructeur par defaut
     */
    public Compte() {
    }


}
