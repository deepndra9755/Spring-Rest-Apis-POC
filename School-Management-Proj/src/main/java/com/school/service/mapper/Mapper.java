package com.school.service.mapper;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import javax.persistence.CascadeType;
import javax.persistence.OneToMany;

import com.school.bo.Cource;
import com.school.bo.Student;
import com.school.dto.CourceDto;
import com.school.dto.StudentDto;
import com.school.vo.CourceVo;
import com.school.vo.StudentVo;

import lombok.NonNull;

public class Mapper {

	public static Student toStudent(StudentDto dto) {
		List<Cource> obj = new ArrayList<Cource>();

		for (CourceDto ob : dto.getDto()) {
			Cource crs = new Cource(ob.getCource(), ob.getDuration(), ob.getAddress(), ob.getFees(),
					ob.getCollegeName(),toStringMarks(ob.getMarks()));
			obj.add(crs);
		}

		return new Student(dto.getEnrollment(), dto.getName(), dto.getLastName(), dto.getState(), dto.getCast(),
				dto.getCountry(), dto.getMarried(), obj);
	}

	public static StudentVo toGetStudentVo(Student stud) {
		List<CourceVo> list = new ArrayList<CourceVo>();

		for (Cource ob : stud.getCource()) {
			CourceVo obj = new CourceVo(ob.getId(), ob.getCourceName(), ob.getDuration(), ob.getAddress(), ob.getFees(),
					ob.getCollegeName(), toMap(ob.getMarks()));
			list.add(obj);
		}

		return new StudentVo(stud.getEnrollment(), stud.getName(), stud.getLastName(), stud.getState(), stud.getCast(),
				stud.getCountry(), stud.getMarried(), list);

	}

	public static String toStringMarks(Map<String, Float> obj) {

		String str = obj.entrySet().stream().map(e -> e.getKey() + ":" + e.getValue()).collect(Collectors.joining(","));

		return str;

	}

	public static Map<String, Float> toMap(String str) {
		Map<String, Float> obj = new HashMap<String, Float>();

		String values[] = str.split(str);
		for (String part : values) {

			// split the student data by colon to get the
			// name and roll number
			String stuData[] = part.split(":");

			String subject = stuData[0].trim();
			String marks = stuData[1].trim();

			// Add to map
			obj.put(subject, Float.parseFloat(marks));

		}

		return obj;
	}
}