package com.entities;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "notes")
public class Note {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String title;
	@Column(length = 1500)
	private String Content;
	private Date createdDate;

	public Note(int id, String title, String content, Date createdDate) {
		super();
		this.id = id;
		this.title = title;
		Content = content;
		this.createdDate = createdDate;
	}

	public Note(String title, String content, Date createdDate) {
		super();
		this.title = title;
		Content = content;
		this.createdDate = createdDate;
	}

	public Note() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Date getCreatedDate() {
		return createdDate;
	}

	public String getContent() {
		return Content;
	}

	public void setContent(String content) {
		Content = content;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

}
