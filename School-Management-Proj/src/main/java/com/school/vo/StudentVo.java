package com.school.vo;

import java.util.List;

import org.springframework.lang.Nullable;

import com.fasterxml.jackson.databind.SerializationFeature;
import com.school.bo.Student;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter

public class StudentVo {

	String enrollment;
	String name;
	String lastName;
    String state;
    String cast;
    String country;
    Boolean married;
    
	List<CourceVo> cource;

	
}
