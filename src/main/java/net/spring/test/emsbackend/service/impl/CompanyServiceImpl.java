package net.spring.test.emsbackend.service.impl;

import lombok.AllArgsConstructor;
import net.spring.test.emsbackend.dto.CompanyDto;
import net.spring.test.emsbackend.entity.Company;
import net.spring.test.emsbackend.exception.ResourceNotFoundException;
import net.spring.test.emsbackend.mapper.CompanyMapper;
import net.spring.test.emsbackend.repository.CompanyRepository;
import net.spring.test.emsbackend.service.CompanyService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class CompanyServiceImpl implements CompanyService {

    private CompanyRepository CompanyRepository;
    @Override
    public CompanyDto createCompany(CompanyDto companyDto) {

        Company Company = CompanyMapper.mapToCompany(companyDto);
        Company savedCompany =     CompanyRepository.save(Company);
        return CompanyMapper.mapToCompanyDto(savedCompany);
    }

    @Override
    public CompanyDto getCompanyById(Long companyId) {

 Company Company =      CompanyRepository.findById(companyId).orElseThrow(() -> new ResourceNotFoundException("Company does not exist with given id : "+ companyId));
        return CompanyMapper.mapToCompanyDto(Company);
    }

    @Override
    public List<CompanyDto> getAllCompanies() {

      List<Company> companies =  CompanyRepository.findAll();


        // return Companys.stream().map((Company) -> CompanyMapper.mapToCompanyDto(Company)).collect(Collectors.toList());
          return companies.stream().map(CompanyMapper::mapToCompanyDto).collect(Collectors.toList());
    }

    @Override
    public CompanyDto updateCompany(Long companyId, CompanyDto updatedCompany) {
        Company company =      CompanyRepository.findById(companyId).orElseThrow(() -> new ResourceNotFoundException("Company does not exist with given id : "+ companyId));
        company.setCompanyName(updatedCompany.getCompanyName());
        company.setEmployees(updatedCompany.getEmployees());


        Company updatedCompanyObj =   CompanyRepository.save(company);

        return CompanyMapper.mapToCompanyDto(updatedCompanyObj);
    }

    @Override
    public void deleteCompany(Long CompanyId) {

        Company Company =      CompanyRepository.findById(CompanyId).orElseThrow(() -> new ResourceNotFoundException("Company does not exist with given id : "+ CompanyId));
        CompanyRepository.deleteById(CompanyId);

    }
}
