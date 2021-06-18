package fr.diginamic;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;


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

    @ManyToMany
    @JoinTable(name ="ClientBanque",
        joinColumns = @JoinColumn(name = "idClient", referencedColumnName = "id"),
        inverseJoinColumns = @JoinColumn(name="idBanque", referencedColumnName = "id")
    )
    private Set<Banque> banques = new HashSet<>();


    @ManyToMany
    @JoinTable(name ="ClientCompte",
            joinColumns = @JoinColumn(name = "idClient", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name="idCompte", referencedColumnName = "id")
    )
    private Set<Compte> comptes = new HashSet<>();

    /**
     * Constructeur par defaut
     */
    public Client() {
    }

    /**
     * Constructeur avec parametres
     * @param id
     * @param nom
     * @param prenom
     * @param dateNaissance
     * @param adresse
     */
    public Client(int id, String nom, String prenom, LocalDate dateNaissance, Adresse adresse) {
        this.id = id;
        this.nom = nom;
        this.prenom = prenom;
        this.dateNaissance = dateNaissance;
        this.adresse = adresse;

    }

    /**
     * @return l'identifiant du client
     */
    public int getId() {
        return id;
    }

    /**
     * @param id modifie l'identifiant du client
     */
    public void setId(int id) {
        this.id = id;
    }
    /**
     * @return le nom du client
     */
    public String getNom() {
        return nom;
    }

    /**
     * @param nom modifie le nom du client
     */
    public void setNom(String nom) {
        this.nom = nom;
    }
    /**
     * @return le prenom du client
     */
    public String getPrenom() {
        return prenom;
    }
    /**
     * @param prenom modifie le prenom du client
     */
    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }
    /**
     * @return la date de naissance du client
     */
    public LocalDate getDateNaissance() {
        return dateNaissance;
    }
    /**
     * @param dateNaissance modifie la date de naissance du client
     */
    public void setDateNaissance(LocalDate dateNaissance) {
        this.dateNaissance = dateNaissance;
    }
    /**
     * @return l'adresse du client
     */
    public Adresse getAdresse() {
        return adresse;
    }
    /**
     * @param id modifie l'adresse du client
     */
    public void setAdresse(Adresse adresse) {
        this.adresse = adresse;
    }
    /**
     * @return la liste des banques du client
     */
    public Set<Banque> getBanques() {
        return banques;
    }
    /**
     * @param id modifie les banques du client
     */
    public void setBanques(Set<Banque> banques) {
        this.banques = banques;
    }
    /**
     * @return la liste des comptes du client
     */
    public Set<Compte> getComptes() {
        return comptes;
    }
    /**
     * @param id modifie les comptes du client
     */
    public void setComptes(Set<Compte> comptes) {
        this.comptes = comptes;
    }
}
