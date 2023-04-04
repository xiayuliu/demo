package com.dzt.test.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import java.io.Serializable;

@Data
@TableName(value = "company")
public class Company implements Serializable {
    private static final long serialVersionUID = -1654878163841315648L;

    public Company() {
    }

    @TableId(type = IdType.NONE)
    private String companyId;

    @TableField(value = "contact_Phone")
    private String contactPhone;//联系电话

    public String getCompanyId() {
        return companyId;
    }

    public void setCompanyId(String companyId) {
        this.companyId = companyId;
    }

    public String getContactPhone() {
        return contactPhone;
    }

    public void setContactPhone(String contactPhone) {
        this.contactPhone = contactPhone;
    }
}
