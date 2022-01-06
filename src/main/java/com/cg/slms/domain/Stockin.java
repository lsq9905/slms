package com.cg.slms.domain;

import org.hibernate.validator.constraints.Length;

/**
 * @author lsq_9905@163.com
 * @date 2021/12/9 21:56
 */
public class Stockin {
    private Integer id;
    private Merchandise merchandise;
    private Client client;
    private Employee employee;
    @Length(max=3,min=1,message="员工编号长度在1-3之间")
    private String code;
    private int amount;
    private float price;
    private float money;
    private String stockindate;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public float getMoney() {
        return money;
    }

    public void setMoney(float money) {
        this.money = money;
    }

    public String getStockindate() {
        return stockindate;
    }

    public void setStockindate(String stockindate) {
        this.stockindate = stockindate;
    }
}
