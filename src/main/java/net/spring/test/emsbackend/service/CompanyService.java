package net.spring.test.emsbackend.service;

import net.spring.test.emsbackend.dto.CompanyDto;

import java.util.List;

public interface CompanyService {

    CompanyDto createCompany(CompanyDto companyDto);
    CompanyDto getCompanyById(Long companyId);

    List<CompanyDto> getAllCompanies();

    CompanyDto updateCompany(Long companyId, CompanyDto updatedCompany);

    void deleteCompany(Long companyId);

}
