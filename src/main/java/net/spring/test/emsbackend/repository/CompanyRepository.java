package net.spring.test.emsbackend.repository;

import net.spring.test.emsbackend.entity.Company;
import net.spring.test.emsbackend.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CompanyRepository extends JpaRepository<Company, Long> {


}
