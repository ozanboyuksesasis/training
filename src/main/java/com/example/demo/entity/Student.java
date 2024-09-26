package com.example.demo.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Data
public class Student {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Long id;

	String name;

	String surname;

	Integer age;

	String tc;

	@OneToMany
	@JoinColumn(name = "student_id", referencedColumnName = "id")
	@JsonIgnore
	List<Address> addressList;

}
