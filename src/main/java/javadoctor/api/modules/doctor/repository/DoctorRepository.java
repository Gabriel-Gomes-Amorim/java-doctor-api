package javadoctor.api.modules.doctor.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import javadoctor.api.modules.doctor.entity.Doctor;

public interface DoctorRepository extends JpaRepository<Doctor, Long> {
}
