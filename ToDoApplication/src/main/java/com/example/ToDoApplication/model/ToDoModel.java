package com.example.ToDoApplication.model;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="todo-app")
public class ToDoModel {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	@Column
	 private String titile;
	@Column
	 private Date date;
	@Column
	 private String status;

	 
	 public ToDoModel() {
		 
	 }
	
	 @Override
	public String toString() {
		return "ToDoModel [id=" + id + ", titile=" + titile + ", date=" + date + ", status=" + status + "]";
	}

	public ToDoModel(Long id, String titile, Date date, String status) {
		super();
		this.id = id;
		this.titile = titile;
		this.date = date;
		this.status = status;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitile() {
		return titile;
	}

	public void setTitile(String titile) {
		this.titile = titile;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	
}
