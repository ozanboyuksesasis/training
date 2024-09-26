package com.example.demo.service;

import com.example.demo.entity.Student;
import com.example.demo.repository.StudentRepository;
import com.example.demo.response.ResponseObj;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class StudentService {

	private final StudentRepository studentRepository;

	public StudentService(StudentRepository studentRepository) {
		this.studentRepository = studentRepository;
	}

	public List<Student> findAll(){
		return studentRepository.findAll();
	}

	@Transactional
	public Student save(Student student) {

		//transaction open
		//operations runs
		//all operations success
		//db ye yansıtıyor
		//runtimeexception bir hata alınırsa rollback olur

		//student.getId() == null // yeni bir kayıt olarak algılar ve create eder
		//student.getId() != null // 1 id li bir ögrenci yolladın
		return studentRepository.save(student);
	}

	public Student updateById(Long id) {
		return null;
	}

	public ResponseObj delete(Long id) {
		Optional<Student> studentOpt = studentRepository.findById(id);

		if (studentOpt.isPresent()){
			studentRepository.deleteById(id);
			return new ResponseObj("Silme işlemi başarıyla gerçekleşti.",true);
		}

		return new ResponseObj("Id bulunamadı",false);
	}
}
