package fr.diginamic;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

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

    //relation entre Client et compte

    @ManyToMany
    @JoinTable(name ="ClientCompte",
            joinColumns = @JoinColumn(name = "idCompte", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name="idClient", referencedColumnName = "id")
    )
    private Set<Client> clients = new HashSet<>();

    // relation entre compte et operation

    @OneToMany(mappedBy = "compte")
    private Set<Operation> operations;


    /**
     * Constructeur par defaut
     */
    public Compte() {
    }

    /**
     * Constructeur avec parametres
     * @param id l'dentifiant du compte
     * @param numero le numero du compte
     * @param solde le solde du compte
     */

    public Compte(int id, String numero, double solde) {
        this.id = id;
        this.numero = numero;
        this.solde = solde;
    }

    /**
     * @return retourne l'identifiant du compte
     */
    public int getId() {
        return id;
    }

    /**
     * @param id modifie l'identifaint du compte
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * @return retourne le numero du compte
     */
    public String getNumero() {
        return numero;
    }

    /**
     * @param numero modifie le numero du compte
     */
    public void setNumero(String numero) {
        this.numero = numero;
    }

    /**
     * @return retourne le solde du compte
     */
    public double getSolde() {
        return solde;
    }

    /**
     * @param solde modifie le solde du compte
     */
    public void setSolde(double solde) {
        this.solde = solde;
    }

    /**
     * @return retourne l'objet Client associé au compte
     */
    public Set<Client> getClients() {
        return clients;
    }

    /**
     * @param client modifie l'objet Client associé au compte
     */
    public void setClients(Set<Client> clients) {
        this.clients = clients;
    }

    /**
     * @return la liste des operations sur le compte
     */
    public Set<Operation> getOperations() {
        return operations;
    }

    /**
     * @param operations modifie la liste des operations sur le compte
     */
    public void setOperations(Set<Operation> operations) {
        this.operations = operations;
    }
}
