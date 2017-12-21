package com.lrs.boot.solr.repository;

import com.lrs.boot.solr.model.Company;
import org.springframework.data.solr.repository.SolrCrudRepository;

public interface CompanyRepository extends SolrCrudRepository<Company,String> {

}
