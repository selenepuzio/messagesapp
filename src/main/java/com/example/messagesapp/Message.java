package com.example.messagesapp;
import java.time.LocalDateTime;

public class Message {
	
	private Long id;
	private String author;
	private String content;
	private LocalDateTime created_at;
	
	//costruttore vuoto
	public Message () {
		//costruttore vuoto richiesto da Spring
		
	}
	
	public Message (Long id, String author, String content,LocalDateTime created_at) {
		this.id= id;
		this.author= author;
		this.content= content;
		this.created_at= created_at;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public LocalDateTime getCreated_at() {
		return created_at;
	}

	public void setCreated_at(LocalDateTime created_at) {
		this.created_at = created_at;
	}
	
}
