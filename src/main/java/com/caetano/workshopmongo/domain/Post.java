package com.caetano.workshopmongo.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.caetano.workshopmongo.DTO.AuthorDTO;
import com.caetano.workshopmongo.DTO.CommentDTO;

@Document
public class Post implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	private String id;
	private Date date;
	private String title;
	private String body;
	private AuthorDTO author;
	
	public Post() {
		
	}


	private List<CommentDTO> comments = new ArrayList<>();
	
	
	public Post(String id, Date date, String title, String body, AuthorDTO author) {
	    this.id = id;
	    this.date = date;
	    this.title = title;
	    this.body = body;
	    this.author = author;
	}



	public String getId() {
		return id;
	}


	public void setId(String id) {
		this.id = id;
	}


	public Date getDate() {
		return date;
	}


	public void setDate(Date date) {
		this.date = date;
	}


	public String getTitle() {
		return title;
	}


	public void setTitle(String title) {
		this.title = title;
	}


	public String getBody() {
		return body;
	}


	public void setBody(String body) {
		this.body = body;
	}


	public AuthorDTO getAutor() {
		return author;
	}


	public void setAutor(AuthorDTO autor) {
		this.author = autor;
	}
	
	public List<CommentDTO> getComments() {
		return comments;
	}



	public void setComments(List<CommentDTO> comments) {
		this.comments = comments;
	}
	


	@Override
	public int hashCode() {
		return Objects.hash(id);
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Post other = (Post) obj;
		return Objects.equals(id, other.id);
	}



	
	
	
}
