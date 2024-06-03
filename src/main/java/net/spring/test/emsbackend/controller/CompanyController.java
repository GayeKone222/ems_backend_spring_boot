package net.spring.test.emsbackend.controller;


import lombok.AllArgsConstructor;
import net.spring.test.emsbackend.dto.CompanyDto;
import net.spring.test.emsbackend.service.CompanyService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/companies")
@AllArgsConstructor
public class CompanyController {

    private CompanyService companyService;

    // Build Add Company REST API
    @PostMapping
   public ResponseEntity<CompanyDto> createCompany(@RequestBody CompanyDto CompanyDto){

       CompanyDto savedCompany = companyService.createCompany(CompanyDto);

       return  new ResponseEntity<>(savedCompany, HttpStatus.CREATED);
   }


   // Build Get Company REST API
    @GetMapping("{id}")
    public ResponseEntity<CompanyDto> getCompanyById(@PathVariable("id") Long CompanyId){
        CompanyDto CompanyDto = companyService.getCompanyById(CompanyId);

        return  ResponseEntity.ok(CompanyDto);
    }

    // Build GET All Companies REST API
    @GetMapping
    public ResponseEntity<List<CompanyDto>> getAllCompanies(){

        List<CompanyDto> companies = companyService.getAllCompanies();
        return   ResponseEntity.ok(companies);
    }


    //Build Update Company REST API
    @PutMapping("{id}")
    public  ResponseEntity<CompanyDto> updateCompany(@PathVariable("id")  Long CompanyId, @RequestBody CompanyDto updatedCompany){
        CompanyDto CompanyDto = companyService.updateCompany(CompanyId, updatedCompany);

        return    ResponseEntity.ok(CompanyDto);
    }

    //Build Delete Company REST API
    @DeleteMapping("{id}")
    public  ResponseEntity<String> deleteCompany(@PathVariable("id") Long CompanyId ){

        companyService.deleteCompany(CompanyId);

        return  ResponseEntity.ok("Company deleted successfully");
    }

}
