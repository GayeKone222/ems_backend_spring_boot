package net.spring.test.emsbackend.mapper;

import net.spring.test.emsbackend.dto.CompanyDto;
import net.spring.test.emsbackend.entity.Company;

public class CompanyMapper {

    public static CompanyDto mapToCompanyDto(Company company){

        return  new CompanyDto(company.getId(), company.getCompanyName(),  company.getEmployees());
    }

    public static Company mapToCompany(CompanyDto companyDto){

        return  new Company(
                companyDto.getId(),
                companyDto.getCompanyName(),
                companyDto.getEmployees()
        );
    }
}
