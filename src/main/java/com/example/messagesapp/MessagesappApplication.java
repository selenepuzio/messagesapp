package com.example.messagesapp;
import com.example.messagesapp.Message;
import com.example.messagesapp.MessageDao;


import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Scanner;

@SpringBootApplication
public class MessagesappApplication implements CommandLineRunner {

    private final MessageDao messageDao;

    // Costruttore per far iniettare MessageDao da Spring
    public MessagesappApplication(MessageDao messageDao) {
        this.messageDao = messageDao;
    }

    @Override
    public void run(String... args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("1. Aggiungi messaggio");
            System.out.println("2. Visualizza tutti i messaggi");
            System.out.println("3. Cancella un messaggio");
            System.out.println("4. Esci");
            System.out.print("Scelta: ");

            int scelta = scanner.nextInt();
            scanner.nextLine(); // pulisce il buffer

            if (scelta == 1) {
                // --- Aggiungi messaggio ---
                System.out.print("Autore: ");
                String autore = scanner.nextLine();

                System.out.print("Testo: ");
                String testo = scanner.nextLine();

                // QUI DEVE ESSERE CON LA M MAIUSCOLA
                Message nuovo = new Message();
                nuovo.setAuthor(autore);
                nuovo.setContent(testo);
                nuovo.setCreated_at(LocalDateTime.now());

                messageDao.save(nuovo);
                System.out.println("Messaggio salvato!");

            } else if (scelta == 2) {
                // --- Visualizza messaggi ---
                List<Message> messaggi = messageDao.findAll();
                if (messaggi.isEmpty()) {
                    System.out.println("⚠️ Non ci sono ancora messaggi salvati.");
                } 
                for (Message m : messaggi) {
                    System.out.println(m.getId() + " | " + m.getAuthor() + ": " + m.getContent());
                }

            } else if (scelta == 3) {
                // --- Cancella messaggio ---
                System.out.print("ID del messaggio da cancellare: ");
                long id = scanner.nextLong();
                scanner.nextLine(); // pulisce il buffer

                messageDao.deleteById(id);
                System.out.println("Messaggio cancellato!");

            } else if (scelta == 4) {
                System.out.println("Uscita dal programma...");
                break; // esce dal ciclo while
            } else {
                System.out.println("Scelta non valida, riprova.");
            }
        }
    }

    public static void main(String[] args) {
        SpringApplication.run(MessagesappApplication.class, args);
    }
}


