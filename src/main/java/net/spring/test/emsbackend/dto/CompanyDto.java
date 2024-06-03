package net.spring.test.emsbackend.dto;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import net.spring.test.emsbackend.entity.Employee;
import net.spring.test.emsbackend.entity.EmployeeProfile;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CompanyDto {
    private  Long id;
    private  String companyName;
    private List<Employee> employees;

}
