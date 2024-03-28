package com.example.Jobdone.company;

import com.example.Jobdone.Job.Job;

import java.util.List;

public interface CompanyService {

    List<Company> getAllCompanies();

    boolean updateCompany(Company company, Long id);

    void create(Company company);

    //    Company getCompanyById(long id);
//
    boolean deleteCompanyById(long id);

    Company getCompanyById(Long id);

}
