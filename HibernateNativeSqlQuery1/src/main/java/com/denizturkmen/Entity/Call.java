package com.denizturkmen.Entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "Phone_Call")
public class Call {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "Call_Id")
	private Long id;
	
	@ManyToOne
	@JoinColumn(name = "Phone_Id")
	private Phone phone;
	
	@Column(name = "Call_TimeStamp")
	private Date timestamp;
	
	@Column(name = "duration")
	private int duration;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Phone getPhone() {
		return phone;
	}

	public void setPhone(Phone phone) {
		this.phone = phone;
	}

	public Date getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(Date timestamp) {
		this.timestamp = timestamp;
	}

	public int getDuration() {
		return duration;
	}

	public void setDuration(int duration) {
		this.duration = duration;
	}
	
	
	
}
