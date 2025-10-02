# Applicazione Console Java: Bacheca dei Messaggi

Questo progetto è un'applicazione a riga di comando sviluppata in Java con Spring Boot e JDBC, che permette di gestire una "Bacheca dei Messaggi" (Guestbook) con persistenza su database locale.


## Funzionamento

L'applicazione permette all'utente di:

- **Aggiungere messaggi**: inserire autore e contenuto di un messaggio.
- **Visualizzare tutti i messaggi**: stampare sulla console i messaggi salvati.
- **Cancellare un messaggio**: rimuovere un messaggio tramite il suo ID.

I dati vengono salvati in una tabella `messages` in un database locale (PostgreSQL o MySQL), garantendo la persistenza anche dopo la chiusura dell'applicazione.

---

## Struttura del Progetto

- **Message.java**: POJO che rappresenta un messaggio con i campi `id`, `author`, `content` e `createdAt`.
- **MessageDao.java**: classe per l'accesso al database tramite `JdbcTemplate` con metodi `findAll()`, `save()` e `deleteById()`.
- **Applicazione principale**: classe con `@SpringBootApplication` e implementazione di `CommandLineRunner`, che gestisce l'interfaccia a riga di comando.
- **application.properties**: configurazione della connessione al database.

