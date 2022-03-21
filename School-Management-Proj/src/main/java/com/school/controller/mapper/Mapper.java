package com.school.controller.mapper;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;

import com.school.dto.CourceDto;
import com.school.dto.StudentDto;
import com.school.response.StudentResponse;
import com.school.vo.CourceVo;
import com.school.vo.StudentVo;

public class Mapper {

	public static StudentDto toStudentDto(StudentVo vo) {

		List<CourceDto> cources = new ArrayList<CourceDto>();

		for (CourceVo ob : vo.getCource()) {
			CourceDto obj = new CourceDto();
			obj.setAddress(ob.getAddress());
			obj.setCource(ob.getCourceName());
			obj.setDuration(ob.getDuration());
			obj.setFees(ob.getFees());
			cources.add(obj);
		}

		
		return new StudentDto(vo.getEnrollment(), vo.getName(), vo.getLastName(), vo.getState(), vo.getCast(),
				vo.getCountry(), vo.getMarried(), cources);

	}
}
