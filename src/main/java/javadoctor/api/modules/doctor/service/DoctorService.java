package javadoctor.api.modules.doctor.service;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jakarta.persistence.EntityNotFoundException;
import javadoctor.api.modules.doctor.dto.DoctorDto;
import javadoctor.api.modules.doctor.entity.Doctor;
import javadoctor.api.modules.doctor.repository.DoctorRepository;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class DoctorService {
    @Autowired
    private DoctorRepository doctorRepository;

    @Autowired
    private ModelMapper modelMapper;

    public DoctorDto create(DoctorDto doctorDto) {
        Doctor doctor = modelMapper.map(doctorDto, Doctor.class);
        doctor.setActive(true);
        Doctor createdDoctor = doctorRepository.save(doctor);
        return modelMapper.map(createdDoctor, DoctorDto.class);
    }

    public DoctorDto getById(Long id) {
        Doctor doctor = doctorRepository.findById(id)
                .orElseThrow(EntityNotFoundException::new);

        return modelMapper.map(doctor, DoctorDto.class);
    }

    public List<DoctorDto> getAll() {
        return doctorRepository.findAll().stream()
                .map(p -> modelMapper.map(p, DoctorDto.class))
                .collect(Collectors.toList());
    }

    public DoctorDto update(Long id, DoctorDto doctorDto) {
        Doctor doctor = doctorRepository.findById(id)
                .orElseThrow(EntityNotFoundException::new);

        doctor.setName(doctorDto.getName());
        doctor.setEmail(doctorDto.getEmail());
        doctor.setTelephone(doctorDto.getTelephone());
        doctor.setCrm(doctorDto.getCrm());
        doctor.setSpecialty(doctorDto.getSpecialty());
        doctor.setAddress(
                modelMapper.map(doctorDto.getAddress(), javadoctor.api.modules.doctor.entity.Address.class));

        Doctor updatedDoctor = doctorRepository.save(doctor);
        return modelMapper.map(updatedDoctor, DoctorDto.class);
    }

    public void delete(Long id) {
        Doctor doctor = doctorRepository.findById(id)
                .orElseThrow(EntityNotFoundException::new);
        doctorRepository.delete(doctor);
    }
}
