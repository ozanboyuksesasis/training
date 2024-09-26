package com.example.demo.controller;

import com.example.demo.entity.Address;
import com.example.demo.entity.Student;
import com.example.demo.service.AddressService;
import com.example.demo.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "address")
@RequiredArgsConstructor
public class AddressController {

	private final AddressService addressService;

	//http requestleri handle eden katman
	//http method : get,post,put,delete

	@GetMapping(path = "find-all")
	public List<Address> findAll(){
		return addressService.findAll();
	}

	@PostMapping(path = "save")
	public ResponseEntity save(@RequestBody Address address){
		return ResponseEntity.ok(addressService.save(address));
	}

	@DeleteMapping("delete/{id}")
	public ResponseEntity delete(@PathVariable Long id){
		return  ResponseEntity.ok(addressService.delete(id));
	}

	@GetMapping("find-by-student-id/{studentId}")
	public ResponseEntity findByStudentId(@PathVariable Long studentId){
		return  ResponseEntity.ok(addressService.findByStudentId(studentId));
	}



}
