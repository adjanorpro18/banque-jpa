package fr.diginamic;

import javax.persistence.*;

/**
 * classe Adresse
 * @param id l'identifiant de l'adresse
 * @param numero le numero de l'adresse
 */
@Embeddable
public class Adresse {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id ;

    @Column
    private int numero;

    @Column
    private String rue;

    @Column
    private int codePostal;

    @Column
    private String ville;
}
