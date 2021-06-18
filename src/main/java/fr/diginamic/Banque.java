package fr.diginamic;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

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

    @ManyToMany
    @JoinTable(name ="ClientBanque",
            joinColumns = @JoinColumn(name = "idBanque", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name="idClient", referencedColumnName = "id")
    )
    private Set<Client> clients = new HashSet<>();


    /**
     * Constructeur par defaut
     */
    public Banque() {
    }



    /**
     * Constructeur avec parametre
     * @param id
     * @param nom
     */
    public Banque(int id, String nom) {
        this.id = id;
        this.nom = nom;
    }

    /**
     * @return l'identifaint de la banque
     */
    public int getId() {
        return id;
    }

    /**
     * @param id modifie l'identifiant de la banque
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * @return le nom de la banque
     */
    public String getNom() {
        return nom;
    }

    /**
     * @param nom modifie le nom de la banque
     */
    public void setNom(String nom) {
        this.nom = nom;
    }

    /**
     * @return la liste des cleints associé à la banque
     */
    public Set<Client> getClients() {
        return clients;
    }

    /**
     * @param clients modifie la liste des clients de la banque
     */
    public void setClients(Set<Client> clients) {
        this.clients = clients;
    }
}
