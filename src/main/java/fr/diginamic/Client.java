package fr.diginamic;

import javax.persistence.*;
import java.time.LocalDate;


/**
 * Classe Client
 * @param id l'identifiant du client
 * @param nom le nom du client
 * @param prenom le prenom du client
 * @param dateNaissance la date de naissance du client
 */
@Entity
public class Client {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column
    private String nom;

    @Column
    private String prenom;

    @Column
    private LocalDate dateNaissance;

    @Embedded
    private Adresse adresse;

    /**
     * Constructeur par defaut
     */
    public Client() {
    }
}
