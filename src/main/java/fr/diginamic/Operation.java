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

    /**
     * Constructeur par defaut
     */
    public Operation() {
    }


}
