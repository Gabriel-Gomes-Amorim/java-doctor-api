package javadoctor.api.modules.doctor.service;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Page;

import javadoctor.api.exceptions.DuplicateResourceException;
import javadoctor.api.exceptions.ResourceNotFoundException;
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
        if (doctorRepository.existsByEmail(doctorDto.getEmail()))
            throw new DuplicateResourceException("Doctor", "email");

        if (doctorRepository.existsByCrm(doctorDto.getCrm()))
            throw new DuplicateResourceException("Doctor", "crm");

        Doctor doctor = modelMapper.map(doctorDto, Doctor.class);
        doctor.setActive(true);
        return modelMapper.map(doctorRepository.save(doctor), DoctorDto.class);
    }

    public DoctorDto getById(Long id) {
        Doctor doctor = doctorRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Doctor"));

        return modelMapper.map(doctor, DoctorDto.class);
    }

    public Page<DoctorDto> getAll(Pageable pageable) {
        return doctorRepository.findAll(pageable)
                .map(doctor -> modelMapper.map(doctor, DoctorDto.class));
    }

    public DoctorDto update(Long id, DoctorDto doctorDto) {
        Doctor doctor = doctorRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Doctor"));

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
                .orElseThrow(() -> new ResourceNotFoundException("Doctor"));

        doctorRepository.delete(doctor);
    }
}
