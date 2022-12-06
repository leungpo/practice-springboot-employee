package com.afs.company;

import com.afs.employee.Employee;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/companies")
public class CompanyController {


    private CompanyRepository companyRepository;

    public CompanyController(CompanyRepository companyRepository) {
        this.companyRepository = companyRepository;
    }

    @GetMapping
    public List<Company> getAll(){
        return companyRepository.findAll();
    }

    @GetMapping("/{id}")
    public Company getByID(@PathVariable int id){
        return companyRepository.findById(id);
    }

    @GetMapping(params = {"page","pageSize"})
    public List<Company> getPageOfEmployees(@RequestParam Integer page, @RequestParam Integer pageSize){
        return companyRepository.findByPage(page, pageSize);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Company addCompany(@RequestBody Company company){
        return companyRepository.create(company);
    }
}