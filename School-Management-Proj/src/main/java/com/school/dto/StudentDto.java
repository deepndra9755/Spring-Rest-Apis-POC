package com.school.dto;

import java.io.Serializable;
import java.util.List;

import org.springframework.lang.Nullable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;

@AllArgsConstructor
@Setter
@Getter
public class StudentDto implements Serializable {

	@NonNull
	String enrollment;
	String name;
	String lastName;
    String state;
    String cast;
    String country;
    Boolean married;
	List<CourceDto> dto;
	
	
	
	

	
	
	

}
