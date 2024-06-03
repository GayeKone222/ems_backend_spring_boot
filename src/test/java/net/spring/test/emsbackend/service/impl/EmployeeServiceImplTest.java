package net.spring.test.emsbackend.service.impl;

import net.spring.test.emsbackend.dto.EmployeeDto;
import net.spring.test.emsbackend.entity.Employee;
import net.spring.test.emsbackend.mapper.EmployeeMapper;
import net.spring.test.emsbackend.repository.EmployeeRepository;
import net.spring.test.emsbackend.service.EmployeeService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

class EmployeeServiceImplTest {


    //which service we want to test
    @InjectMocks
    private EmployeeService employeeService;

    //declare the dependencies
    @Mock
    private EmployeeRepository employeeRepository;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void should_successfully_create_an_employee(){
        //Given
        EmployeeDto employeeDto = new EmployeeDto(1L, "gaye", "kone", "email@gmail.com", 1L, 2L);
        Employee employee = EmployeeMapper.mapToEmployee(employeeDto);
        Employee savedEmployee = EmployeeMapper.mapToEmployee(employeeDto);;
        savedEmployee.setId(1L);

        //Mock the calls
        when(employeeRepository.save(employee)).thenReturn(savedEmployee);

        //when
        EmployeeDto response = employeeService.createEmployee(employeeDto);


        //then
        assertEquals(employeeDto.getFirstName(), response.getFirstName());
    }
}