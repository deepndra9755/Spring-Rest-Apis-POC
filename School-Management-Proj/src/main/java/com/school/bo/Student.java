package com.school.bo;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.Setter;
import lombok.ToString;

@Entity
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString

public class Student {

	@Id
	@NonNull
	String enrollment;
	String name;
	String lastName;
    String state;
    String cast;
    String country;
    Boolean married;
    
	/*
	 * @OneToMany(targetEntity =NetworkOperator.class,cascade =
	 * CascadeType.ALL,fetch =FetchType.LAZY)
	 * 
	 * @JoinColumn(name ="custumer_id",referencedColumnName ="customerId")
	 */
    @OneToMany(targetEntity =Cource.class,cascade = CascadeType.ALL,fetch =FetchType.LAZY)
	 @JoinColumn(name ="student_enrollment",referencedColumnName ="enrollment")

	List<Cource> cource;
    
	

	public Student(String enrollment, @NonNull String name, String lastName, String state, String cast, String country,
			Boolean married) {
		super();
		this.enrollment = enrollment;
		this.name = name;
		this.lastName = lastName;
		this.state = state;
		this.cast = cast;
		this.country = country;
		this.married = married;
	}

    
	
	

}
