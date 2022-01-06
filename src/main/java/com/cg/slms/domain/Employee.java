package com.cg.slms.domain;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.Pattern;

/**
 * @author lsq_9905@163.com
 * @date 2021/12/9 21:00
 */
public class Employee {
    private Integer id;
    @Length(max=3,min=1,message="员工编号长度在1-3之间")
    private String code;
    @Length(max=10,min=1,message="员工名称长度在1-10之间")
    private String name;
    @Pattern(regexp="^\\d{4}-\\d{1,2}-\\d{1,2}$",message="日期输入不合法")
    private String birthday;
    private boolean sex;
    @Pattern(regexp="^\\d{10,11}$",message="电话号码必须是10-11位数字")
    private String telephone;
    @Email(message="邮箱地址不合法")
    private String email;



    //以下省略get、set方法
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

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public boolean isSex() {
        return sex;
    }

    public void setSex(boolean sex) {
        this.sex = sex;
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

