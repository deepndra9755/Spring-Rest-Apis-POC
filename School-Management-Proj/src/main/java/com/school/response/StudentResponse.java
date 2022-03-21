package com.school.response;

import org.springframework.lang.Nullable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
public class StudentResponse {

	@Nullable
	Integer id;
	@NonNull
	String name;
	String lastName;
	@NonNull
	String rollNumber;
	@NonNull
	Float marks;
	@NonNull
	Float persentage;

}
