package com.example.messagesapp;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class MessageDao {

    private final JdbcTemplate jdbcTemplate;

    // Costruttore
    public MessageDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    // 1. Trova tutti i messaggi
    public List<Message> findAll() {
        String sql = "SELECT * FROM messages";
        return jdbcTemplate.query(sql, (rs, rowNum) -> {
            Message m = new Message();
            m.setId(rs.getLong("id"));
            m.setAuthor(rs.getString("author"));
            m.setContent(rs.getString("content"));
            m.setCreated_at(rs.getTimestamp("created_at").toLocalDateTime());
            return m;
        });
    }

    // 2. Salva un nuovo messaggio
    public void save(Message message) {
        String sql = "INSERT INTO messages (author, content, created_at) VALUES (?, ?, ?)";
        jdbcTemplate.update(sql, message.getAuthor(), message.getContent(), message.getCreated_at());
    }

    // 3. Cancella un messaggio per ID
    public void deleteById(Long id) {
        String sql = "DELETE FROM messages WHERE id = ?";
        jdbcTemplate.update(sql, id);
    }
}
