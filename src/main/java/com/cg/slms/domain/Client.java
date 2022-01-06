package com.cg.slms.domain;

import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.Pattern;

/**
 * @author lsq_9905@163.com
 * @date 2021/12/9 21:22
 */
public class Client{
    private Integer id;
    @Length(max=3,min=1,message="员工编号长度在1-3之间")
    private String code;
    private String name;
    private String address;
    @Pattern(regexp="^\\d{10,11}$",message="电话号码必须是10-11位数字")
    private String telephone;
    private String email;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}

