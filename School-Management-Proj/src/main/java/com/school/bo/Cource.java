package com.school.bo;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@Entity
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Cource {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Integer id;
	String courceName;
	Integer duration;
	String address;
	Integer fees;
	
	/*
	 * @ManyToOne(targetEntity =Customer.class,cascade = CascadeType.ALL,fetch =
	 * FetchType.EAGER)
	 * 
	 * @JoinColumn(name ="custumer_id",referencedColumnName ="customerId") private
	 * Customer customer;
	 * 
	 */
	
	@ManyToOne(targetEntity =Student.class,cascade = CascadeType.ALL)
	 @JoinColumn(name ="student_enrollment",referencedColumnName ="enrollment")
     Student student;	
	

	public Cource(String courceName, Integer duration, String address, Integer fees) {
		super();
		this.courceName = courceName;
		this.duration = duration;
		this.address = address;
		this.fees = fees;
	
	}


	
	
	
	
}
