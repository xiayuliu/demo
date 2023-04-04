package com.dzt.test.mapper;

import com.dzt.test.entity.Company;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.ArrayList;

public interface CompanyMapper {


    @Select("select * from company where Company_id=#{companyId} and Contact_Phone")
    Company verify(@Param("companyId") String companyId,@Param("contactPhone") String contactPhone);

    @Select("select * from company")
    ArrayList<Company> getCompanyAll();
}
