package com.school.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.school.bo.Cource;
import com.school.bo.Student;
import com.school.controller.Exceptions.RecordNotFoundException;
import com.school.dao.IStudentDao;
import com.school.dto.StudentDto;
import com.school.service.mapper.Mapper;
import com.school.vo.StudentVo;

@Service
public class IStudentServiceImpl implements IStudentService {

	@Autowired
	private IStudentDao student;

	@Override
	public StudentVo insertStudent(StudentDto dto) throws Exception {
		// TODO Auto-generated method stub
		try {
			Student stud = Mapper.toStudent(dto);
			
			Student stud2 = student.save(stud);
			if (stud2.getEnrollment().equals(dto.getEnrollment()))
				return Mapper.toGetStudentVo(stud2);
			else
				throw new RecordNotFoundException("not inserted");
		} catch (Exception e) {
			// TODO: handle exception
			throw e;
		}

	}

	@Override
	public void exist(String id) throws Exception {
		// TODO Auto-generated method stub
		if (student.exist(id)==0) {
			throw new RecordNotFoundException("record not there");
		}
	}
	

	public StudentVo findById(String id) throws Exception {
		// TODO Auto-generated method stub
		try {
			Optional<Student> optional = student.findByEnrollmett(id);
			if (optional.isPresent()) {
				return Mapper.toGetStudentVo(optional.get());
			} else
				throw new RecordNotFoundException("record not found");
		} catch (Exception e) {
			// TODO: handle exception
			throw e;
		}

	}

	@Override
	public List<StudentVo> findAll() throws Exception {
		// TODO Auto-generated method stub
		try {

			List<Student> list = student.findAllStudents();
			if (!list.isEmpty()) {
				List<StudentVo> studentList = new ArrayList<StudentVo>();
				for (Student localList : list) {
					studentList.add(Mapper.toGetStudentVo(localList));
				}
				return studentList;
			}
			throw new RecordNotFoundException("no record");
		} catch (Exception e) {
			// TODO: handle exception
			throw e;
		}

	}

	@Override
	@Transactional
	public StudentVo updateStudent(String id, StudentDto dto) throws Exception {
		// TODO Auto-generated method stub

		try {
			Student stud = Mapper.toStudent(dto);
			Optional<Student> optional = student.findByEnrollmett(id);
			if (optional.isPresent()) {
                  Student st=optional.get();
				return Mapper.toGetStudentVo(student.save(stud));
			} else
				throw new RecordNotFoundException("no record");
		} catch (Exception e) {
			// TODO: handle exception
			throw e;
		}

	}

	

	
	  @Override 
	  @Transactional
	  public StudentVo deleteStudent(String id) throws Exception { // TODO Auto-generated method stub 
		  try {
	  
	  Optional<Student> optional = student.findByEnrollmett(id); 
	  if (optional.isPresent())
	  { student.delete(optional.get());
	  return Mapper.toGetStudentVo(optional.get()); } 
	  else
		  throw new RecordNotFoundException("record is not there");

	  
	  } catch (Exception e) { 
		  throw e;
		  }
	  
	  }
	  
	  
	 

	  }

