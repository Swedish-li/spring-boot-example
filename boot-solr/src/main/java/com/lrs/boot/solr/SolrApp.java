package com.lrs.boot.solr;

import com.lrs.boot.solr.model.Company;
import com.lrs.boot.solr.repository.CompanyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SolrApp implements CommandLineRunner {

    @Autowired
    private CompanyRepository companyRepository;

    @Override
    public void run(String... args) throws Exception {

        Company newCompany = new Company();
        newCompany.setId("htc");
        newCompany.setCompanyName("HTC Corporation");
        newCompany.setAdress("台湾新竹");
        //newCompany.setVersion("1513825333");

        this.companyRepository.save(newCompany);



        for (Company company: this.companyRepository.findAll()){
            System.out.println(company);
        }

        System.out.println();

        // find by id
        System.out.println("--------------------------------");
        Company htcCompany = this.companyRepository.findOne("htc");

        System.out.println(htcCompany);
        System.out.println();

        // delet by id

        this.companyRepository.delete("htc");

        long count = this.companyRepository.count();

        System.out.println("count=" + count);


    }

    public static void main(String[] args) {
        SpringApplication.run(SolrApp.class,args);
    }
}
