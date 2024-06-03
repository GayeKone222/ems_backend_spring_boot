package net.spring.test.emsbackend.mapper;

import net.spring.test.emsbackend.dto.EmployeeDto;
import net.spring.test.emsbackend.entity.Company;
import net.spring.test.emsbackend.entity.Employee;
import net.spring.test.emsbackend.entity.EmployeeProfile;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class EmployeeMapperTest {


     EmployeeMapper mapper;


    @BeforeEach
    void setUp(){

        mapper = new EmployeeMapper();

    }

    @Test
    public void shouldMapToEmployeeDto(){
        //Given
        EmployeeProfile employeeProfile = new EmployeeProfile();
        employeeProfile.setId(1L);
        Company company = new Company();
        company.setId(1L);
        Employee employee = new Employee(1L,  "gaye","kone", "email@gmail.com", employeeProfile, company);

        //When
        EmployeeDto employeeDto = EmployeeMapper.mapToEmployeeDto(employee);

        //Then
        assertEquals(employeeDto.getFirstName(), employee.getFirstName());
        assertEquals(employeeDto.getLastName(), employee.getLastName());
        assertEquals(employeeDto.getEmail(), employee.getEmail());
        assertNotNull(employeeDto.getEmployee_profile_id());
        assertEquals(employeeDto.getEmployee_profile_id(), employee.getEmployeeProfile().getId());
        assertNotNull(employeeDto.getCompany_id());
        assertEquals(employeeDto.getCompany_id(), employee.getCompany().getId());

    }

    @Test
    public void shouldMapToEmployee() {
    EmployeeDto employeeDto = new EmployeeDto(1L, "gaye", "kone", "email@gmail.com", 1L, 2L);
    Employee employee = EmployeeMapper.mapToEmployee(employeeDto);
        assertEquals(employeeDto.getFirstName(), employee.getFirstName());
        assertEquals(employeeDto.getLastName(), employee.getLastName());
        assertEquals(employeeDto.getEmail(), employee.getEmail());
        assertNotNull(employee.getEmployeeProfile());
        assertEquals(employeeDto.getEmployee_profile_id(), employee.getEmployeeProfile().getId());
        assertNotNull(employee.getCompany());
        assertEquals(employeeDto.getCompany_id(), employee.getCompany().getId());
    }

    @Test
    public void should_throw_NullPointerException_Employee_is_null(){
     var msg =  assertThrows(NullPointerException.class, ()-> EmployeeMapper.mapToEmployeeDto(null)) ;

     assertEquals("Employee shouldn't be null", msg.getMessage() );

    }


    @Test
    public void should_throw_NullPointerException_EmployeeDto_is_null(){
        var msg =   assertThrows(NullPointerException.class, ()-> EmployeeMapper.mapToEmployee(null)) ;
        assertEquals("employeeDto shouldn't be null", msg.getMessage() );

    }
}