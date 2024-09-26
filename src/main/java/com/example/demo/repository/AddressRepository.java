package com.example.demo.repository;

import com.example.demo.entity.Address;
import com.example.demo.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AddressRepository extends JpaRepository<Address,Long> {

	List<Address> findAllByStudent(Student student);

	@Query("select a from Address a left join fetch a.student where a.student.id =:studentId")
	List<Address> findAllByStudentId(Long studentId);

}
