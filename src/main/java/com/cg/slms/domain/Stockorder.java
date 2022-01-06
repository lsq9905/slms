package com.cg.slms.domain;

import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.Pattern;

/**
 * @author lsq_9905@163.com
 * @date 2021/12/9 21:34
 */
public class Stockorder {
    private Integer id;
    private Employee employee;
    private Merchandise merchandise;
    private Client client;
    @Length(max=3,min=1,message="员工编号长度在1-3之间")
    private String code;
    private int merchandisenumber;
    @Pattern(regexp="^\\d{4}-\\d{1,2}-\\d{1,2}$",message="日期输入不合法")
    private String orderdate;
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public Merchandise getMerchandise() {
        return merchandise;
    }

    public void setMerchandise(Merchandise merchandise) {
        this.merchandise = merchandise;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public int getMerchandisenumber() {
        return merchandisenumber;
    }

    public void setMerchandisenumber(int merchandisenumber) {
        this.merchandisenumber = merchandisenumber;
    }

    public String getOrderdate() {
        return orderdate;
    }

    public void setOrderdate(String orderdate) {
        this.orderdate = orderdate;
    }
}
