package net.spring.test.emsbackend.dto;


import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import net.spring.test.emsbackend.entity.Company;
import net.spring.test.emsbackend.entity.EmployeeProfile;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class EmployeeDto {
    private  Long id;
    @NotEmpty(message = "Firstname should not be empty")
    private  String firstName;
    @NotEmpty(message = "Lastname should not be empty")
    private String lastName;
    private  String email;
    private Long employee_profile_id;
    private Long company_id;
}
