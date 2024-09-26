package com.example.demo.service;

import com.example.demo.constant.Constant;
import com.example.demo.entity.Address;
import com.example.demo.entity.Student;
import com.example.demo.repository.AddressRepository;
import com.example.demo.repository.StudentRepository;
import com.example.demo.response.ResponseObj;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class AddressService {

	private final AddressRepository addressRepository;
	private final StudentRepository studentRepository;

	public AddressService(AddressRepository addressRepository, StudentRepository studentRepository) {
		this.addressRepository = addressRepository;
		this.studentRepository = studentRepository;
	}

	public List<Address> findAll() {
		return addressRepository.findAll();
	}

	@Transactional
	public ResponseObj save(Address address) {
		if (address.getStudent() == null || (address.getStudent() != null && address.getStudent().getId() == null)){
			return new ResponseObj("Ögrenci boş olamaz.",false,null);
		}

		Optional<Student> existsStudentOpt = studentRepository.findById(address.getStudent().getId());

		if (!existsStudentOpt.isPresent()){
			return new ResponseObj(Constant.Message.StudentMessages.STUDENT_NOT_FOUND,false,null);
		}

		return new ResponseObj(Constant.Message.SAVED_MESSAGE,true,addressRepository.save(address));

	}

	public ResponseObj delete(Long id) {
		Optional<Address> addressOpt = addressRepository.findById(id);

		if (addressOpt.isPresent()){
			addressRepository.deleteById(id);
			return new ResponseObj("Silme işlemi başarıyla gerçekleşti.",true);
		}

		return new ResponseObj("Id bulunamadı",false);
	}

	public ResponseObj findByStudentId(Long studentId) {
		/*Optional<Student> existsStudentOpt = studentRepository.findById(studentId);

		if (!existsStudentOpt.isPresent()){
			return new ResponseObj(Constant.Message.StudentMessages.STUDENT_NOT_FOUND,false,null);
		}*/

		List<Address> addressList = addressRepository.findAllByStudentId(studentId);


		return new ResponseObj(null,true,addressList);

	}

	public ResponseObj findByStudent(Student student) {
		Optional<Student> existsStudentOpt = studentRepository.findById(student.getId());

		if (!existsStudentOpt.isPresent()){
			return new ResponseObj(Constant.Message.StudentMessages.STUDENT_NOT_FOUND,false,null);
		}

		List<Address> addressList = addressRepository.findAllByStudent(student);

		return new ResponseObj(null,true,addressList);

	}
}
