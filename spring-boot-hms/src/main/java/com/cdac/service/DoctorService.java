package com.cdac.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cdac.entity.Doctor;
import com.cdac.exception.DoctorServiceException;
import com.cdac.repository.DoctorRepository;

import java.util.Optional;

@Service
public class DoctorService {

    @Autowired
    private DoctorRepository doctorRepository;

    public Doctor getDoctorById(int id) {
        Optional<Doctor> optionalDoctor = doctorRepository.findById(id);
        if (optionalDoctor.isPresent()) {
            return optionalDoctor.get();
        } else {
            throw new DoctorServiceException("Doctor not found with id: " + id);
        }
    }

    public Doctor createDoctor(Doctor doctor) {
 
        return doctorRepository.save(doctor);
    }

    public Doctor updateDoctor(int id, Doctor updatedDoctor) {
  
        Doctor existingDoctor = getDoctorById(id);

        if (existingDoctor == null) {

            throw new RuntimeException("Doctor with ID " + id + " not found");
        }


        existingDoctor.setName(updatedDoctor.getName());
        existingDoctor.setName(updatedDoctor.getName());
        return doctorRepository.save(existingDoctor);
    }

    public void deleteDoctorById(int id) {

        if (!doctorRepository.existsById(id)) {

            throw new RuntimeException("Doctor with ID " + id + " not found");
        }

        doctorRepository.deleteById(id);
    }
}

