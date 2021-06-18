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

        Operation operation1 = new Operation(0, LocalDateTime.of(2020,5,23, 15,55,07),-90, "Retrait",compte1);
        Operation operation2 = new Operation(0, LocalDateTime.of(2019,5,22, 12,45,15),120, "Depot", compte2);
        Operation operation3 = new Operation(0, LocalDateTime.of(2018,11,7, 9,12,22),45, "Depot",compte3);
        Operation operation4 = new Operation(0, LocalDateTime.of(2020,7,18, 9,32,00),-250, "Retrait",compte4);
        Operation operation5 = new Operation(0, LocalDateTime.of(2021,3,28, 4,30,00),50, "Depot",compte5);
        Operation operation6 = new Operation(0, LocalDateTime.of(2021,2,8, 2,12,00),150, "Dépot",compte6);

        manager.persist(operation1);
        manager.persist(operation2);
        manager.persist(operation3);
        manager.persist(operation4);
        manager.persist(operation5);
        manager.persist(operation6);

        //rattacher Clinet à Compte
        //Insertion d'un compte associé à 2 clients

        client1 = manager.find(Client.class, 1);
        compte1.getClients().add(client1);
        client2 = manager.find(Client.class, 2);
        compte2.getClients().add(client2);
        client3 = manager.find(Client.class, 3);
        compte3.getClients().add(client3);
        client3 = manager.find(Client.class, 3);
        compte4.getClients().add(client3);
        client4 = manager.find(Client.class, 4);
        compte5.getClients().add(client4);
        client4 = manager.find(Client.class, 4);
        compte6.getClients().add(client4);


        //rattacher Client à la Banque

        client1 = manager.find(Client.class, 1);
        banque1.getClients().add(client1);
        client2 = manager.find(Client.class, 2);
        banque1.getClients().add(client2);
        client3 = manager.find(Client.class, 3);
        banque2.getClients().add(client3);
        client3 = manager.find(Client.class, 3);
        banque3.getClients().add(client3);
        client4 = manager.find(Client.class, 4);
        banque3.getClients().add(client4);

        //inserer un compte associéà 2 clients

        Compte compte7 = new Compte(0, "222717",479.27);
        manager.persist(compte7);
        // Associer ce compte à deux clients
        client3.getComptes().add(compte7);
        client4.getComptes().add(compte7);



        //Un client avec plusieurs comptes

        //creons d'abord un compte LivretA
        LivreatA le = new LivreatA(0, "331227",230.45,0.015);
        manager.persist(le);
        //créons l'assuranceVie
        AssuranceVie av = new AssuranceVie(0, "332722", 35, LocalDate.of(2021,02,15),0.015);
        manager.persist(av);
        //rattacher à un client
        client1.getComptes().add(le);
        client1.getComptes().add(av);

        //Inserer des opérations du type virements sur un compte

        Virement v1 = new Virement(0,LocalDateTime.of(2021, 4, 12, 16,59,00),350.00,"Dépot","Dupont");
        Virement v2 = new Virement(0,LocalDateTime.of(2021, 5, 13, 14,30,18),112.75,"Dépot","Dupont");
        manager.persist(v1);
        manager.persist(v2);

            //inserer ces virements sur un compte


        //Inserer des operations du type Operations sur compte





        transaction.commit();
        manager.close(); // Pour vider le cache memoire du contexte de persistence

    }
}
