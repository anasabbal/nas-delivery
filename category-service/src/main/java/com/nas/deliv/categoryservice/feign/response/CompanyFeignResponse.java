package com.nas.deliv.categoryservice.feign.response;

public class CompanyFeignResponse {
    private String companyName;
    private String companyType;
    private String ceo;

    public CompanyFeignResponse(){

    }
    public CompanyFeignResponse(String companyName, String companyType, String ceo) {
        this.companyName = companyName;
        this.companyType = companyType;
        this.ceo = ceo;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getCompanyType() {
        return companyType;
    }

    public void setCompanyType(String companyType) {
        this.companyType = companyType;
    }

    public String getCeo() {
        return ceo;
    }

    public void setCeo(String ceo) {
        this.ceo = ceo;
    }
}
