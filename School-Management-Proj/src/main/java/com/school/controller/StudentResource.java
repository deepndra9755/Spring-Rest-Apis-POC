package com.school.controller;

import java.util.List;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.school.controller.mapper.Mapper;
import com.school.dto.CourceDto;
import com.school.dto.StudentDto;
import com.school.service.IStudentService;
import com.school.vo.CourceVo;
import com.school.vo.StudentVo;

@RestController
@RequestMapping(value = "/api/v1")
public class StudentResource {

	@Autowired
	IStudentService service;

	@PostMapping("/student")
	public StudentVo insertStudent(@RequestBody StudentVo vo) throws Exception {

		StudentDto dto = Mapper.toStudentDto(vo);
		StudentVo studentVo = service.insertStudent(dto);
		return studentVo;
	}

	@GetMapping("/student/{id}")
	public StudentVo getStudentById(@PathVariable("id") String id) throws Exception {

		// service.exist(id);
		StudentVo vo = service.findById(id);
		return vo;
	}

	@GetMapping("/students")
	public List<StudentVo> getAllStudents() throws Exception {
		List<StudentVo> list = service.findAll();
		return list;

	}

	@PutMapping("/student/{id}")
	public StudentVo updateStudent(@PathVariable String id, @RequestBody StudentVo vo) throws Exception {
		service.exist(id);
		StudentDto dto = Mapper.toStudentDto(vo);
		StudentVo studentVo = service.updateStudent(id, dto);

		return studentVo;
	}

	@DeleteMapping("/student/{id}")
	public StudentVo deleteStudent(@PathVariable String id) throws Exception {
		// service.exist(id);
		StudentVo vo = service.deleteStudent(id);
		return vo;

	}

	/*
	 * public ResponseEntity<HttpStatus> deleteStudent(@PathVariable int id){ try {
	 * 
	 * return new ResponseEntity<>(HttpStatus.OK); }catch(Exception e){ return new
	 * ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR); } }
	 */

}
