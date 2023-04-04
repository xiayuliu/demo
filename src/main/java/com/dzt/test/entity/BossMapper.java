package com.dzt.test.entity;

import com.dzt.test.mapper.CompanyMapper;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

@Component
public class BossMapper {

    @Resource
    public CompanyMapper companyMapper;


    public CompanyMapper getCompanyMapper() {
        return companyMapper;
    }

    public void setCompanyMapper(CompanyMapper companyMapper) {
        this.companyMapper = companyMapper;
    }
}
