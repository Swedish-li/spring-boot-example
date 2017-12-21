package com.lrs.boot.solr.model;

import org.apache.solr.client.solrj.beans.Field;
import org.springframework.data.annotation.Id;
import org.springframework.data.solr.core.mapping.SolrDocument;

@SolrDocument(solrCoreName = "gettingstarted")
public class Company {

    @Id
    @Field
    private String id;

    @Field("compName_s")
    private String companyName;

    @Field("address_s")
    private String adress;

    @Field("_version_")
    private String version;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getAdress() {
        return adress;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    @Override
    public String toString() {
        return "Company{" +
                "id='" + id + '\'' +
                ", companyName='" + companyName + '\'' +
                ", adress='" + adress + '\'' +
                ", version='" + version + '\'' +
                '}';
    }
}
