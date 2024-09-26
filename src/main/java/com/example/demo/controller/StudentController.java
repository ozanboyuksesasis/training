package com.example.demo.controller;

import com.example.demo.entity.Student;
import com.example.demo.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "student")
@RequiredArgsConstructor
public class StudentController {

	private final StudentService studentService;

	//http requestleri handle eden katman
	//http method : get,post,put,delete

	@GetMapping(path = "find-all")
	public List<Student> findAll(){
		return studentService.findAll();
	}

	@PostMapping(path = "save")
	public Student save(@RequestBody Student student){
		return studentService.save(student);
	}

	@PutMapping(path = "update-by-id")
	public Student updateById(@RequestParam Long id){
		return studentService.updateById(id);
	}

	@DeleteMapping("delete/{id}")
	public ResponseEntity delete(@PathVariable Long id){
		return  ResponseEntity.ok(studentService.delete(id));
	}



}
