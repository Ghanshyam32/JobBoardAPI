package com.example.Jobdone.company.impl;

import com.example.Jobdone.Job.Job;
import com.example.Jobdone.company.Company;
import com.example.Jobdone.company.CompanyRepository;
import com.example.Jobdone.company.CompanyService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CompanyServiceImplementation implements CompanyService {

    private CompanyRepository companyRepository;

    public CompanyServiceImplementation(CompanyRepository companyRepository) {
        this.companyRepository = companyRepository;
    }

    @Override
    public List<Company> getAllCompanies() {
        return companyRepository.findAll();
    }

    @Override
    public boolean updateCompany(Company company, Long id) {
        Optional<Company> companyOptional = companyRepository.findById(id);
        if (companyOptional.isPresent()) {
            Company companyToUpdate = companyOptional.get();
            companyToUpdate.setDescription(company.getDescription());
            companyToUpdate.setName(companyToUpdate.getName());
            companyToUpdate.setJobs(companyToUpdate.getJobs());
            companyRepository.save(companyToUpdate);
            return true;
        } else {
            return false;
        }
    }

    @Override
    public void create(Company company) {
        companyRepository.save(company);
    }

}
