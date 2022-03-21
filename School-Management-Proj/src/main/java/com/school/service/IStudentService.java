package com.school.service;

import java.util.List;

import com.school.controller.Exceptions.RecordNotFoundException;
import com.school.dto.StudentDto;
import com.school.vo.StudentVo;

public interface IStudentService {
	
	
	public StudentVo insertStudent(StudentDto dto) throws Exception;
	public void  exist(String id)throws Exception;
	public StudentVo findById(String id)throws Exception;
	public List<StudentVo> findAll()throws Exception;
	public StudentVo updateStudent(String id,StudentDto dto) throws Exception;
	public StudentVo deleteStudent(String id)throws Exception;
   

}
