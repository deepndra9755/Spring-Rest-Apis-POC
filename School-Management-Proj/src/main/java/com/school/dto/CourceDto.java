package com.school.dto;

import java.util.Map;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.Setter;
import lombok.ToString;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class CourceDto {
    
	Integer id;
	String enrollment;
	String cource;
	Integer duration;
	String address;
	Integer fees;
	String collegeName;
	Map<String,Float> marks;
}
