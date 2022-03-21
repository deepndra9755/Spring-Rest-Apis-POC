package com.school.dao;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.school.bo.Student;	

@Repository("studentRepo")
public interface IStudentDao extends JpaRepository<Student, Integer> {
	
	@Query("from com.school.bo.Student where enrollment=:enrollment")
	public Optional<Student> findByEnrollmett(@Param("enrollment") String enrollment);

	@Query("from com.school.bo.Student")
	public List<Student> findAllStudents();
	
	@Query("from com.school.bo.Student where enrollment=:enrollment")
	public Student findByEnroll(@Param("enrollment") String enrollment);
	
	@Query("SELECT COUNT(*) FROM Student WHERE enrollment =:enrollment")
	public Integer exist(@Param("enrollment") String enrollment);
	
	
	
	
	
	


	
	
	
}
