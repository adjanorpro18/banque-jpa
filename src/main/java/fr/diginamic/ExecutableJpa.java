package fr.diginamic;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.time.LocalDate;
import java.time.LocalDateTime;

public class ExecutableJpa {
    public static void main(String[] args) {

        EntityManagerFactory factory = Persistence.createEntityManagerFactory("banque");
        EntityManager manager = factory.createEntityManager();

        EntityTransaction transaction = manager.getTransaction();
        transaction.begin(); //Demarrer la transaction

        //Insertion des Banques
        Banque banque1 = new Banque(0,"LCL");
        Banque banque2 = new Banque(0,"Société Générale");
        Banque banque3 = new Banque(0,"BNP Paribas");
        manager.persist(banque1);
        manager.persist(banque2);
        manager.persist(banque3);

        //Insertion des comptes

        Compte compte1 = new Compte(0, "122545",234.90);
        Compte compte2 = new Compte(0, "122555",-25.90);
        Compte compte3 = new Compte(0, "332545",79.66);
        Compte compte4 = new Compte(0, "332565",4.32);
        Compte compte5 = new Compte(0, "332579",1200.05);
        Compte compte6 = new Compte(0, "222545",-19.90);
        manager.persist(compte1);
        manager.persist(compte2);
        manager.persist(compte3);
        manager.persist(compte4);
        manager.persist(compte5);
        manager.persist(compte6);

        //Insertion des clients

        Client client1 = new Client(0,"Dupont", "Eric",LocalDate.of(2000,12,5),new Adresse(1, "Maraichers",  31000, "Toulouse"));
        Client client2 = new Client(0,"HAIDARA", "Moulaye",LocalDate.of(1977,11,15),new Adresse(18, "VilleNeuve",  34000, "Montpellier"));
        Client client3 = new Client(0,"Despois", "Edouard",LocalDate.of(1975,7,4),new Adresse(8, "Champs Elysées",  75000, "Paris"));
        Client client4 = new Client(0,"Marchand", "Coralie",LocalDate.of(1988,03,15),new Adresse(42, "Pontchateau",  44000, "Nantes"));
        manager.persist(client1);
        manager.persist(client2);
        manager.persist(client3);
        manager.persist(client4);

        //Insertion des operations

        Operation operation1 = new Operation(0, LocalDateTime.of(2020,5,23, 15,55,07),-90, "Retrait");
        Operation operation2 = new Operation(0, LocalDateTime.of(2019,5,22, 12,45,15),120, "Depot");
        Operation operation3 = new Operation(0, LocalDateTime.of(2018,11,7, 9,12,22),45, "Depot");
        Operation operation4 = new Operation(0, LocalDateTime.of(2020,7,18, 9,32,00),-250, "Retrait");
        manager.persist(operation1);
        manager.persist(operation2);
        manager.persist(operation3);
        manager.persist(operation4);








        transaction.commit();
        manager.close(); // Pour vider le cache memoire du contexte de persistence

    }
}
