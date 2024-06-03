package net.spring.test.emsbackend.mapper;

import net.spring.test.emsbackend.dto.EmployeeDto;
import net.spring.test.emsbackend.entity.Company;
import net.spring.test.emsbackend.entity.Employee;
import net.spring.test.emsbackend.entity.EmployeeProfile;

public class EmployeeMapper {



    public static EmployeeDto mapToEmployeeDto(Employee employee){
        if(employee == null){
            throw new NullPointerException("Employee shouldn't be null");
        }
        EmployeeProfile employeeProfile = employee.getEmployeeProfile();
        Long employeeProfileId = employeeProfile == null ? null : employeeProfile.getId();
        Company company = employee.getCompany();
        Long companyId = company == null ? null : company.getId();
        return  new EmployeeDto(employee.getId(), employee.getFirstName(), employee.getLastName(), employee.getEmail(), employeeProfileId, companyId);
    }

    public static Employee mapToEmployee(EmployeeDto employeeDto){
        if(employeeDto == null){
            throw new NullPointerException("employeeDto shouldn't be null");
        }
        EmployeeProfile employeeProfile = new EmployeeProfile();
        employeeProfile.setId(employeeDto.getEmployee_profile_id());
        Company company = new Company();
        company.setId(employeeDto.getCompany_id());
        return  new Employee(
                employeeDto.getId(),
                employeeDto.getFirstName(),
                employeeDto.getLastName(),
                employeeDto.getEmail(),
                employeeProfile,
                company
        );
    }
}
