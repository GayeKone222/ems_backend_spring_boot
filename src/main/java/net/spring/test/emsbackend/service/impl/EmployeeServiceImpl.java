package net.spring.test.emsbackend.service.impl;

import lombok.AllArgsConstructor;
import net.spring.test.emsbackend.dto.EmployeeDto;
import net.spring.test.emsbackend.entity.Company;
import net.spring.test.emsbackend.entity.Employee;
import net.spring.test.emsbackend.entity.EmployeeProfile;
import net.spring.test.emsbackend.exception.ResourceNotFoundException;
import net.spring.test.emsbackend.mapper.EmployeeMapper;
import net.spring.test.emsbackend.repository.EmployeeRepository;
import net.spring.test.emsbackend.service.EmployeeService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {

    private EmployeeRepository employeeRepository;
    @Override
    public EmployeeDto createEmployee(EmployeeDto employeeDto) {

        Employee employee = EmployeeMapper.mapToEmployee(employeeDto);
        Employee savedEmployee =     employeeRepository.save(employee);
        return EmployeeMapper.mapToEmployeeDto(savedEmployee);
    }

    @Override
    public EmployeeDto getEmployeeById(Long employeeId) {

 Employee employee =      employeeRepository.findById(employeeId).orElseThrow(() -> new ResourceNotFoundException("Employee does not exist with given id : "+ employeeId));
        return EmployeeMapper.mapToEmployeeDto(employee);
    }

    @Override
    public List<EmployeeDto> getAllEmployees() {

      List<Employee> employees =  employeeRepository.findAll();


        // return employees.stream().map((employee) -> EmployeeMapper.mapToEmployeeDto(employee)).collect(Collectors.toList());
          return employees.stream().map(EmployeeMapper::mapToEmployeeDto).collect(Collectors.toList());
    }

    @Override
    public EmployeeDto updateEmployee(Long employeeId, EmployeeDto updatedEmployee) {
        Employee employee =      employeeRepository.findById(employeeId).orElseThrow(() -> new ResourceNotFoundException("Employee does not exist with given id : "+ employeeId));
        employee.setFirstName(updatedEmployee.getFirstName());
        employee.setLastName(updatedEmployee.getLastName());
        employee.setEmail(updatedEmployee.getEmail());
        EmployeeProfile employeeProfile = new EmployeeProfile();
        employeeProfile.setId(updatedEmployee.getEmployee_profile_id());
        employee.setEmployeeProfile(employeeProfile);
        Company company = new Company();
        company.setId(updatedEmployee.getCompany_id());
        employee.setCompany(company);

        Employee updatedEmployeeObj =   employeeRepository.save(employee);

        return EmployeeMapper.mapToEmployeeDto(updatedEmployeeObj);
    }

    @Override
    public void deleteEmployee(Long employeeId) {

        Employee employee =      employeeRepository.findById(employeeId).orElseThrow(() -> new ResourceNotFoundException("Employee does not exist with given id : "+ employeeId));
        employeeRepository.deleteById(employeeId);

    }
}
