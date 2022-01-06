package com.cg.slms.domain;

import org.hibernate.validator.constraints.Length;

/**
 * @author lsq_9905@163.com
 * @date 2021/12/9 21:18
 */
public class Merchandise {
    private Integer id;
    @Length(max=3,min=1,message="员工编号长度在1-3之间")
    private String code;
    private String name;
    private float price;

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

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }
}

