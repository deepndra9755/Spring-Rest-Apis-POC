package com.school.service.mapper;

import java.util.ArrayList;
import java.util.List;

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
			Cource crs = new Cource(ob.getCource(), ob.getDuration(), ob.getAddress(), ob.getFees());
			obj.add(crs);
		}

		return new Student(dto.getEnrollment(), dto.getName(), dto.getLastName(), dto.getState(), dto.getCast(),
				dto.getCountry(), dto.getMarried(), obj);
	}

	public static StudentVo toGetStudentVo(Student stud) {
		List<CourceVo> list = new ArrayList<CourceVo>();

		for (Cource ob : stud.getCource()) {
			CourceVo obj = new CourceVo(ob.getId(), ob.getCourceName(), ob.getDuration(), ob.getAddress(),
					ob.getFees());
			list.add(obj);
		}

		return new StudentVo(stud.getEnrollment(), stud.getName(), stud.getLastName(),
				stud.getState(), stud.getCast(), stud.getCountry(), stud.getMarried(), list);

	}

}