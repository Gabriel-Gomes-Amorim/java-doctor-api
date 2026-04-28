package javadoctor.api.modules.doctor.dto;

import java.time.LocalDateTime;

import javadoctor.api.modules.doctor.entity.Specialty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class DoctorDto {
    private Long id;
    private String name;
    private String email;
    private String telephone;
    private String crm;
    private Specialty specialty;
    private AddressDto address;
    private Boolean active;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
