package fr.diginamic;

import javax.persistence.*;

/**
 * Classe Banque
 * @param nom qui represente le nom de la banque
 */
@Entity
public class Banque {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column
    private String nom;

    /**
     * Constructeur par defaut
     */
    public Banque() {
    }

}
